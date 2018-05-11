package ch.uzh.ifi.seal.soprafs18.service;

import ch.uzh.ifi.seal.soprafs18.constant.GameConstants;
import ch.uzh.ifi.seal.soprafs18.constant.GameStatus;
import ch.uzh.ifi.seal.soprafs18.entity.Game;
import ch.uzh.ifi.seal.soprafs18.entity.Player;
import ch.uzh.ifi.seal.soprafs18.entity.card.*;
import ch.uzh.ifi.seal.soprafs18.entity.map.Blockade;
import ch.uzh.ifi.seal.soprafs18.entity.map.Space;
import ch.uzh.ifi.seal.soprafs18.repository.GameRepository;
import ch.uzh.ifi.seal.soprafs18.repository.PlayerRepository;
import ch.uzh.ifi.seal.soprafs18.web.rest.GameResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static ch.uzh.ifi.seal.soprafs18.constant.GameStatus.ROOM;

/**
 * Created by Lucas Pelloni on 26.01.18.
 * Service class for managing games, which contains the logic and all DB calls.
 */
@Service
@Transactional
public class GameService {

    //private final Logger log = LoggerFactory.getLogger(PlayerService.class);

    private final GameRepository gameRepository;

    private final PlayerRepository playerRepository;

    Logger logger = LoggerFactory.getLogger(GameResource.class);

    @Autowired
    public GameService(GameRepository gameRepository, PlayerRepository playerRepository) {
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
    }

    public List<Game> listGames() {
        List<Game> result = new ArrayList<>();
        gameRepository.findAll().forEach(result::add);
        return result;
    }

    public Game addGame(Game game) {
    	if(game != null && game.getPlayers() != null && game.getPlayers().size() != 0
				&& game.getPlayers().get(0).getName().length() < 9) {
			game.getPlayers().get(0).setColor("red");
			game.getPlayers().get(0).setReady(true);
			game.getPlayers().get(0).setToken(UUID.randomUUID().toString());
			Game serverSideGame = gameRepository.save(game);
			serverSideGame.getPlayers().get(0).setGameId(serverSideGame.getId());
			serverSideGame.setName(serverSideGame.getPlayers().get(0).getName() + "'s Game");
			return gameRepository.save(serverSideGame);
		}
		else {
			throw new IllegalArgumentException("No leader in body or leader name too long.");
		}
    }

    public Game getGame(Long gameId) {
        Optional<Game> game = gameRepository.findById(gameId);
        return game.orElse(null);
    }

	// return a list of players in a game
	public List<Player> listPlayers(Long gameId) {
		Optional<Game> game = gameRepository.findById(gameId);
		if (game.isPresent()) {
			return game.get().getPlayers();
		}
		else {
			throw new RuntimeException("Game does not exist");
		}
	}

	public Player addPlayer(Long gameId, Player player) {
		Optional<Game> game = gameRepository.findById(gameId);

		if (game.isPresent()) {
			game.get().getPlayers().removeAll(Collections.singleton(null));
			int numberOfPlayers = game.get().getPlayers().size();

			// Add player to playerRepository
			if (game.get().getStatus() == ROOM && numberOfPlayers < GameConstants.MAX_PLAYERS
					&& player.getName().length() < 9){
				if (player.getId() == null) {
					player.setGameId(gameId);

					//color upon entering a room
					String colorToSet = "red";
					for (Player p : game.get().getPlayers()) {
						if (p.getColor().equals("red")) {
							colorToSet = "blue";

							for (Player p2 : game.get().getPlayers()) {
								if (p2.getColor().equals("blue")) {
									colorToSet = "yellow";

									for (Player p3 : game.get().getPlayers()) {
										if (p3.getColor().equals("yellow")) {
											colorToSet = "white";
											break;
										}
									}

									break;
								}
							}

							break;
						}
					}
					player.setColor(colorToSet);

					playerRepository.save(player);

					game.get().addPlayer(player);

					this.logger.debug("Game: " + game.get().getName() + " - player added: " + player.getName());
					return playerRepository.save(player);
				}
				else {
					throw new RuntimeException("Error adding player. No Id could be allocated to player.");
				}
			}
			else {
				throw new RuntimeException("Game is running or player name too long.");
			}
		}
		else {
			throw new RuntimeException("Error adding player. Game does not exist.");
		}
	}

	public Player getPlayer(Long gameId, Long playerId) {
		Optional<Game> game = gameRepository.findById(gameId);
		Optional<Player> player = playerRepository.findById(playerId);
		if (game.isPresent() && player.isPresent()) {
			return player.get();
		}
		else {
			throw new RuntimeException("Game or player do not exist.");
		}
	}

    public Game updateGame(Long gameId, Game game){
		Optional<Game> serverSideGame = gameRepository.findById(gameId);

		if (serverSideGame.isPresent()){
			switch(serverSideGame.get().getStatus()){
				case ROOM:
					serverSideGame.get().setName(game.getName());
					serverSideGame.get().setMapName(game.getMapName());
					serverSideGame.get().setTurnTime(game.getTurnTime());

					//Checks first if there are at least 2 players in the room. Checks then if all players are ready.
					//If all of them are ready and the leader pressed the Start Game button, the game will start.
					if (serverSideGame.get().getPlayers().size() >= GameConstants.MIN_PLAYERS) {
						boolean allPlayersReady = true;
						for(Player p: serverSideGame.get().getPlayers()){
							if (!(p.getReady())){
								allPlayersReady = false;
							}
						}

						//If all players are ready, the leaders request to set the game status to PENDING is accepted.
						if(allPlayersReady) {
							serverSideGame.get().setStatus(game.getStatus());
						}

						//If the leaders request to set the game status to PENDING was accepted,
						//the game will setup before the game status changes to RUNNING.
						if(serverSideGame.get().getStatus() == GameStatus.PENDING){
							serverSideGame.get().startGame();
							serverSideGame.get().setStatus(GameStatus.RUNNING);

							int startingPositionArrayCounter = 0;
							for (Player p : serverSideGame.get().getPlayers()) {
								p.setup();
								p.getPlayingPiece().setPosition(serverSideGame.get().getMap()
												   .getStartingSpaces()[startingPositionArrayCounter++]);
								serverSideGame.get().getMap().getSpace(p.getPlayingPiece().getPosition())
											  .switchOccupied();
								playerRepository.save(p);
							}
						}
					}
					return gameRepository.save(serverSideGame.get());
				case RUNNING:
					//End Turn of Player.
					if(serverSideGame.get().getCurrentPlayer() == game.getCurrentPlayer()) {
						List<Card> discardedCards = getDifferenceOfHand(serverSideGame.get().getPlayers()
													.get(serverSideGame.get().getCurrentPlayer()), game.getPlayers()
													.get(game.getCurrentPlayer()));
						if(discardedCards != null && discardedCards.size() != 0){
							for(Card c : discardedCards){
								for(int i = 0; i < serverSideGame.get().getPlayers().get(serverSideGame.get().getCurrentPlayer())
										.getHand().size(); i++){
									if(c.getId() == serverSideGame.get().getPlayers().get(serverSideGame.get().getCurrentPlayer())
											.getHand().get(i).getId()){
										serverSideGame.get().getPlayers().get(serverSideGame.get().getCurrentPlayer())
												.getHand().remove(i);
										serverSideGame.get().getPlayers().get(serverSideGame.get().getCurrentPlayer())
												.getDiscardPile().add(c);
										break;
									}
								}
							}
						}

						serverSideGame.get().getPlayers().get(serverSideGame.get().getCurrentPlayer())
									  .setBoughtCardId(0);
						serverSideGame.get().getPlayers().get(serverSideGame.get().getCurrentPlayer())
									  .resetCoins();
						serverSideGame.get().getPlayers().get(serverSideGame.get().getCurrentPlayer())
									  .resetMoveCounter();
						serverSideGame.get().getPlayers().get(serverSideGame.get().getCurrentPlayer())
									  .flushPlayedList();

						//Check if a player is in El Dorado.
						boolean aPlayerIsOnEndTile = false;
						for (Player p : game.getPlayers()) {
							if (p.getIsInGoal()) {
								aPlayerIsOnEndTile = true;
							}
						}
						//Change game to finished if a player is in El Dorado
						if (aPlayerIsOnEndTile && game.getCurrentPlayer() + 1 == 0) {
							determineWinner(serverSideGame.get());
							serverSideGame.get().setStatus(GameStatus.FINISHED);
						}

						serverSideGame.get().getPlayers().get(serverSideGame.get().getCurrentPlayer())
									  .drawCardOnEndTurn();
						serverSideGame.get().changeCurrentPlayer();

						return gameRepository.save(serverSideGame.get());
					}
					else {
						throw new IllegalArgumentException("Currently it's an other players turn.");
					}
				case FINISHED:
					return gameRepository.save(serverSideGame.get());
			}
		}
		else {
			throw new RuntimeException("Game does not exist.");
		}
		return null;
	}

	public Game fastForwardGame(Long gameId){
		Optional<Game> serverSideGame = gameRepository.findById(gameId);
		if (serverSideGame.isPresent()){
			return gameRepository.save(serverSideGame.get());
		}
		else {
			throw new RuntimeException("Game does not exist.");
		}
	}

	public Player updatePlayer(Long gameId, Long playerId, Player player){
		Optional<Player> serverSidePlayer = playerRepository.findById(playerId);
		Optional<Game> serverSideGame = gameRepository.findById(gameId);

		if(serverSidePlayer.isPresent() && serverSideGame.isPresent()){
			switch(serverSideGame.get().getStatus()){
				case ROOM:
					serverSidePlayer.get().setReady(player.getReady());

					if(player.getColor().equals("red") || player.getColor().equals("blue")
													   || player.getColor().equals("yellow")
													   || player.getColor().equals("white")) {
						boolean colorAlreadyTaken = false;
						for (Player p : serverSideGame.get().getPlayers()) {
							if (p.getColor().equals(player.getColor())) {
								colorAlreadyTaken = true;
							}
						}
						if (!colorAlreadyTaken) {
							serverSidePlayer.get().setColor(player.getColor());
						}
					}

					return playerRepository.save(serverSidePlayer.get());
				case RUNNING:
					if(isPlayersTurn(serverSideGame, serverSidePlayer)) {
						movePlayingPiece(serverSideGame, serverSidePlayer, player);
					}

					playerRepository.save(serverSidePlayer.get());
					gameRepository.save(serverSideGame.get());
					return playerRepository.save(serverSidePlayer.get());
			}
		}
		else {
			throw new RuntimeException("Game or player do not exist.");
		}
		return null;
	}

	public Player buyCard(Long gameId, Long playerId, Player player){
		Optional<Player> serverSidePlayer = playerRepository.findById(playerId);
		Optional<Game> serverSideGame = gameRepository.findById(gameId);

		if (serverSidePlayer.isPresent() && serverSideGame.isPresent()
										&& serverSideGame.get().getStatus() == GameStatus.RUNNING) {
			if (isPlayersTurn(serverSideGame, serverSidePlayer)){
				if (serverSidePlayer.get().getBoughtCardId() == 0) {
					serverSidePlayer.get().setBoughtCardId(player.getBoughtCardId());
					Card boughtCard = serverSideGame.get().getMarket().getCardByCardId(player.getBoughtCardId());
					if (boughtCard != null) {
						List<Card> tradedInCards = getDifferenceOfPlayedPiles(serverSidePlayer, player);
						if (tradedInCards != null && tradedInCards.size() != 0) {
							float sumOfTradedCards = 0;
							for (Card c : tradedInCards) {
								sumOfTradedCards = sumOfTradedCards + c.getGoldValue();
							}
							if (sumOfTradedCards >= boughtCard.getBuyingCost()) {
								for (Card c : tradedInCards){
									serverSidePlayer.get().tradeinCard(c.getId());
								}
								serverSidePlayer.get().buyCard(serverSidePlayer.get().getBoughtCardId(),
															   serverSideGame.get().getMarket());
							}
							else {
								throw new IllegalArgumentException("Request contains invalid information. " +
																   "Cards traded in by player do not provide enough " +
																   "coins to buy this card.");
							}

							playerRepository.save(serverSidePlayer.get());
							gameRepository.save(serverSideGame.get());
							return playerRepository.save(serverSidePlayer.get());
						}
						else {
							throw new IllegalArgumentException("Request contains invalid information. " +
															   "No cards have been traded in.");
						}
					}
					else {
						throw new IllegalArgumentException("Request contains invalid information. " +
														   "To be bought card does not exist in the market " +
														   "or card is in a closed slot.");
					}
				}
				else {
					throw new IllegalArgumentException("Request contains invalid information. " +
													   "Player has already bought a card in this turn.");
				}
			}
			else {
				throw new IllegalArgumentException("Request contains invalid information. Other players turn.");
			}
		}
		else {
			throw new RuntimeException("Game or player do not exist or game is not running yet.");
		}
	}

	public Player playCard(Long gameId, Long playerId, Player player, long cardId){
		Optional<Player> serverSidePlayer = playerRepository.findById(playerId);
		Optional<Game> serverSideGame = gameRepository.findById(gameId);

		if (serverSidePlayer.isPresent() && serverSideGame.isPresent()
										&& serverSideGame.get().getStatus() == GameStatus.RUNNING) {
			if (isPlayersTurn(serverSideGame, serverSidePlayer)) {
				Card toBePlayedCard = serverSidePlayer.get().getCardFromHandById(cardId);
				if (toBePlayedCard != null) {
					if (toBePlayedCard instanceof Native){
						toBePlayedCard.play(serverSidePlayer.get());
						movePlayingPieceNative(serverSideGame, serverSidePlayer, player);
					}
					else if (toBePlayedCard instanceof Transmitter){
						toBePlayedCard.play(serverSidePlayer.get());
						serverSidePlayer.get().getDiscardPile().add(serverSideGame.get().getMarket()
											  .removeTransmitter(player.getBoughtCardId()));
					}
					else if ((toBePlayedCard instanceof MulticolorCard)
							  && player.getCardFromHandById(cardId) instanceof MulticolorCard) {
						if (((MulticolorCard) player.getCardFromHandById(cardId)).getChosenColor() != null) {
							((MulticolorCard) toBePlayedCard).setChosenColor(((MulticolorCard) player
															 .getCardFromHandById(cardId)).getChosenColor());
							toBePlayedCard.play(serverSidePlayer.get());
						}
					}
					else {
						toBePlayedCard.play(serverSidePlayer.get());
					}
				}
				else if (cardId == -1) { //If the player has discarded cards from his hand with Scientist or TravelLog,
										 //it'll be handled here upon receiving another request.
					removeHandCardsFromGameScientistTravelLog(serverSidePlayer, player);
				}
				else {
					throw new IllegalArgumentException("Request contains invalid information. Card does not exist.");
				}
				playerRepository.save(serverSidePlayer.get());
				gameRepository.save(serverSideGame.get());
				return playerRepository.save(serverSidePlayer.get());
			}
			else {
				throw new IllegalArgumentException("Request contains invalid information. Other players turn.");
			}
		}
		else {
			throw new RuntimeException("Game or player do not exist or game is not running yet.");
		}
	}

	//Move playing piece if conditions allow it.
	private void movePlayingPiece(Optional<Game> serverSideGame, Optional<Player> serverSidePlayer, Player player){
		//First check if the player tried to move:
		if (serverSidePlayer.get().getPlayingPiece().getPosition() != player.getPlayingPiece().getPosition()) {
			Space toBeMovedSpace = serverSideGame.get().getMap().getSpace(player.getPlayingPiece().getPosition());
			//Then check if the Space exists & if it exists if it's already occupied by another playing piece &
			//if it's a place that a piece can move to...
			if (toBeMovedSpace != null && !(toBeMovedSpace.getOccupied()) && toBeMovedSpace.getValue() != 0) {
				//... check if the Space is the neighbour of the selected space...
				boolean isNeighbour = false;
				long[] currentSpaceNeighbourIds = serverSideGame.get().getMap().getSpace(serverSidePlayer.get()
												.getPlayingPiece().getPosition()).getNeighbours();
				for (long neighbourSpaceId : currentSpaceNeighbourIds){
					if(toBeMovedSpace.getId() == neighbourSpaceId){
						isNeighbour = true;
						break;
					}
				}
				if (isNeighbour && !(toBeMovedSpace.isFirstOnNewTile())) {
					//... check the color of the Space...
					if (toBeMovedSpace.getColor().equals("green") || toBeMovedSpace.getColor().equals("blue")
																  || toBeMovedSpace.getColor().equals("yellow")) {
						//... and if its yellow/blue/green then check if the player has enough value to move
						//to that space and to which colour the value belongs to.
						String playerMoveCounterColour = serverSidePlayer.get().getMoveCounterColor();

						//If the player has got enough value for a specific colour
						//and if the colour is the same as the space he wants to move to...
						if (toBeMovedSpace.getColor().equals(playerMoveCounterColour)) {
							//... it'll continue to check if the moveCounter value is sufficiently high
							//after getting the right moveCounter value:
							int playerMoveCounterValue;
							if (toBeMovedSpace.getColor().equals("green")) {
								playerMoveCounterValue = serverSidePlayer.get().getMoveCounter()[0];
								if (playerMoveCounterValue >= toBeMovedSpace.getValue()) {
									if (serverSideGame.get().endTileIdArrayCheck(toBeMovedSpace.getId())) {
										serverSidePlayer.get().getPlayingPiece().setPosition(player.getPlayingPiece()
														.getPosition());
										serverSidePlayer.get().setMoveCounter((serverSidePlayer.get()
														.getMoveCounter()[0] - toBeMovedSpace.getValue()),
														"green");
									}
									else {
										serverSideGame.get().getMap().getSpace(serverSidePlayer.get().getPlayingPiece()
													  .getPosition()).switchOccupied();
										serverSidePlayer.get().getPlayingPiece().setPosition(player.getPlayingPiece()
														.getPosition());
										serverSidePlayer.get().setMoveCounter((serverSidePlayer.get()
														.getMoveCounter()[0] - toBeMovedSpace.getValue()),
														"green");
										toBeMovedSpace.switchOccupied();
									}
								}
								else {
									throw new IllegalArgumentException("Request contains invalid information. " +
																	   "Not enough green counter.");
								}
							} else if (toBeMovedSpace.getColor().equals("blue")) {
								playerMoveCounterValue = serverSidePlayer.get().getMoveCounter()[1];
								if (playerMoveCounterValue >= toBeMovedSpace.getValue()) {
									if (serverSideGame.get().endTileIdArrayCheck(toBeMovedSpace.getId())) {
										serverSidePlayer.get().getPlayingPiece().setPosition(player.getPlayingPiece()
															  .getPosition());
										serverSidePlayer.get().setMoveCounter((serverSidePlayer.get()
														.getMoveCounter()[1] - toBeMovedSpace.getValue()),
														"blue");
									}
									else {
										serverSideGame.get().getMap().getSpace(serverSidePlayer.get().getPlayingPiece()
													  .getPosition()).switchOccupied();
										serverSidePlayer.get().getPlayingPiece().setPosition(player.getPlayingPiece()
														.getPosition());
										serverSidePlayer.get().setMoveCounter((serverSidePlayer.get()
														.getMoveCounter()[1] - toBeMovedSpace.getValue()),
														"blue");
										toBeMovedSpace.switchOccupied();
									}
								}
								else {
									throw new IllegalArgumentException("Request contains invalid information. " +
																	   "Not enough blue counter.");
								}
							} else if (toBeMovedSpace.getColor().equals("yellow")) {
								playerMoveCounterValue = serverSidePlayer.get().getMoveCounter()[2];
								if (playerMoveCounterValue >= toBeMovedSpace.getValue()) {
									serverSideGame.get().getMap().getSpace(serverSidePlayer.get().getPlayingPiece()
												  .getPosition()).switchOccupied();
									serverSidePlayer.get().getPlayingPiece().setPosition(player.getPlayingPiece()
													.getPosition());
									serverSidePlayer.get().setMoveCounter((serverSidePlayer.get()
													.getMoveCounter()[2] - toBeMovedSpace.getValue()), "yellow");
									toBeMovedSpace.switchOccupied();
								}
								else {
									throw new IllegalArgumentException("Request contains invalid information. " +
																	   "Not enough yellow counter.");
								}
							}
						}
						else {
							throw new IllegalArgumentException("Request contains invalid information. " +
															   "Space color different from players MoveCounter color.");
						}
					} else if (toBeMovedSpace.getColor().equals("grey")) {
						switch (toBeMovedSpace.getValue()) {
							case 1:
								if (serverSidePlayer.get().getHand().size() >= 1) {
									moveCardsFromHandToPlayedList(serverSideGame, serverSidePlayer, player,
																  toBeMovedSpace, toBeMovedSpace.getValue());
								}
								else {
									throw new IllegalArgumentException("Request contains invalid information. " +
																	   "Not enough cards in hand (Need 1).");
								}
								break;
							case 2:
								if (serverSidePlayer.get().getHand().size() >= 2) {
									moveCardsFromHandToPlayedList(serverSideGame, serverSidePlayer, player,
																  toBeMovedSpace, toBeMovedSpace.getValue());
								}
								else {
									throw new IllegalArgumentException("Request contains invalid information. " +
																	   "Not enough cards in hand (Need 2).");
								}
								break;
							case 3:
								if (serverSidePlayer.get().getHand().size() >= 3) {
									moveCardsFromHandToPlayedList(serverSideGame, serverSidePlayer, player,
																  toBeMovedSpace, toBeMovedSpace.getValue());
								}
								else {
									throw new IllegalArgumentException("Request contains invalid information. " +
																	   "Not enough cards in hand (Need 3).");
								}
								break;
						}

					} else if (toBeMovedSpace.getColor().equals("red")) {
						switch (toBeMovedSpace.getValue()) {
							case 1:
								if (serverSidePlayer.get().getHand().size() >= 1) {
									removeHandCardsFromGame(serverSideGame, serverSidePlayer, player, toBeMovedSpace,
															toBeMovedSpace.getValue());
								}
								else {
									throw new IllegalArgumentException("Request contains invalid information. " +
																	   "Not enough cards in hand (Need 1).");
								}
								break;
							case 2:
								if (serverSidePlayer.get().getHand().size() >= 2) {
									removeHandCardsFromGame(serverSideGame, serverSidePlayer, player, toBeMovedSpace,
															toBeMovedSpace.getValue());
								}
								else {
									throw new IllegalArgumentException("Request contains invalid information. " +
																	   "Not enough cards in hand (Need 2).");
								}
								break;
						}
					}
					// else it's black or a starting space; Don't do anything.
				}
				else {
					throw new IllegalArgumentException("Request contains invalid information. New Space is " +
													   "not a neighbour or blockade is hindering movement.");
				}
			}
			else {
				throw new IllegalArgumentException("Request contains invalid information. New Space does not exist, " +
												   "is occupied or cannot be moved to.");
			}
		}
		else {
			//If Blockade exists and player is next to the blockade
			if (serverSideGame.get().getMap().getSpace(serverSidePlayer.get().getPlayingPiece().getPosition())
								   .isLastSpace()) {
				if (serverSidePlayer.get().getBlockades() != null && player.getBlockades() != null
																  && serverSidePlayer.get().getBlockades().size() <
																	 player.getBlockades().size()) {
					Blockade removedBlockade = getDifferenceOfBlockades(serverSidePlayer, player);

					if (removedBlockade != null) {
						if (removedBlockade.getColor().equals("green") || removedBlockade.getColor().equals("blue")
																	   || removedBlockade.getColor().equals("yellow")){
							String playerMoveCounterColour = serverSidePlayer.get().getMoveCounterColor();
							if (playerMoveCounterColour.equals(removedBlockade.getColor())){
								int playerMoveCounterValue;
								if (playerMoveCounterColour.equals("green")){
									playerMoveCounterValue = serverSidePlayer.get().getMoveCounter()[0];
									if(playerMoveCounterValue >= removedBlockade.getValue()){
										serverSidePlayer.get().getBlockades().add(removedBlockade);
										serverSidePlayer.get().setMoveCounter((serverSidePlayer.get()
														.getMoveCounter()[0] - removedBlockade.getValue()),
														"green");
										removeBlockadeOnMap(serverSideGame.get(),
															serverSidePlayer.get().getPlayingPiece().getPosition());
									}
									else {
										throw new IllegalArgumentException("Request contains invalid information. " +
																		   "Not enough green counter.");
									}
								}
								else if (playerMoveCounterColour.equals("blue")){
									playerMoveCounterValue = serverSidePlayer.get().getMoveCounter()[1];
									if (playerMoveCounterValue >= removedBlockade.getValue()){
										serverSidePlayer.get().getBlockades().add(removedBlockade);
										serverSidePlayer.get().setMoveCounter((serverSidePlayer.get()
														.getMoveCounter()[0] - removedBlockade.getValue()),
														"blue");
										removeBlockadeOnMap(serverSideGame.get(),
															serverSidePlayer.get().getPlayingPiece().getPosition());
									}
									else {
										throw new IllegalArgumentException("Request contains invalid information. " +
																		   "Not enough blue counter.");
									}
								}
								else { //yellow
									playerMoveCounterValue = serverSidePlayer.get().getMoveCounter()[2];
									if (playerMoveCounterValue >= removedBlockade.getValue()){
										serverSidePlayer.get().getBlockades().add(removedBlockade);
										serverSidePlayer.get().setMoveCounter((serverSidePlayer.get()
														.getMoveCounter()[0] - removedBlockade.getValue()),
														"yellow");
										removeBlockadeOnMap(serverSideGame.get(),
															serverSidePlayer.get().getPlayingPiece().getPosition());
									}
									else {
										throw new IllegalArgumentException("Request contains invalid information. " +
																		   "Not enough yellow counter.");
									}
								}
							}
							else {
								throw new IllegalArgumentException("Request contains invalid information. " +
																   "Blockade color is different from players " +
																   "MoveCounter color.");
							}
						}
						else { //grey
							switch (removedBlockade.getValue()) {
								case 1:
									moveCardsFromHandToPlayedList(serverSideGame, serverSidePlayer, player,
																  removedBlockade, removedBlockade.getValue());
									break;
								case 2:
									moveCardsFromHandToPlayedList(serverSideGame, serverSidePlayer, player,
																  removedBlockade, removedBlockade.getValue());
									break;
							}
						}
					}
					else {
						throw new IllegalArgumentException("Request contains invalid information. " +
														   "Blockade does not exist.");
					}
				}
				else {
					throw new IllegalArgumentException("Request contains invalid information. " +
													   "No Blockade chosen.");
				}
			}
		}

		//Check if player is in El Dorado and set player.isInGoal to true if that's the case.
		serverSidePlayer.get().setIsInGoal(serverSideGame.get().endTileIdArrayCheck(serverSidePlayer.get()
						.getPlayingPiece().getPosition()));
	}

	private void movePlayingPieceNative(Optional<Game> serverSideGame, Optional<Player> serverSidePlayer,
										Player player) {
		//First check if the player tried to move:
		if (serverSidePlayer.get().getPlayingPiece().getPosition() != player.getPlayingPiece().getPosition()) {
			Space toBeMovedSpace = serverSideGame.get().getMap().getSpace(player.getPlayingPiece().getPosition());
			//Then check if the Space exists & if it exists if it's already occupied by another playing piece &
			//if it's a place that a piece can move to...
			if (toBeMovedSpace != null && !(toBeMovedSpace.getOccupied()) && toBeMovedSpace.getValue() != 0) {
				//... check if the Space is the neighbour of the selected space...
				boolean isNeighbour = false;
				long[] currentSpaceNeighbourIds = serverSideGame.get().getMap().getSpace(serverSidePlayer.get()
																.getPlayingPiece().getPosition()).getNeighbours();
				for (long neighbourSpaceId : currentSpaceNeighbourIds){
					if (toBeMovedSpace.getId() == neighbourSpaceId){
						isNeighbour = true;
						break;
					}
				}
				if (isNeighbour && !(toBeMovedSpace.isFirstOnNewTile())) {
					//... check the color of the Space...
					if (toBeMovedSpace.getColor().equals("green") || toBeMovedSpace.getColor().equals("blue")
																  || toBeMovedSpace.getColor().equals("yellow")
																  || toBeMovedSpace.getColor().equals("grey")
																  || toBeMovedSpace.getColor().equals("red")) {
						if (serverSideGame.get().endTileIdArrayCheck(toBeMovedSpace.getId())) {
							serverSidePlayer.get().getPlayingPiece().setPosition(player.getPlayingPiece()
											.getPosition());
						}
						else {
							serverSideGame.get().getMap().getSpace(serverSidePlayer.get().getPlayingPiece()
												.getPosition()).switchOccupied();
							serverSidePlayer.get().getPlayingPiece().setPosition(player.getPlayingPiece()
											.getPosition());
							toBeMovedSpace.switchOccupied();
						}
					}
					// else it's black or a starting space; Don't do anything.
				}
				else {
					throw new IllegalArgumentException("Request contains invalid information. New Space is " +
													   "not a neighbour or blockade is hindering movement.");
				}
			}
			else {
				throw new IllegalArgumentException("Request contains invalid information. New Space does not exist, " +
												   "is occupied or cannot be moved to.");
			}
		}
		else {
			//If Blockade exists and player is next to the blockade
			if(serverSideGame.get().getMap().getSpace(serverSidePlayer.get().getPlayingPiece().getPosition())
								   .isLastSpace()) {
				if(serverSidePlayer.get().getBlockades() != null && player.getBlockades() != null
																 && serverSidePlayer.get().getBlockades().size() <
																	player.getBlockades().size()){
					Blockade removedBlockade = getDifferenceOfBlockades(serverSidePlayer, player);

					if(removedBlockade != null) {
						if (removedBlockade.getColor().equals("green") || removedBlockade.getColor().equals("blue")
																	   || removedBlockade.getColor().equals("yellow")
																	   || removedBlockade.getColor().equals("grey")) {
							serverSidePlayer.get().getBlockades().add(removedBlockade);
							removeBlockadeOnMap(serverSideGame.get(),
												serverSidePlayer.get().getPlayingPiece().getPosition());
						}
					}
					else {
						throw new IllegalArgumentException("Request contains invalid information. " +
														   "Blockade does not exist.");
					}
				}
				else {
					throw new IllegalArgumentException("Request contains invalid information. " +
													   "No Blockade chosen.");
				}
			}
		}

		//Check if player is in El Dorado and set player.isInGoal to true if that's the case.
		serverSidePlayer.get().setIsInGoal(serverSideGame.get().endTileIdArrayCheck(serverSidePlayer.get()
						.getPlayingPiece().getPosition()));
	}

	/*
	Helper method to move to grey spaces.
	Check the difference between the played pile of the client side player with the server side player &
	if the amount of the client side players hand has been lowered by the value of the grey space
	and if the discard pile has been increased by the value of the grey space
	and return the cards that have been moved to the played list.
	*/
	private List<Card> getDifferenceOfPlayedPiles(Optional<Player> serverSidePlayer, Player player,
												  Space toBeMovedSpace) {
		//First check if the size of the client side players hand has been lowered by the amount of the discarded cards.
		if((serverSidePlayer.get().getHand().size() - player.getHand().size())
				== (player.getPlayedList().size() - serverSidePlayer.get().getPlayedList().size())
				&& (player.getHand().size()
				== (serverSidePlayer.get().getHand().size() - toBeMovedSpace.getValue()))
				&& (player.getPlayedList().size()
				== (serverSidePlayer.get().getPlayedList().size() + toBeMovedSpace.getValue()))) {

			List<Card> discardedCards = new ArrayList<>();
			List<Card> serverSidePlayedList = new ArrayList<>();
			for (Card c : player.getPlayedList()){
				discardedCards.add(c);
			}
			for (Card c : serverSidePlayer.get().getPlayedList()){
				serverSidePlayedList.add(c);
			}
			for(Card c : serverSidePlayedList){
				for(int i = 0; i < discardedCards.size(); i++){
					if(c.getId() == discardedCards.get(i).getId()){
						discardedCards.remove(i);
						break;
					}
				}
			}
			if(discardedCards.size() != 0) {
				return discardedCards;
			}
		}
		return null;
	}

	//Helper method to buy cards from market.
	private List<Card> getDifferenceOfPlayedPiles(Optional<Player> serverSidePlayer, Player player){
		//First check if the size of the client side players hand has been lowered by the amount of the discarded cards.
		if((serverSidePlayer.get().getHand().size() - player.getHand().size()) ==
				(player.getPlayedList().size() - serverSidePlayer.get().getPlayedList().size())) {

			List<Card> tradedInCards = new ArrayList<>();
			List<Card> serverSidePlayedList = new ArrayList<>();
			for (Card c : player.getPlayedList()){
				tradedInCards.add(c);
			}
			for (Card c : serverSidePlayer.get().getPlayedList()){
				serverSidePlayedList.add(c);
			}
			for(Card c : serverSidePlayedList){
				for(int i = 0; i < tradedInCards.size(); i++){
					if(c.getId() == tradedInCards.get(i).getId()){
						tradedInCards.remove(i);
						break;
					}
				}
			}
			if(tradedInCards.size() != 0) {
				return tradedInCards;
			}
		}
		return null;
	}

	//Helper method to buy cards from market.
	private List<Card> getDifferenceOfHand(Player serverSidePlayer, Player player){
		//First check if the size of the client side players hand has been lowered by the amount of the discarded cards.
		if((serverSidePlayer.getHand().size() - player.getHand().size()) == (player.getDiscardPile().size() -
																			 serverSidePlayer.getDiscardPile().size())){

			List<Card> discardedCards = new ArrayList<>();
			List<Card> serverSideDiscardPile = new ArrayList<>();
			for (Card c : player.getDiscardPile()){
				discardedCards.add(c);
			}
			for (Card c : serverSidePlayer.getDiscardPile()){
				serverSideDiscardPile.add(c);
			}
			for(Card c : serverSideDiscardPile){
				for(int i = 0; i < discardedCards.size(); i++){
					if(c.getId() == discardedCards.get(i).getId()){
						discardedCards.remove(i);
						break;
					}
				}
			}
			if(discardedCards.size() != 0) {
				return discardedCards;
			}
		}
		return null;
	}

	/*
	Helper method to move to a red space.
	Check first if the amount of the client side players hand has been lowered by the value of the red space
	and return the cards that have been removed from the game.
	*/
	private List<Card> getRemovedCards(Optional<Player> serverSidePlayer, Player player, Space toBeMovedSpace){
    	if(player.getHand().size() == (serverSidePlayer.get().getHand().size() - toBeMovedSpace.getValue())) {
			List<Card> removedCards = new ArrayList<>();
			List<Card> clientSideHand = new ArrayList<>();
			for (Card c : serverSidePlayer.get().getHand()){
				removedCards.add(c);
			}
			for (Card c : player.getHand()){
				clientSideHand.add(c);
			}
			for(Card c : clientSideHand){
				for(int i = 0; i < removedCards.size(); i++){
					if(c.getId() == removedCards.get(i).getId()){
						removedCards.remove(i);
						break;
					}
				}
			}
			if(removedCards.size() != 0) {
				return removedCards;
			}
		}
    	return null;
	}

	//Helper method of a helper method to remove cards from the game after playing Scientist or TravelLog
	private List<Card> getRemovedCardsScientistTravelLog(Optional<Player> serverSidePlayer, Player player){
		List<Card> removedCards = new ArrayList<>();
		List<Card> clientSideHand = new ArrayList<>();
		for (Card c : serverSidePlayer.get().getHand()){
			removedCards.add(c);
		}
		for (Card c : player.getHand()){
			clientSideHand.add(c);
		}
		for(Card c : clientSideHand){
			for(int i = 0; i < removedCards.size(); i++){
				if(c.getId() == removedCards.get(i).getId()){
					removedCards.remove(i);
					break;
				}
			}
		}
		if(removedCards.size() != 0) {
			return removedCards;
		}
		return null;
	}

	private Blockade getDifferenceOfBlockades(Optional<Player> serverSidePlayer, Player player){
		List<Blockade> removedBlockades = new ArrayList<>();
		List<Blockade> serverSideBlockades = new ArrayList<>();
		for (Blockade b : player.getBlockades()){
			removedBlockades.add(b);
		}
		for (Blockade b : serverSidePlayer.get().getBlockades()){
			serverSideBlockades.add(b);
		}
		for(Blockade b : serverSideBlockades){
			for(int i = 0; i < removedBlockades.size(); i++){
				if(b.getPowerValue() == removedBlockades.get(i).getPowerValue()){
					removedBlockades.remove(i);
					break;
				}
			}
		}

		Blockade removedBlockade = removedBlockades.get(0);
		if(removedBlockade != null){
			return removedBlockade;
		}
		return null;
	}

	//Helper method to remove a grey blockade.
	//Moves the played cards from the server side players hand to his played cards list.
	private void moveCardsFromHandToPlayedList(Optional<Game> serverSideGame, Optional<Player> serverSidePlayer,
											   Player player, Blockade removedBlockade, int amountOfDiscardedCards) {
		List<Card> discardedCards = getDifferenceOfPlayedPiles(serverSidePlayer, player);
		if(discardedCards != null && discardedCards.size() == amountOfDiscardedCards){
			for(Card c : discardedCards){
				for(int i = 0; i < serverSidePlayer.get().getHand().size(); i++){
					if(c.getId() == serverSidePlayer.get().getHand().get(i).getId()){
						serverSidePlayer.get().getHand().remove(i);
						serverSidePlayer.get().getPlayedList().add(c);
						break;
					}
				}
			}
			if((Collections.disjoint(serverSidePlayer.get().getHand(), discardedCards)) && (serverSidePlayer.get()
														   .getPlayedList().containsAll(discardedCards))) {
				serverSidePlayer.get().getBlockades().add(removedBlockade);
				removeBlockadeOnMap(serverSideGame.get(), serverSidePlayer.get().getPlayingPiece().getPosition());
			}
		}
	}

	//Helper method to move to grey spaces.
	//Moves the played cards from the server side players hand to his played cards list.
	private void moveCardsFromHandToPlayedList(Optional<Game> serverSideGame, Optional<Player> serverSidePlayer,
											   Player player, Space toBeMovedSpace, int amountOfDiscardedCards) {
		List<Card> discardedCards = getDifferenceOfPlayedPiles(serverSidePlayer, player, toBeMovedSpace);
		if(discardedCards != null && discardedCards.size() == amountOfDiscardedCards){
			for(Card c : discardedCards){
				for(int i = 0; i < serverSidePlayer.get().getHand().size(); i++){
					if(c.getId() == serverSidePlayer.get().getHand().get(i).getId()){
						serverSidePlayer.get().getHand().remove(i);
						serverSidePlayer.get().getPlayedList().add(c);
						break;
					}
				}
			}
			if((Collections.disjoint(serverSidePlayer.get().getHand(), discardedCards)) && (serverSidePlayer.get()
													 .getPlayedList().containsAll(discardedCards))) {
				serverSideGame.get().getMap().getSpace(serverSidePlayer.get().getPlayingPiece().getPosition())
							  .switchOccupied();
				serverSidePlayer.get().getPlayingPiece().setPosition(player.getPlayingPiece().getPosition());
				toBeMovedSpace.switchOccupied();
			}
		}
	}

	//Helper method to move to red spaces.
	private void removeHandCardsFromGame(Optional<Game> serverSideGame, Optional<Player> serverSidePlayer,
										 Player player, Space toBeMovedSpace, int amountOfRemovedCards) {
		List<Card> removedCards = getRemovedCards(serverSidePlayer, player, toBeMovedSpace);
		if(removedCards != null && removedCards.size() == amountOfRemovedCards) {
			for(Card c : removedCards){
				for(int i = 0; i < serverSidePlayer.get().getHand().size(); i++){
					if(c.getId() == serverSidePlayer.get().getHand().get(i).getId()){
						serverSidePlayer.get().getHand().remove(i);
						break;
					}
				}
			}
			if(Collections.disjoint(serverSidePlayer.get().getHand(), removedCards)) {
				serverSideGame.get().getMap().getSpace(serverSidePlayer.get().getPlayingPiece().getPosition())
							  .switchOccupied();
				serverSidePlayer.get().getPlayingPiece().setPosition(player.getPlayingPiece().getPosition());
				toBeMovedSpace.switchOccupied();
			}
		}
	}

	//Helper method to remove the cards from hand after playing the Scientist or TravelLog
	private void removeHandCardsFromGameScientistTravelLog(Optional<Player> serverSidePlayer, Player player){
		List<Card> removedCards = getRemovedCardsScientistTravelLog(serverSidePlayer, player);
		if(removedCards != null && removedCards.size() != 0) {
			for(Card c : removedCards){
				for(int i = 0; i < serverSidePlayer.get().getHand().size(); i++){
					if(c.getId() == serverSidePlayer.get().getHand().get(i).getId()){
						serverSidePlayer.get().getHand().remove(i);
						break;
					}
				}
			}
		}
	}

	private boolean isPlayersTurn(Optional<Game> serverSideGame, Optional<Player> serverSidePlayer){
		int positionOfPlayerInPlayers = 0;
		for(int i = 0; i < serverSideGame.get().getPlayers().size();i++){
			if(serverSideGame.get().getPlayers().get(i).getId().equals(serverSidePlayer.get().getId())){
				positionOfPlayerInPlayers = i;
			}
		}
		return serverSideGame.get().getCurrentPlayer() == positionOfPlayerInPlayers;
	}

	//The boolean of all neighbours of the current space of the playing piece that hinder passing
	//due to boolean = true is set to false.
	private void removeBlockadeOnMap(Game serverSideGame, long playingPiecePosition){
		ArrayList<Space> toBeUpdatedSpaces = new ArrayList<>();
		toBeUpdatedSpaces.add(serverSideGame.getMap().getSpace(playingPiecePosition));
		while(toBeUpdatedSpaces.size() != 0){
			ArrayList<Space> tempToBeUpdatedSpaces = new ArrayList<>();
			for (int i = 0; i < toBeUpdatedSpaces.size();i++){
				toBeUpdatedSpaces.get(i).removeBlockadeStatus();
				long[] neighbourIds = toBeUpdatedSpaces.get(i).getNeighbours();
				for(long l : neighbourIds){
					Space tempSpace = serverSideGame.getMap().getSpace(l);
					if(tempSpace.isLastSpace() || tempSpace.isFirstOnNewTile()){
						tempToBeUpdatedSpaces.add(tempSpace);
					}
				}
				toBeUpdatedSpaces.remove(i);
			}
			toBeUpdatedSpaces = tempToBeUpdatedSpaces;
		}
	}

	private void determineWinner(Game serverSideGame){
		int counter = 0;
		for (Player p : serverSideGame.getPlayers()){
			if(p.getIsInGoal()){
				counter ++;
			}
		}
		if(counter == 1){
			for (Player p : serverSideGame.getPlayers()){
				if(p.getIsInGoal()){
					p.setWinner();
				}
			}
		}
		else if(counter >= 2){
			//Create an array containing the amount of blockades of each player
			int[] sizeOfBlockadesLists = new int[serverSideGame.getPlayers().size()];
			for(int i = 0; i < serverSideGame.getPlayers().size(); i++){
				sizeOfBlockadesLists[i] = serverSideGame.getPlayers().get(i).getBlockades().size();
			}
			//Search for the player with the largest amount of blockades in the created array
			if(sizeOfBlockadesLists.length != 0){
				int largest = 0;
				for(int i = 0; i < sizeOfBlockadesLists.length; i++){
					if (sizeOfBlockadesLists[i] > sizeOfBlockadesLists[largest]){
						largest = i;
					}
				}
				//Put all the indexes of players that have the largest amount of blockades into a list
				ArrayList<Integer> indexOfPlayersWithLargestAmountOfBlockades = new ArrayList<>();
				for(int i = 0; i < sizeOfBlockadesLists.length; i++){
					if(sizeOfBlockadesLists[i] == sizeOfBlockadesLists[largest]){
						indexOfPlayersWithLargestAmountOfBlockades.add(i);
					}
				}
				if(indexOfPlayersWithLargestAmountOfBlockades.size() == 1){
					serverSideGame.getPlayers().get(indexOfPlayersWithLargestAmountOfBlockades.get(0)).setWinner();
				}
				//Find the Player with the blockade that has the largest power value and declare him as winner
				else if (indexOfPlayersWithLargestAmountOfBlockades.size() >= 2){
					int[] blockadeMaxValues = new int[indexOfPlayersWithLargestAmountOfBlockades.size()];
					for(int i = 0; i < indexOfPlayersWithLargestAmountOfBlockades.size(); i++){
						blockadeMaxValues[i] = 0;
					}
					for(int i = 0; i < indexOfPlayersWithLargestAmountOfBlockades.size(); i++){
						for(Blockade b : serverSideGame.getPlayers().get(indexOfPlayersWithLargestAmountOfBlockades
													   .get(i)).getBlockades()){
							if(b.getPowerValue() > blockadeMaxValues[i]){
								blockadeMaxValues[i] = b.getPowerValue();
							}
						}
					}
					int indexOfWinner = 0;
					for(int i = 0; i < blockadeMaxValues.length; i++){
						if(blockadeMaxValues[i] > blockadeMaxValues[indexOfWinner]){
							indexOfWinner = i;
						}
					}
					serverSideGame.getPlayers().get(indexOfPlayersWithLargestAmountOfBlockades.get(indexOfWinner))
								  .setWinner();
				}
			}
		}
	}
}

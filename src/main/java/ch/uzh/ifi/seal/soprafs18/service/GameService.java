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

    private final String CONTEXT = "/games";

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
    	if(game.getPlayer(0).getName().length() < 9) {
			game.getPlayer(0).setColor("red");
			game.getPlayer(0).setReady(true);
			game.getPlayer(0).setToken(UUID.randomUUID().toString());
			Game serverSideGame = gameRepository.save(game);
			serverSideGame.getPlayer(0).setGameId(serverSideGame.getId());
			serverSideGame.setName(serverSideGame.getPlayer(0).getName() + "'s Game");
			return gameRepository.save(serverSideGame);
		}
		return null;
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
		return game.get().getPlayers();
	}

	public Player addPlayer(Long gameId, Player player) {
		Optional<Game> game = gameRepository.findById(gameId);

		if (game.isPresent()) {
			game.get().getPlayers().removeAll(Collections.singleton(null));
			int numberOfPlayers = game.get().getPlayers().size();

			// Add player to playerRepository
			//TODO: How to display to frontend that a new player couldn't be added?
			//TODO: Color setting needs to be handled here. Also leader should always have same color upon hosting a game.
			if (game.get().getStatus() == ROOM && numberOfPlayers < GameConstants.MAX_PLAYERS && player.getName().length() < 9){
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
			}
			else {
				System.out.println("Could not join game. Player name too long (Max length is 8), Game room is full or game is already running.");
			}

		}
		else {
			this.logger.error("Error adding player with id: " + player.getId());
		}
		return null;
	}

	public Player getPlayer(Long gameId, Long playerId) {
		Optional<Game> game = gameRepository.findById(gameId);
		Optional<Player> player = playerRepository.findById(playerId);
		if (game.isPresent() && player.isPresent()) {
			return player.get();
		}
		return null;
	}

    public Game updateGame(Long gameId, Game game){
		Optional<Game> serverSideGame = gameRepository.findById(gameId);

		if (serverSideGame.isPresent()){
			switch(serverSideGame.get().getStatus()){
				case ROOM:
					serverSideGame.get().setName(game.getName());
					serverSideGame.get().setMapName(game.getMapName());
					serverSideGame.get().setTurnTime(game.getTurnTime());

					//TODO: The leaders ready status should always be true. Meaning when a new leader is set, his ready attribute should be automatically set to true.
					//Checks first if there are at least 2 players in the room. Checks then if all players are ready. If all of them are ready and the leader pressed the Start Game button, the game will start.
					if (serverSideGame.get().getPlayers().size() >= GameConstants.MIN_PLAYERS) {
						boolean allPlayersReady = true;
						for(Player p: serverSideGame.get().getPlayers()){
							if (p.getReady() == false){
								allPlayersReady = false;
							}
						}

						//If all players are ready, the leaders request to set the game status to PENDING is accepted.
						if(allPlayersReady) {
							serverSideGame.get().setStatus(game.getStatus());
						}

						//If the leaders request to set the game status to PENDING was accepted, the game will setup before the game status changes to RUNNING.
						if(serverSideGame.get().getStatus() == GameStatus.PENDING){
							serverSideGame.get().startGame();
							serverSideGame.get().setStatus(GameStatus.RUNNING);

							int startingPositionArrayCounter = 0;
							for (Player p : serverSideGame.get().getPlayers()) {
								p.setup();
								p.getPlayingPiece().setPosition(serverSideGame.get().getMap().getStartingSpaces()[startingPositionArrayCounter++]);
								serverSideGame.get().getMap().getSpace(p.getPlayingPiece().getPosition()).switchOccupied();
								playerRepository.save(p);
							}
						}
					}
					return gameRepository.save(serverSideGame.get());
				case RUNNING:
					//End Turn of Player.
					if(serverSideGame.get().getCurrentPlayer() == game.getCurrentPlayer()) {
						List<Card> discardedCards = getDifferenceOfHand(serverSideGame.get().getPlayer(serverSideGame.get().getCurrentPlayer()), game.getPlayer(game.getCurrentPlayer()));
						if(discardedCards != null && discardedCards.size() != 0){
							for(Card c : discardedCards){
								serverSideGame.get().getPlayer(serverSideGame.get().getCurrentPlayer()).moveFromHandToDiscardPile(c);
							}
						}

						serverSideGame.get().getPlayer(serverSideGame.get().getCurrentPlayer()).setBoughtCardId(0);
						serverSideGame.get().getPlayer(serverSideGame.get().getCurrentPlayer()).resetCoins();
						serverSideGame.get().getPlayer(serverSideGame.get().getCurrentPlayer()).resetMoveCounter();
						serverSideGame.get().getPlayer(serverSideGame.get().getCurrentPlayer()).flushPlayedList();

						//Check if a player is in El Dorado.
						boolean aPlayerIsOnEndTile = false;
						for (Player p : game.getPlayers()) {
							if (p.getIsInGoal()) {
								aPlayerIsOnEndTile = true;
							}
						}
						//Change game to finished if a player is in El Dorado while the
						if (aPlayerIsOnEndTile && game.getCurrentPlayer() + 1 == 0) {
							serverSideGame.get().setStatus(GameStatus.WILL_BE_FINISHED);
						}

						serverSideGame.get().getPlayer(serverSideGame.get().getCurrentPlayer()).drawCardOnEndTurn();
						serverSideGame.get().changeCurrentPlayer();

						return gameRepository.save(serverSideGame.get());
					}
				case WILL_BE_FINISHED:
					if(game.getCurrentPlayer() == 0) {
						serverSideGame.get().setStatus(GameStatus.FINISHED);
					}

					return gameRepository.save(serverSideGame.get());
				case FINISHED:
					serverSideGame.get().setStatus(GameStatus.ROOM);
					return gameRepository.save(serverSideGame.get());
			}
		}
		return null;
	}

	public Player updatePlayer(Long gameId, Long playerId, Player player){
		Optional<Player> serverSidePlayer = playerRepository.findById(playerId);
		Optional<Game> serverSideGame = gameRepository.findById(gameId);

		if(serverSidePlayer.isPresent() && serverSideGame.isPresent()){
			switch(serverSideGame.get().getStatus()){
				case ROOM:
					serverSidePlayer.get().setReady(player.getReady());

					if(player.getColor().equals("red") || player.getColor().equals("blue") || player.getColor().equals("yellow") || player.getColor().equals("white")) {
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

					//REMOVE THIS:
					serverSidePlayer.get().setMoveCounter(1, "green");

					if(isPlayersTurn(serverSideGame, serverSidePlayer)) {
						movePlayingPiece(serverSideGame, serverSidePlayer, player);
					}

					playerRepository.save(serverSidePlayer.get());
					gameRepository.save(serverSideGame.get());
					return playerRepository.save(serverSidePlayer.get());
			}
		}
		return null;
	}

	public Player buyCard(Long gameId, Long playerId, Player player){
		Optional<Player> serverSidePlayer = playerRepository.findById(playerId);
		Optional<Game> serverSideGame = gameRepository.findById(gameId);

		if(serverSidePlayer.isPresent() && serverSideGame.isPresent() && serverSideGame.get().getStatus() == GameStatus.RUNNING){
			if(isPlayersTurn(serverSideGame, serverSidePlayer)){
				if(serverSidePlayer.get().getBoughtCardId() == 0) {
					serverSidePlayer.get().setBoughtCardId(player.getBoughtCardId());
					Card boughtCard = player.returnCardFromHandById(player.getBoughtCardId());
					if(boughtCard != null) {
						List<Card> tradedInCards = getDifferenceOfPlayedPiles(serverSidePlayer, player);
						if (tradedInCards != null && tradedInCards.size() != 0) {
							float sumOfTradedCards = 0;
							for (Card c : tradedInCards) {
								sumOfTradedCards = sumOfTradedCards + c.getGoldValue();
							}
							if (sumOfTradedCards >= boughtCard.getBuyingCost()) {
								for(Card c : tradedInCards){
									serverSidePlayer.get().tradeinCard(c.getId());
								}
								serverSidePlayer.get().buyCard(serverSidePlayer.get().getBoughtCardId(), serverSideGame.get().getMarket());
							}

							playerRepository.save(serverSidePlayer.get());
							gameRepository.save(serverSideGame.get());
							return playerRepository.save(serverSidePlayer.get());
						}
					}
				}
			}
		}
		return null;
	}

	public Player playCard(Long gameId, Long playerId, Player player, long cardId){
		Optional<Player> serverSidePlayer = playerRepository.findById(playerId);
		Optional<Game> serverSideGame = gameRepository.findById(gameId);

		if(serverSidePlayer.isPresent() && serverSideGame.isPresent() && serverSideGame.get().getStatus() == GameStatus.RUNNING) {
			if(isPlayersTurn(serverSideGame, serverSidePlayer)) {
				Card toBePlayedCard = serverSidePlayer.get().getCardFromHandById(cardId);
				if (toBePlayedCard != null) {
					if(toBePlayedCard instanceof Native){

					}
					else if(toBePlayedCard instanceof Scientist){

					}
					else if (toBePlayedCard instanceof Transmitter){
						long previousBoughtCardId = serverSidePlayer.get().getBoughtCardId();
						serverSidePlayer.get()serverSideGame.get().getMarket().removeCardTransmitter(player.getBoughtCardId());
						
					}
					else if (toBePlayedCard instanceof TravelLog){

					}
					else if ((toBePlayedCard instanceof MulticolorCard) && player.getCardFromHandById(cardId) instanceof MulticolorCard){
						if (((MulticolorCard) player.getCardFromHandById(cardId)).getChosenColor() != null){
							((MulticolorCard) toBePlayedCard).setChosenColor(((MulticolorCard) player.getCardFromHandById(cardId)).getChosenColor());
							toBePlayedCard.play(serverSidePlayer.get());
						}
					}
					else{
						toBePlayedCard.play(serverSidePlayer.get());
					}
					playerRepository.save(serverSidePlayer.get());
					gameRepository.save(serverSideGame.get());
					return playerRepository.save(serverSidePlayer.get());
				}
			}
		}
		return null;
	}

	//Move playing piece if conditions allow it.
	private void movePlayingPiece(Optional<Game> serverSideGame, Optional<Player> serverSidePlayer, Player player){
		//First check if the player tried to move:
		if(serverSidePlayer.get().getPlayingPiece().getPosition() != player.getPlayingPiece().getPosition()) {
			Space toBeMovedSpace = serverSideGame.get().getMap().getSpace(player.getPlayingPiece().getPosition());
			//Then check if the Space exists & if it exists if it's already occupied by another playing piece & if it's a place that a piece can move to...
			if (toBeMovedSpace != null && !(toBeMovedSpace.getOccupied()) && toBeMovedSpace.getValue() != 0) {
				//... check if the Space is the neighbour of the selected space...
				boolean isNeighbour = false;
				long[] currentSpaceNeighbourIds = serverSideGame.get().getMap().getSpace(serverSidePlayer.get().getPlayingPiece().getPosition()).getNeighbours();
				for(long neighbourSpaceId : currentSpaceNeighbourIds){
					if(toBeMovedSpace.getId() == neighbourSpaceId){
						isNeighbour = true;
						break;
					}
				}
				if(isNeighbour && !(toBeMovedSpace.isFirstOnNewTile())) {
					//... check the color of the Space...
					if (toBeMovedSpace.getColor().equals("green") || toBeMovedSpace.getColor().equals("blue") || toBeMovedSpace.getColor().equals("yellow")) {
						//... and if its yellow/blue/green then check if the player has enough value to move to that space and to which colour the value belongs to.
						String playerMoveCounterColour = serverSidePlayer.get().getMoveCounterColor();

						//If the player has got enough value for a specific colour and if the colour is the same as the space he wants to move to...
						if (playerMoveCounterColour != null && toBeMovedSpace.getColor().equals(playerMoveCounterColour)) {
							//... it'll continue to check if the moveCounter value is sufficiently high after getting the right moveCounter value:
							int playerMoveCounterValue;
							if (toBeMovedSpace.getColor().equals("green")) {
								playerMoveCounterValue = serverSidePlayer.get().getMoveCounter()[0];
								if (playerMoveCounterValue >= toBeMovedSpace.getValue()) {
									serverSideGame.get().getMap().getSpace(serverSidePlayer.get().getPlayingPiece().getPosition()).switchOccupied();
									serverSidePlayer.get().getPlayingPiece().setPosition(player.getPlayingPiece().getPosition());
									serverSidePlayer.get().setMoveCounter((serverSidePlayer.get().getMoveCounter()[0] - toBeMovedSpace.getValue()), "green");
									toBeMovedSpace.switchOccupied();
								}
							} else if (toBeMovedSpace.getColor().equals("blue")) {
								playerMoveCounterValue = serverSidePlayer.get().getMoveCounter()[1];
								if (playerMoveCounterValue >= toBeMovedSpace.getValue()) {
									serverSideGame.get().getMap().getSpace(serverSidePlayer.get().getPlayingPiece().getPosition()).switchOccupied();
									serverSidePlayer.get().getPlayingPiece().setPosition(player.getPlayingPiece().getPosition());
									serverSidePlayer.get().setMoveCounter((serverSidePlayer.get().getMoveCounter()[0] - toBeMovedSpace.getValue()), "blue");
									toBeMovedSpace.switchOccupied();
								}
							} else if (toBeMovedSpace.getColor().equals("yellow")) {
								playerMoveCounterValue = serverSidePlayer.get().getMoveCounter()[2];
								if (playerMoveCounterValue >= toBeMovedSpace.getValue()) {
									serverSideGame.get().getMap().getSpace(serverSidePlayer.get().getPlayingPiece().getPosition()).switchOccupied();
									serverSidePlayer.get().getPlayingPiece().setPosition(player.getPlayingPiece().getPosition());
									serverSidePlayer.get().setMoveCounter((serverSidePlayer.get().getMoveCounter()[0] - toBeMovedSpace.getValue()), "yellow");
									toBeMovedSpace.switchOccupied();
								}
							}
						}
					} else if (toBeMovedSpace.getColor().equals("grey")) {
						switch (toBeMovedSpace.getValue()) {
							case 1:
								if (serverSidePlayer.get().getHand().size() >= 1) {
									moveCardsFromHandToPlayedList(serverSideGame, serverSidePlayer, player, toBeMovedSpace, toBeMovedSpace.getValue());
								}
							case 2:
								if (serverSidePlayer.get().getHand().size() >= 2) {
									moveCardsFromHandToPlayedList(serverSideGame, serverSidePlayer, player, toBeMovedSpace, toBeMovedSpace.getValue());
								}

							case 3:
								if (serverSidePlayer.get().getHand().size() >= 3) {
									moveCardsFromHandToPlayedList(serverSideGame, serverSidePlayer, player, toBeMovedSpace, toBeMovedSpace.getValue());
								}
						}

					} else if (toBeMovedSpace.getColor().equals("red")) {
						switch (toBeMovedSpace.getValue()) {
							case 1:
								if (serverSidePlayer.get().getHand().size() >= 1) {
									removeHandCardsFromGame(serverSideGame, serverSidePlayer, player, toBeMovedSpace, toBeMovedSpace.getValue());
								}

							case 2:
								if (serverSidePlayer.get().getHand().size() >= 2) {
									removeHandCardsFromGame(serverSideGame, serverSidePlayer, player, toBeMovedSpace, toBeMovedSpace.getValue());
								}
						}
					}
					// else it's black or a starting space; Don't do anything.
				}
			}
		}
		else {
			//If Blockade exists and player is next to the blockade
			if(serverSideGame.get().getMap().getSpace(serverSidePlayer.get().getPlayingPiece().getPosition()).isLastSpace()) {
				if(serverSidePlayer.get().getBlockades() != null && player.getBlockades() != null && serverSidePlayer.get().getBlockades().size() < player.getBlockades().size()){
					Blockade removedBlockade = getDifferenceOfBlockades(serverSidePlayer, player);

					if(removedBlockade != null) {
						if (removedBlockade.getColor().equals("green") || removedBlockade.getColor().equals("blue") ||removedBlockade.getColor().equals("yellow")) {
							String playerMoveCounterColour = serverSidePlayer.get().getMoveCounterColor();
							if(playerMoveCounterColour.equals(removedBlockade.getColor())){
								int playerMoveCounterValue;
								if (playerMoveCounterColour.equals("green")){
									playerMoveCounterValue = serverSidePlayer.get().getMoveCounter()[0];
									if(playerMoveCounterValue >= removedBlockade.getValue()){
										serverSidePlayer.get().addBlockade(removedBlockade);
										serverSidePlayer.get().setMoveCounter((serverSidePlayer.get().getMoveCounter()[0] - removedBlockade.getValue()), "green");
										removeBlockadeOnMap(serverSideGame.get(), serverSidePlayer.get().getPlayingPiece().getPosition());
									}
								}
								else if (playerMoveCounterColour.equals("blue")){
									playerMoveCounterValue = serverSidePlayer.get().getMoveCounter()[1];
									if(playerMoveCounterValue >= removedBlockade.getValue()){
										serverSidePlayer.get().addBlockade(removedBlockade);
										serverSidePlayer.get().setMoveCounter((serverSidePlayer.get().getMoveCounter()[0] - removedBlockade.getValue()), "blue");
										removeBlockadeOnMap(serverSideGame.get(), serverSidePlayer.get().getPlayingPiece().getPosition());
									}
								}
								else { //yellow
									playerMoveCounterValue = serverSidePlayer.get().getMoveCounter()[2];
									if(playerMoveCounterValue >= removedBlockade.getValue()){
										serverSidePlayer.get().addBlockade(removedBlockade);
										serverSidePlayer.get().setMoveCounter((serverSidePlayer.get().getMoveCounter()[0] - removedBlockade.getValue()), "yellow");
										removeBlockadeOnMap(serverSideGame.get(), serverSidePlayer.get().getPlayingPiece().getPosition());
									}
								}
							}
						}
						else { //grey
							switch(removedBlockade.getValue()) {
								case 1:
									moveCardsFromHandToPlayedList(serverSideGame, serverSidePlayer, player, removedBlockade, removedBlockade.getValue());
								case 2:
									moveCardsFromHandToPlayedList(serverSideGame, serverSidePlayer, player, removedBlockade, removedBlockade.getValue());
							}
						}
					}
				}
			}
		}

		//Check if player is in El Dorado and set player.isInGoal to true if that's the case.
		serverSidePlayer.get().setIsInGoal(serverSideGame.get().endTileIdArrayCheck(serverSidePlayer.get().getPlayingPiece().getPosition()));
	}

	/*
	Helper method to move to grey spaces. Check the difference between the played pile of the client side player with the server side player &
	if the amount of the client side players hand has been lowered by the value of the grey space
	and if the discard pile has been increased by the value of the grey space
	and return the cards that have been moved to the played list.
	*/
	private List<Card> getDifferenceOfPlayedPiles(Optional<Player> serverSidePlayer, Player player, Space toBeMovedSpace){
		//First check if the size of the client side players hand has been lowered by the amount of the discarded cards.
		if((serverSidePlayer.get().getHand().size() - player.getHand().size()) == (player.getPlayedList().size() - serverSidePlayer.get().getPlayedList().size()) && (player.getHand().size() == (serverSidePlayer.get().getHand().size() - toBeMovedSpace.getValue())) && (player.getPlayedList().size() == (serverSidePlayer.get().getPlayedList().size() + toBeMovedSpace.getValue()))) {
			List<Card> discardedCards = new ArrayList<>(player.getPlayedList());
			discardedCards.removeAll(serverSidePlayer.get().getPlayedList());
			if(discardedCards.size() != 0) {
				return discardedCards;
			}
		}
		return null;
	}

	//Helper method to buy cards from market.
	private List<Card> getDifferenceOfPlayedPiles(Optional<Player> serverSidePlayer, Player player){
		//First check if the size of the client side players hand has been lowered by the amount of the discarded cards.
		if((serverSidePlayer.get().getHand().size() - player.getHand().size()) == (player.getPlayedList().size() - serverSidePlayer.get().getPlayedList().size())) {
			List<Card> tradedInCards = new ArrayList<>(player.getPlayedList());
			tradedInCards.removeAll(serverSidePlayer.get().getPlayedList());
			if(tradedInCards.size() != 0) {
				return tradedInCards;
			}
		}
		return null;
	}

	//Helper method to buy cards from market.
	private List<Card> getDifferenceOfHand(Player serverSidePlayer, Player player){
		//First check if the size of the client side players hand has been lowered by the amount of the discarded cards.
		if((serverSidePlayer.getHand().size() - player.getHand().size()) == (player.getDiscardPile().size() - serverSidePlayer.getDiscardPile().size())) {
			List<Card> discardedCards = new ArrayList<>(player.getDiscardPile());
			discardedCards.removeAll(serverSidePlayer.getDiscardPile());
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
			List<Card> removedCards = new ArrayList<>(serverSidePlayer.get().getHand());
			removedCards.removeAll(player.getHand());
			if(removedCards.size() != 0) {
				return removedCards;
			}
		}
    	return null;
	}

	private Blockade getDifferenceOfBlockades(Optional<Player> serverSidePlayer, Player player){
		ArrayList<Blockade> removedBlockades = new ArrayList<>(player.getBlockades());
		removedBlockades.removeAll(serverSidePlayer.get().getBlockades());
		removedBlockades.trimToSize();
		Blockade removedBlockade = removedBlockades.get(0);
		if(removedBlockade != null){
			return removedBlockade;
		}
		return null;
	}

	//Helper method to remove a grey blockade. Moves the played cards from the server side players hand to his played cards list.
	private void moveCardsFromHandToPlayedList(Optional<Game> serverSideGame, Optional<Player> serverSidePlayer, Player player, Blockade removedBlockade, int amountOfDiscardedCards){
		List<Card> discardedCards = getDifferenceOfPlayedPiles(serverSidePlayer, player);
		if(discardedCards != null && discardedCards.size() == amountOfDiscardedCards){
			for (Card c : discardedCards){
				serverSidePlayer.get().moveFromHandToPlayedList(c);
			}
			if((Collections.disjoint(serverSidePlayer.get().getHand(), discardedCards)) && (serverSidePlayer.get().getPlayedList().containsAll(discardedCards))) {
				serverSidePlayer.get().addBlockade(removedBlockade);
				removeBlockadeOnMap(serverSideGame.get(), serverSidePlayer.get().getPlayingPiece().getPosition());
			}
		}
	}

	//Helper method to move to grey spaces. Moves the played cards from the server side players hand to his played cards list.
	private void moveCardsFromHandToPlayedList(Optional<Game> serverSideGame, Optional<Player> serverSidePlayer, Player player, Space toBeMovedSpace, int amountOfDiscardedCards){
		List<Card> discardedCards = getDifferenceOfPlayedPiles(serverSidePlayer, player, toBeMovedSpace);
		if(discardedCards != null && discardedCards.size() == amountOfDiscardedCards){
			for (Card c : discardedCards){
				serverSidePlayer.get().moveFromHandToPlayedList(c);
			}
			if((Collections.disjoint(serverSidePlayer.get().getHand(), discardedCards)) && (serverSidePlayer.get().getPlayedList().containsAll(discardedCards))) {
				serverSideGame.get().getMap().getSpace(serverSidePlayer.get().getPlayingPiece().getPosition()).switchOccupied();
				serverSidePlayer.get().getPlayingPiece().setPosition(player.getPlayingPiece().getPosition());
				toBeMovedSpace.switchOccupied();
			}
		}
	}

	private void removeHandCardsFromGame(Optional<Game> serverSideGame, Optional<Player> serverSidePlayer, Player player, Space toBeMovedSpace, int amountOfRemovedCards){
		List<Card> removedCards = getRemovedCards(serverSidePlayer, player, toBeMovedSpace);
		if(removedCards != null && removedCards.size() == amountOfRemovedCards) {
			for (Card c : removedCards) {
				serverSidePlayer.get().removeCardFromHand(c);
			}
			if(Collections.disjoint(serverSidePlayer.get().getHand(), removedCards)) {
				serverSideGame.get().getMap().getSpace(serverSidePlayer.get().getPlayingPiece().getPosition()).switchOccupied();
				serverSidePlayer.get().getPlayingPiece().setPosition(player.getPlayingPiece().getPosition());
				toBeMovedSpace.switchOccupied();
			}
		}
	}

	private boolean isPlayersTurn(Optional<Game> serverSideGame, Optional<Player> serverSidePlayer){
		//TODO: Write equals method etc. for Player class to be able to use players.indexOf()
		int positionOfPlayerInPlayers = 0;
		for(int i = 0; i < serverSideGame.get().getPlayers().size();i++){
			if(serverSideGame.get().getPlayer(i).getId() == serverSidePlayer.get().getId()){
				positionOfPlayerInPlayers = i;
			}
		}
		return serverSideGame.get().getCurrentPlayer() == positionOfPlayerInPlayers;
	}

	private void removeBlockadeOnMap(Game serverSideGame, long playingPiecePosition){
		ArrayList<Space> toBeUpdatedSpaces = new ArrayList<>();
		toBeUpdatedSpaces.add(serverSideGame.getMap().getSpace(playingPiecePosition));
		while(toBeUpdatedSpaces.size() != 0){
			ArrayList<Space> tempToBeUpdatedSpaces = new ArrayList<>();
			for (Space s : toBeUpdatedSpaces){
				s.removeBlockadeStatus();
				long[] neighbourIds = s.getNeighbours();
				for(int i = 0; i < neighbourIds.length; i++){
					Space tempSpace = serverSideGame.getMap().getSpace(neighbourIds[i]);
					if(tempSpace.isLastSpace() || tempSpace.isFirstOnNewTile()){
						tempToBeUpdatedSpaces.add(tempSpace);
					}
				}
				toBeUpdatedSpaces.remove(s);
			}
			toBeUpdatedSpaces = tempToBeUpdatedSpaces;
		}
	}

    // TODO: changestate

	// TODO: update moveCounter, reachable and hand of a player

	// TODO: Update current position of a player

	// TODO: Update coins and hand of a player

	// TODO: market

	// TODO: Update playedList, discardPile and status of players


    /*public void stopGame(Long gameId, String playerToken) {
        Optional<Game> game = gameRepository.findById(gameId);
        Optional<Player> owner = playerRepository.findByToken(playerToken);
        if (owner != null && game.isPresent()){ // && game.get().getOwner().equals(owner.get().getName())) {
            // TODO: implement the logic for stopping the game
        }
    }*/
}

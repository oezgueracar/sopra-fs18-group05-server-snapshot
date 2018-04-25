package ch.uzh.ifi.seal.soprafs18.service;

import ch.uzh.ifi.seal.soprafs18.constant.GameConstants;
import ch.uzh.ifi.seal.soprafs18.constant.GameStatus;
import ch.uzh.ifi.seal.soprafs18.entity.Game;
import ch.uzh.ifi.seal.soprafs18.entity.Player;
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
    	game.getPlayer(0).setColor("red");
		game.getPlayer(0).setReady(true);
		game.getPlayer(0).setToken(UUID.randomUUID().toString());
		Game serverSideGame = gameRepository.save(game);
		serverSideGame.getPlayer(0).setGameId(serverSideGame.getId());
		serverSideGame.setName(serverSideGame.getPlayer(0).getName() + "'s Game");
		return gameRepository.save(serverSideGame);
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
			if (game.get().getStatus() == ROOM && numberOfPlayers < GameConstants.MAX_PLAYERS){
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
				System.out.println("Could not join game. Game room is full or game is already running.");
			}

		}
		else {
			this.logger.error("Error adding player with id: " + player.getId());
		}
		return null;
	}

	// TODO: Getplayer
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
						Boolean allPlayersReady = true;
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
							for (Player p : serverSideGame.get().getPlayers()) {
								p.setup();
								playerRepository.save(p);
							}
							serverSideGame.get().startGame();
							serverSideGame.get().setStatus(GameStatus.RUNNING);
						}
					}
					return gameRepository.save(serverSideGame.get());
				case RUNNING:
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

					Boolean colorAlreadyTaken = false;
					for(Player p: serverSideGame.get().getPlayers()){
						if (p.getColor().equals(player.getColor())){
							colorAlreadyTaken = true;
						}
					}
					if (!colorAlreadyTaken){
						serverSidePlayer.get().setColor(player.getColor());
					}

					return playerRepository.save(serverSidePlayer.get());
			}
		}
		return null;
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

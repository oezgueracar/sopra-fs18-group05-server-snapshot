package ch.uzh.ifi.seal.soprafs18.service;

import ch.uzh.ifi.seal.soprafs18.GameConstants;
import ch.uzh.ifi.seal.soprafs18.entity.Game;
import ch.uzh.ifi.seal.soprafs18.entity.Move;
import ch.uzh.ifi.seal.soprafs18.entity.Player;
import ch.uzh.ifi.seal.soprafs18.repository.GameRepository;
import ch.uzh.ifi.seal.soprafs18.repository.PlayerRepository;
import ch.uzh.ifi.seal.soprafs18.web.rest.GameResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    // TODO: create a new game
    public Game addGame(Game game) {
    	game.setTurnTime(60);
		//game = gameRepository.save(game);
        return gameRepository.save(game);//CONTEXT + "/" + game.getId();
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

	// TODO: Add player and join game
	public Player addPlayer(Long gameId, Player player) {
		Optional<Game> game = gameRepository.findById(gameId);

		if (game.isPresent()) {
			int numberOfPlayers = game.get().getPlayers().size();

			// Add player to playerRepository
			//TODO: Change MAX_PLAYERS to the attribute of the game itself later on...
			if (numberOfPlayers < GameConstants.MAX_PLAYERS){
				player.setToken(UUID.randomUUID().toString());
				player.setReady(false);
				player.setPlayerLeft(false);
				player.setIsInGoal(false);
				player.setGameId(gameId);
				playerRepository.save(player);

				// Set leader if this player is the first added player to this Game
				/*if (numberOfPlayers == 0) {
					game.get().setLeader(player);
				}*/

				game.get().addPlayer(player);

				this.logger.debug("Game: " + game.get().getName() + " - player added: " + player.getName());
				return playerRepository.save(player);//CONTEXT + "/" + gameId + "/players/" + player.getId();
			}

		} else {
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

	// TODO: startgame
    public void startGame(Long gameId, String playerToken) {
        Optional<Game> game = gameRepository.findById(gameId);
        Optional<Player> leader = playerRepository.findByToken(playerToken);

        if (leader != null && game.isPresent()){ //&& game.get().getOwner().equals(owner.get().getName())) {
            // TODO: implement the logic for starting the game
        }
    }

    // TODO: changestate

	// TODO: update moveCounter, reachable and hand of a player

	// TODO: Update current position of a player

	// TODO: Update coins and hand of a player

	// TODO: market

	// TODO: Update playedList, discardPile and status of players


    public void stopGame(Long gameId, String playerToken) {
        Optional<Game> game = gameRepository.findById(gameId);
        Optional<Player> owner = playerRepository.findByToken(playerToken);
        if (owner != null && game.isPresent()){ // && game.get().getOwner().equals(owner.get().getName())) {
            // TODO: implement the logic for stopping the game
        }
    }

    /*public List<Move> listMoves(Long gameId) {
        Optional<Game> game = gameRepository.findById(gameId);
        if (game.isPresent()) {
            return game.get().getMoves();
        }
        return null;
    }*/

   /* public void addMove(Move move) {
        // TODO: Mapping into Move + execution of move
    }*/
}

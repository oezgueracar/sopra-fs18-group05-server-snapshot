package ch.uzh.ifi.seal.soprafs18.web.rest;

import ch.uzh.ifi.seal.soprafs18.entity.Game;
import ch.uzh.ifi.seal.soprafs18.entity.Move;
import ch.uzh.ifi.seal.soprafs18.entity.Player;
import ch.uzh.ifi.seal.soprafs18.repository.GameRepository;
import ch.uzh.ifi.seal.soprafs18.repository.PlayerRepository;
import ch.uzh.ifi.seal.soprafs18.service.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;


/**
 * This class is in charge of managing the communication between the server and the client (RESTful Interface)
 */
@RestController
public class GameResource
        extends GenericResource {

    private final String CONTEXT = "/games";
    Logger logger = LoggerFactory.getLogger(GameResource.class);

    @Autowired
    private PlayerRepository playerRepo;
    @Autowired
    private GameRepository gameRepo;

    @Autowired
    private GameService gameService;

    // TODO: Retrieve a list of games
    @RequestMapping(value = CONTEXT)
    @ResponseStatus(HttpStatus.OK)
    public List<Game> listGames() {
        logger.debug("listGames");
        return this.gameService.listGames();
    }

    // TODO: Create a game
    // TODO: Frontend --> callback for join game after game is created
    @RequestMapping(value = CONTEXT, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String addGame(@RequestBody Game game) {
        logger.debug("addGame: " + game);
        return this.gameService.addGame(game);
    }

    // TODO: Retrieve information of a game
    @RequestMapping(value = CONTEXT + "/{gameId}")
    @ResponseStatus(HttpStatus.OK)
    public Game getGame(@PathVariable Long gameId) {
        logger.debug("getGame: " + gameId);
        return this.gameService.getGame(gameId);
    }

    // TODO: Retrieve list of players in a game
    @RequestMapping(value = CONTEXT + "/{gameId}/players")
    @ResponseStatus(HttpStatus.OK)
    public List<Player> listPlayers(@PathVariable Long gameId) {
        logger.debug("listPlayers");
        return this.gameService.listPlayers(gameId);
    }

    // TODO: Create player and join game
    @RequestMapping(value = CONTEXT + "/{gameId}/players", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Player addPlayer(@PathVariable Long gameId, @RequestBody Player player) {
        logger.debug("addPlayerAndJoinGame: " + player);
        return this.gameService.addPlayer(gameId, player);
    }

    // TODO: Retrieve information of a player
    @RequestMapping(value = CONTEXT + "/{gameId}/players/{playerId}")
    @ResponseStatus(HttpStatus.OK)
    public Player getPlayer(@PathVariable Long gameId, @PathVariable Integer playerId) {
        logger.debug("getPlayer: " + gameId);
        return this.gameService.getPlayer(gameId, playerId);
    }

    // TODO: Start a game, initialize cards
    @RequestMapping(value = CONTEXT + "/{gameId}/start", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void startGame(@PathVariable Long gameId, @RequestParam("token") String playerToken) {
        logger.debug("startGame: " + gameId);
        this.gameService.startGame(gameId, playerToken);
    }

    // TODO: Change ready state of a player
    @RequestMapping(value = CONTEXT + "/{gameId}/players/{playerID}/state", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public String changeState(@PathVariable Long gameId, @RequestParam("token") String playerToken) {
        logger.debug("changeState: " + playerToken);
        return this.gameService.addPlayer(gameId, playerToken);
    }

    // TODO: Update moveCounter, reachable and hand of a player

    // TODO: Update current position of a player

    // TODO: Update coins and hand of a player

    // TODO: market

    // TODO: Update playedList, discardPile and status of players

}
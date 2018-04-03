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

    @RequestMapping(value = CONTEXT)
    @ResponseStatus(HttpStatus.OK)
    public List<Game> listGames() {
        logger.debug("listGames");
        return this.gameService.listGames();
    }

    @RequestMapping(value = CONTEXT, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String addGame(@RequestBody Game game, @RequestParam("token") String playerToken) {
        logger.debug("addGame: " + game);
        return this.gameService.addGame(game, playerToken);
    }

    /*
     * Context: /games/{gameId}
     */
    @RequestMapping(value = CONTEXT + "/{gameId}")
    @ResponseStatus(HttpStatus.OK)
    public Game getGame(@PathVariable Long gameId) {
        logger.debug("getGame: " + gameId);
        return this.gameService.getGame(gameId);
    }

    @RequestMapping(value = CONTEXT + "/{gameId}/start", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void startGame(@PathVariable Long gameId, @RequestParam("token") String playerToken) {
        logger.debug("startGame: " + gameId);
        this.gameService.startGame(gameId, playerToken);
    }

    @RequestMapping(value = CONTEXT + "/{gameId}/stop", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void stopGame(@PathVariable Long gameId, @RequestParam("token") String playerToken) {
        logger.debug("stopGame: " + gameId);
        this.gameService.stopGame(gameId, playerToken);
    }

    /*
     * Context: /games/{gameId}/moves
     */
    @RequestMapping(value = CONTEXT + "/{gameId}/moves")
    @ResponseStatus(HttpStatus.OK)
    public List<Move> listMoves(@PathVariable Long gameId) {
        logger.debug("listMoves");
        return this.gameService.listMoves(gameId);
    }

    @RequestMapping(value = CONTEXT + "/{gameId}/moves", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addMove(@RequestBody Move move) {
        logger.debug("addMove: " + move);
        this.gameService.addMove(move);
    }

    @RequestMapping(value = CONTEXT + "/{gameId}/moves/{moveId}")
    @ResponseStatus(HttpStatus.OK)
    public Move getMove(@PathVariable Long gameId, @PathVariable Integer moveId) {
        logger.debug("getMove: " + gameId);
        return this.gameService.getMove(gameId, moveId);
    }

    /*
     * Context: /game/{game-id}/player
     */
    @RequestMapping(value = CONTEXT + "/{gameId}/players")
    @ResponseStatus(HttpStatus.OK)
    public List<Player> listPlayers(@PathVariable Long gameId) {
        logger.debug("listPlayers");
        return this.gameService.listPlayers(gameId);
    }

    @RequestMapping(value = CONTEXT + "/{gameId}/players", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public String addPlayer(@PathVariable Long gameId, @RequestParam("token") String playerToken) {
        logger.debug("addPlayer: " + playerToken);
        return this.gameService.addPlayer(gameId, playerToken);
    }

    @RequestMapping(value = CONTEXT + "/{gameId}/players/{playerId}")
    @ResponseStatus(HttpStatus.OK)
    public Player getPlayer(@PathVariable Long gameId, @PathVariable Integer playerId) {
        logger.debug("getPlayer: " + gameId);
        return this.gameService.getPlayer(gameId, playerId);
    }

}
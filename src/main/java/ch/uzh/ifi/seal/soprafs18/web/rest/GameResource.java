package ch.uzh.ifi.seal.soprafs18.web.rest;

import ch.uzh.ifi.seal.soprafs18.entity.Game;
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

    @RequestMapping(value = CONTEXT, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Game addGame(@RequestBody Game game) {
        logger.debug("addGame: " + game);
        return this.gameService.addGame(game);
    }

    @RequestMapping(value = CONTEXT + "/{gameId}/players", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Player addPlayer(@PathVariable Long gameId, @RequestBody Player player) {
        logger.debug("addPlayer: " + player);
        return this.gameService.addPlayer(gameId, player);
    }

    @RequestMapping(value = CONTEXT)
    @ResponseStatus(HttpStatus.OK)
    public List<Game> listGames() {
        logger.debug("listGames");
        return this.gameService.listGames();
    }

    @RequestMapping(value = CONTEXT + "/{gameId}")
    @ResponseStatus(HttpStatus.OK)
    public Game getGame(@PathVariable Long gameId) {
        logger.debug("getGame: " + gameId);
        return this.gameService.getGame(gameId);
    }

    @RequestMapping(value = CONTEXT + "/{gameId}/players")
    @ResponseStatus(HttpStatus.OK)
    public List<Player> listPlayers(@PathVariable Long gameId) {
        logger.debug("listPlayers");
        return this.gameService.listPlayers(gameId);
    }

    @RequestMapping(value = CONTEXT + "/{gameId}/players/{playerId}")
    @ResponseStatus(HttpStatus.OK)
    public Player getPlayer(@PathVariable Long gameId, @PathVariable Long playerId) {
        logger.debug("getPlayer: " + playerId + "from game:" + gameId);
        return this.gameService.getPlayer(gameId, playerId);
    }

    @CrossOrigin
    @RequestMapping(value = CONTEXT + "/{gameId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Game updateGame(@PathVariable Long gameId, @RequestBody Game game) {
        logger.debug("startGame: " + gameId);
        return this.gameService.updateGame(gameId, game);
    }

    @CrossOrigin
    @RequestMapping(value = CONTEXT + "/{gameId}/fastForward", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Game fastForwardGame(@PathVariable Long gameId) {
        logger.debug("fastForwardGame: " + gameId);
        return this.gameService.fastForwardGame(gameId);
    }

    @CrossOrigin
    @RequestMapping(value = CONTEXT + "/{gameId}/players/{playerId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Player updatePlayer(@PathVariable Long gameId, @PathVariable Long playerId, @RequestBody Player player) {
        logger.debug("updatePlayer: " + playerId);
        return this.gameService.updatePlayer(gameId, playerId, player);
    }

    @CrossOrigin
    @RequestMapping(value = CONTEXT + "/{gameId}/players/{playerId}/cards", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Player buyCard(@PathVariable Long gameId, @PathVariable Long playerId, @RequestBody Player player) {
        logger.debug("buyCard: " + player.getBoughtCardId());
        return this.gameService.buyCard(gameId, playerId, player);
    }

    @CrossOrigin
    @RequestMapping(value = CONTEXT + "/{gameId}/players/{playerId}/cards/{cardId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Player playCard(@PathVariable Long gameId, @PathVariable Long playerId, @RequestBody Player player,
                           @PathVariable long cardId) {
        logger.debug("playCard: " + cardId);
        return this.gameService.playCard(gameId, playerId, player, cardId);
    }
}
package ch.uzh.ifi.seal.soprafs18.web.rest;

import ch.uzh.ifi.seal.soprafs18.entity.Game;
import ch.uzh.ifi.seal.soprafs18.entity.Market;
import ch.uzh.ifi.seal.soprafs18.entity.Player;
import ch.uzh.ifi.seal.soprafs18.repository.GameRepository;
import ch.uzh.ifi.seal.soprafs18.repository.PlayerRepository;
import ch.uzh.ifi.seal.soprafs18.service.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        if(game != null && game.getPlayers() != null) {
            logger.debug("addGame: " + game);
            return this.gameService.addGame(game);
        }
        else {
            throw new IllegalArgumentException("Bad JSON Request. You need to put the leader into the game.");
        }
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

    @RequestMapping(value = CONTEXT + "/{gameId}/market")
    @ResponseStatus(HttpStatus.OK)
    public Market getMarket(@PathVariable Long gameId) {
        logger.debug("getMarketOf: " + gameId);
        return this.gameService.getGame(gameId).getMarket();
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

    @RequestMapping(value = CONTEXT + "/{gameId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Game updateGame(@PathVariable Long gameId, @RequestBody Game game) {
        logger.debug("startGame: " + gameId);
        return this.gameService.updateGame(gameId, game);
    }

    @RequestMapping(value = CONTEXT + "/{gameId}/players/{playerId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Player updatePlayer(@PathVariable Long gameId, @PathVariable Long playerId, @RequestBody Player player) {
        logger.debug("updatePlayer: " + playerId);
        return this.gameService.updatePlayer(gameId, playerId, player);
    }

    @RequestMapping(value = CONTEXT + "/{gameId}/players/{playerId}/cards/", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Player buyCard(@PathVariable Long gameId, @PathVariable Long playerId, @RequestBody Player player) {
        logger.debug("buyCard: " + player.getBoughtCardId());
        return this.gameService.buyCard(gameId, playerId, player);
    }

    @RequestMapping(value = CONTEXT + "/{gameId}/players/{playerId}/cards/{cardId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Player playCard(@PathVariable Long gameId, @PathVariable Long playerId, @RequestBody Player player, @PathVariable long cardId) {
        logger.debug("playCard: " + cardId);
        return this.gameService.playCard(gameId, playerId, player, cardId);
    }

    // TODO: Change ready state of a player
    /*@RequestMapping(value = CONTEXT + "/{gameId}/players/{playerID}/state", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public String changeState(@PathVariable Long gameId, @RequestParam("token") String playerToken) {
        logger.debug("changeState: " + playerToken);
        return this.gameService.addPlayer(gameId, playerToken);
    }*/

    // TODO: Update moveCounter, reachable and hand of a player

    // TODO: Update current position of a player

    // TODO: Update coins and hand of a player

    // TODO: market

    // TODO: Update playedList, discardPile and status of players

    @ExceptionHandler
    private void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

}
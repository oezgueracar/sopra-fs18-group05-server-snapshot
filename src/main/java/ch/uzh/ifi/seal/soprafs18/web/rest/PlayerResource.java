package ch.uzh.ifi.seal.soprafs18.web.rest;

import ch.uzh.ifi.seal.soprafs18.entity.Player;
import ch.uzh.ifi.seal.soprafs18.repository.PlayerRepository;
import ch.uzh.ifi.seal.soprafs18.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(PlayerResource.CONTEXT)
public class PlayerResource extends GenericResource {

    static final String CONTEXT = "/players";
    Logger logger = LoggerFactory.getLogger(PlayerResource.class);
    @Autowired
    private PlayerRepository playerRepo;

    @Autowired
    private PlayerService playerService;

    // Retrieve list of players
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Player> listPlayers() {
        logger.debug("listPlayers");
        return this.playerService.getAllPlayers();
    }

    // Create player
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Player addPlayer(@RequestBody Player player) {
        logger.debug("addPlayer: " + player);
        return this.playerService.addPlayer(player);
    }

    // Retrieve a player
    @RequestMapping(method = RequestMethod.GET, value = "{playerID}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Player> getPlayer(@PathVariable Long playerID) {
        logger.debug("getPlayer: " + playerID);
        return playerRepo.findById(playerID);
    }

	// Update moveCounter, reachable and hand of player
    @RequestMapping(method = RequestMethod.PUT, value = "{playerID}/card")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Player> playCard(@PathVariable Long playerID, @RequestBody Long cardID) {
    	logger.debug("updatePlayer: " + playerID);
    	return playerRepo.findById(playerID);
    }

    // Update current position of player
	@RequestMapping(method = RequestMethod.PUT, value = "{playerID}/move")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Player> movePlayer(@PathVariable Long playerID, @RequestBody Long spaceID) {
    	logger.debug("updateCurrentPosition: " + playerID);
		return playerRepo.findById(playerID);
	}

	// Update coins and hand of player after card is traded for coins
	@RequestMapping(method = RequestMethod.PUT, value = "{playerID}/sale")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Player> saleCard(@PathVariable Long playerID, @RequestParam("cardID") Long cardID) {
    	logger.debug("updateCoins: " + playerID);
		return playerRepo.findById(playerID);
	}

	// TODO: Check if two parsed jsons can be returned together - otherwise create an additional request
	// Update coins and discardPile of player after buy of a card
	// Update market
	@RequestMapping(method = RequestMethod.PUT, value = "{playerID}/buy")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Player> buyCard(@PathVariable Long playerID, @RequestParam("cardID") Long cardID) {
		return playerRepo.findById(playerID);
	}

	// Update discardPile and status of player after player ends his turn
	@RequestMapping(method = RequestMethod.PUT, value = "{playerID}/turnEnd")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Player> endTurn(@PathVariable Long playerID) {
    	logger.debug("turnEnd:" + playerID);
		return playerRepo.findById(playerID);
	}
}

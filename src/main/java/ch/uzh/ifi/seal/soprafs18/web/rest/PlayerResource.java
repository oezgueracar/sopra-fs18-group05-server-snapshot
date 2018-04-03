package ch.uzh.ifi.seal.soprafs18.web.rest;

import ch.uzh.ifi.seal.soprafs18.entity.Player;
import ch.uzh.ifi.seal.soprafs18.repository.PlayerRepository;
import ch.uzh.ifi.seal.soprafs18.service.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Player> listPlayers() {
        logger.debug("listPlayers");
        return this.playerService.getAllPlayers();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Player addPlayer(@RequestBody Player player) {
        logger.debug("addPlayer: " + player);
        return this.playerService.addPlayer(player);
    }


    @RequestMapping(method = RequestMethod.GET, value = "{playerID}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Player> getPlayer(@PathVariable Long playerID) {
        logger.debug("getPlayer: " + playerID);
        return playerRepo.findById(playerID);
    }

    @RequestMapping(method = RequestMethod.POST, value = "{playerID}/login")
    @ResponseStatus(HttpStatus.OK)
    public Player login(@PathVariable Long playerID) {
        logger.debug("login: " + playerID);
        return this.playerService.login(playerID);
    }

    @RequestMapping(method = RequestMethod.POST, value = "{playerID}/logout")
    @ResponseStatus(HttpStatus.OK)
    public void logout(@PathVariable Long playerID, @RequestParam("token") String playerToken) {
        logger.debug("getPlayer: " + playerID);
        this.playerService.logout(playerID, playerToken);
    }
}

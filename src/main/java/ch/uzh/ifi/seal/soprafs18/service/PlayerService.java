package ch.uzh.ifi.seal.soprafs18.service;

import ch.uzh.ifi.seal.soprafs18.constant.PlayerStatus;
import ch.uzh.ifi.seal.soprafs18.entity.Game;
import ch.uzh.ifi.seal.soprafs18.entity.Player;
import ch.uzh.ifi.seal.soprafs18.repository.PlayerRepository;
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
 * /**
 * Created by LucasPelloni on 26.01.18.
 * Service class for managing players.
 */
@Service
@Transactional
public class PlayerService {

    private final Logger log = LoggerFactory.getLogger(PlayerService.class);


    private final PlayerRepository playerRepository;


    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    /*// Create information about a player
    public Player createPlayer(String name, String playerName, String token, PlayerStatus status, List<Game> games) {
        Player newPlayer = new Player(name);
        newPlayer.setToken(token);
        newPlayer.setStatus(status);
        newPlayer.setGames(games);
        playerRepository.save(newPlayer);
        log.debug("Created Information for Player: {}", newPlayer);
        return newPlayer;
    }*/

    /*public Player login(Long playerID) {
        Optional<Player> playerOptional = playerRepository.findById(playerID);
        if (playerOptional.isPresent()) {
            Player player = playerOptional.get();
            player.setToken(UUID.randomUUID().toString());
            player.setStatus(PlayerStatus.ONLINE);
            player = playerRepository.save(player);
            return player;
        }
        return null;
    }*/

    /*public void logout(Long playerID, String playerToken) {
        Optional<Player> playerOptional = playerRepository.findById(playerID);
        if (playerOptional.isPresent() && playerOptional.get().getToken().equals(playerToken)) {
            Player player = playerOptional.get();
            player.setStatus(PlayerStatus.OFFLINE);
            playerRepository.save(player);
        }
    }*/

    // add a player, init status, create token and save him to the player Repo
    public Player addPlayer(Player player) {
        //player.setStatus(PlayerStatus.OFFLINE);
        player.setToken(UUID.randomUUID().toString());
        return playerRepository.save(player);
    }

    // Get a list of all players
    public List<Player> getAllPlayers() {
        List<Player> result = new ArrayList<>();
        playerRepository.findAll().forEach(result::add);
        return result;
    }


    public void deletePlayer(Long id) {
        Optional<Player> playerOptional = playerRepository.findById(id); //TODO check if player exists
        if (playerOptional.isPresent()) {
            Player player = playerOptional.get();
            playerRepository.delete(player);
            log.debug("Deleted Player: {}", player);
        }
    }
}

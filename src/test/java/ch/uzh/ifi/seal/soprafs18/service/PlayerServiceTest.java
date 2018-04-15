package ch.uzh.ifi.seal.soprafs18.service;

import ch.uzh.ifi.seal.soprafs18.Application;
import ch.uzh.ifi.seal.soprafs18.constant.PlayerStatus;
import ch.uzh.ifi.seal.soprafs18.entity.Game;
import ch.uzh.ifi.seal.soprafs18.entity.Player;
import ch.uzh.ifi.seal.soprafs18.repository.PlayerRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.assertNotNull;


/**
 * Test class for the UserResource REST resource.
 *
 * @see PlayerService
 */
@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes= Application.class)
public class PlayerServiceTest {


//    @Autowired
 //   private PlayerRepository playerRepository;

    @Autowired
    private PlayerService playerService;

    private List<Game> games;

/*    @Test
    public void createUser() {
        Assert.assertNull(playerRepository.findByToken("t123"));
        Player player = playerService.createPlayer("testName", "testUsername", "t123", PlayerStatus.ONLINE, games);
        assertNotNull(playerRepository.findByToken("t123"));
        Assert.assertEquals(playerRepository.findByToken("t123"), player);
    }

    @Test
    public void deleteUser() {
        Player player = playerService.createPlayer("testName2", "testUsername2", "t1232", PlayerStatus.ONLINE, games);
        playerRepository.delete(player);
        Assert.assertFalse(playerRepository.findById(player.getId()).isPresent());
    }*/
}

package ch.uzh.ifi.seal.soprafs18.entity;

import ch.uzh.ifi.seal.soprafs18.constant.GameConstants;
import ch.uzh.ifi.seal.soprafs18.constant.GameStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GameTest {

    Game game;
    Player p1;
    Player p2;
    Player p3;
    Player p4;
    Player p5;

    @Before
    public void setUp() throws Exception {
        game = new Game();
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();
        p4 = new Player();
        p5 = new Player();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void Constructor(){
        Game game2 = new Game();
        assertTrue(game2.getTurnTime() == 60);
        assertEquals("HillsOfGold", game2.getMapName());
        assertTrue(game2.getStatus() == GameStatus.ROOM);
    }

    @Test
    public void addPlayer() {
        p1.setName("TestPlayer1");
        game.addPlayer(p1);
        assertEquals("TestPlayer1", game.getPlayer(0).getName());
    }

    //Tests if adding more players to a game than the amount of MAX_PLAYERS is possible. It should not be possible.
    @Test
    public void addTooManyPlayer() {
        p1.setName("TestPlayer1");
        p2.setName("TestPlayer2");
        p3.setName("TestPlayer3");
        p4.setName("TestPlayer4");
        p5.setName("TestPlayer5");
        game.addPlayer(p1);
        game.addPlayer(p2);
        game.addPlayer(p3);
        game.addPlayer(p4);
        game.addPlayer(p5);

        assertTrue(game.getPlayers().size() == GameConstants.MAX_PLAYERS);
    }

    @Test
    public void setStatus() {
        game.setStatus(GameStatus.FINISHED);

        assertTrue(game.getStatus() == GameStatus.FINISHED);
    }

    @Test
    public void setMapName() {
        game.setMapName("Swamplands");

        assertEquals("Swamplands", game.getMapName());
    }

    @Test
    public void setTurnTime() {
        game.setTurnTime(120);

        assertTrue(game.getTurnTime() == 120);
    }

    @Test
    public void setName() {
        game.setName("Best Game");

        assertEquals("Best Game",game.getName());
    }

    @Test
    public void changeCurrentPlayer() {
        p1.setName("TestPlayer1");
        p2.setName("TestPlayer2");
        game.addPlayer(p1);
        game.addPlayer(p2);

        game.changeCurrentPlayer();

        assertTrue(game.getCurrentPlayer() == 1);

        game.changeCurrentPlayer();

        assertTrue(game.getCurrentPlayer() == 0);

        p3.setName("TestPlayer3");
        p4.setName("TestPlayer4");

        game.addPlayer(p3);
        game.addPlayer(p4);

        game.changeCurrentPlayer();
        game.changeCurrentPlayer();
        game.changeCurrentPlayer();

        assertTrue(game.getCurrentPlayer() == 3);

        game.changeCurrentPlayer();

        assertTrue(game.getCurrentPlayer() == 0);
    }

    @Test
    public void setup() {
        game.setup();

        assertEquals("HillsOfGold", game.getMapName());
        assertTrue(game.getStatus() == GameStatus.ROOM);
    }

    @Test
    public void getPlayers() {
        p1.setName("TestPlayer1");
        p2.setName("TestPlayer2");
        game.addPlayer(p1);
        game.addPlayer(p2);

        ArrayList<Player> testList = new ArrayList<>();
        testList.add(p1);
        testList.add(p2);

        assertTrue(game.getPlayers().containsAll(testList));
    }

    @Test
    public void getStatus() {
        game.setStatus(GameStatus.RUNNING);

        assertTrue(game.getStatus() == GameStatus.RUNNING);
    }

    @Test
    public void getName() {
        game.setName("CoolGame");

        assertEquals("CoolGame", game.getName());
    }

    @Test
    public void getTurnTime() {
        game.setTurnTime(120);

        assertTrue(game.getTurnTime() == 120);
    }

    @Test
    public void getMapName() {
        game.setMapName("DemoMap");

        assertEquals("DemoMap", game.getMapName());
    }

    @Test
    public void getPlayer() {
        p1.setName("TestPlayer1");
        p2.setName("TestPlayer2");
        game.addPlayer(p1);
        game.addPlayer(p2);

        assertEquals(p2.getName(), game.getPlayer(1).getName());
    }

    @Test
    public void getCurrentPlayer() {
        p1.setName("TestPlayer1");
        p2.setName("TestPlayer2");
        p3.setName("TestPlayer3");
        game.addPlayer(p1);
        game.addPlayer(p2);
        game.addPlayer(p3);

        game.changeCurrentPlayer();
        game.changeCurrentPlayer();

        assertTrue(game.getCurrentPlayer() == 2);

    }
}
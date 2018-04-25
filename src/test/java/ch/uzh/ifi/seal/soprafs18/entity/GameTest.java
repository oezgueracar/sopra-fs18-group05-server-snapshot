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
        assertEquals("HillsOfGoldMap", game2.getMapName());
        assertTrue(game2.getStatus() == GameStatus.ROOM);
    }

    @Test
    public void addPlayer() {
        p1.setName("TestPlayer1");
        game.addPlayer(p1);
        assertEquals("TestPlayer1", game.getPlayer(0).getName());
    }

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
        System.out.println(game.getPlayers().size());

        assertTrue(game.getPlayers().size() == GameConstants.MAX_PLAYERS);
    }

    @Test
    public void setStatus() {
    }

    @Test
    public void setMapName() {
    }

    @Test
    public void setTurnTime() {
    }

    @Test
    public void setName() {
    }

    @Test
    public void changeCurrentPlayer() {
    }

    @Test
    public void setup() {
    }

    @Test
    public void startGame() {
    }

    @Test
    public void getId() {
    }

    @Test
    public void getPlayers() {
    }

    @Test
    public void getStatus() {
    }

    @Test
    public void getName() {
    }

    @Test
    public void getTurnTime() {
    }

    @Test
    public void getMapName() {
    }

    @Test
    public void getPlayer() {
    }

    @Test
    public void getCurrentPlayer() {
    }
}
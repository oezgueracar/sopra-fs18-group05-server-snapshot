package ch.uzh.ifi.seal.soprafs18.entity;

import ch.uzh.ifi.seal.soprafs18.entity.card.Card;
import ch.uzh.ifi.seal.soprafs18.entity.card.ExpeditionCard;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PlayerTest {

    Player p;
    ExpeditionCard c;
    Market m;

    @Before
    public void setUp() {
        p = new Player();
        c = new ExpeditionCard(1f, 1f, "CardName", "green", 1, true);
        p.setup();
        m = new Market();
    }

    @Test
    public void getToken() {
        p.setToken("p1");
        assertEquals("p1", p.getToken());
    }

    @Test
    public void setToken() {
        String t = "p1";
        p.setToken("p1");
        assertEquals(t, p.getToken());
    }

    @Test
    public void getName() {
        p.setName("p1");
        assertEquals("p1", p.getName());
    }

    @Test
    public void setName() {
        String t = "p1";
        p.setName("p1");
        assertEquals(t, p.getName());
    }

    @Test
    public void getReady() {
        p.setReady(true);
        assertEquals(true, p.getReady());
    }

    @Test
    public void setReady() {
        Boolean b = true;
        p.setReady(true);
        assertEquals(b, p.getReady());
    }

    @Test
    public void setGameId() {
        Long l = Long.valueOf(1);
        p.setGameId((long) 1);
        assertEquals(l, p.getGameId());
    }

    @Test
    public void getColor() {
        p.setColor("green");
        assertEquals("green", p.getColor());
    }

    /*@Test
    public void getDeck() {
        p.deck.add(c);
        testPile.add(c);
        assertEquals(testPile,p.getDeck());
    }*/

    /*@Test
    public void getHand() {
        p.hand.add(c);
        testPile.add(c);
        assertEquals(testPile, p.getHand());
    }*/

  /*  @Test
    public void getMoveCounter() {}
*/
/*    @Test
    public void getCoins(){}*/

    @Test
    public void getPlayerLeft() {
        assertEquals(false, p.getPlayerLeft());
    }

    @Test
    public void getIsInGoal() {
        assertEquals(false, p.getIsInGoal());
    }

    /*@Test
    public void getDiscardPile() {
        testPile.add(c);
        p.addCardToDiscardPile(c);
        assertEquals(testPile,p.getDiscardPile());
    }*/

    @Test
    public void getPlayedList() {
        p.getPlayedList().add(c);
        assertEquals(1, p.getPlayedList().size());
    }

    /*@Test
    public void getGameId() {
        p.setGameId((long) 1);
        assertEquals(java.util.Optional.of(1), p.getGameId());
    }*/

    @Test
    public void getPlayingPiece() {
        p.setColor("green");
        p.setup();
        assertEquals("green",p.getPlayingPiece().getColor());
    }

    @Test
    public void playCard() {
        p.playCard(c);
        p.getHand().add(c);
        assertEquals(5,p.getHand().size());
        p.playCard(c);
        assertEquals(4, p.getHand().size());
    }

    @Test
    public void buyCard() {
        assertEquals(0, p.getDiscardPile().size());
        p.coins= 10;
        p.buyCard(m.getOpenSlots().get(0)[0].getId(), m);
        assertEquals(1, p.getDiscardPile().size());
        assertEquals(2, m.getOpenSlots().get(0).length);
        p.coins = 0;
    }

 /*   @Test
    public void sellCard() {
        p.setup();
        p.getHand().add(c);
        p.sellCard(c);
        assertEquals(c.getGoldValue(),p.getCoins(),0f);
    }*/

    @Test
    public void drawCard() {
        p.setup();
        int testInt = p.getHand().size();
        p.drawCard();
        int testInt2 = p.getHand().size();
        assertEquals(testInt+1, testInt2);
    }

    @Test
    public void flushPlayedList(){
        p.getPlayedList().add(c);
        assertEquals(1,p.getPlayedList().size());
        assertEquals(0,p.getDiscardPile().size());
        p.flushPlayedList();
        assertEquals(0,p.getPlayedList().size());
        assertEquals(1,p.getDiscardPile().size());
    }


    @Test
    public void setMoveCounter() {
        p.setup();
        int testInt= p.getMoveCounter()[0];
        p.setMoveCounter(c.getValue(), c.getColor());
        assertEquals(testInt, p.getMoveCounter()[0]-1);
        p.setMoveCounter(c.getValue(), "blue");
        assertEquals(testInt, p.getMoveCounter()[0]-1);
        p.setMoveCounter(c.getValue(), "yellow");
        assertEquals(testInt, p.getMoveCounter()[0]-1);
    }

    @Test
    public void resetMoveCounter() {
        p.setup();
        p.setMoveCounter(c.getValue(), c.getColor());
        p.resetMoveCounter();
        assertEquals(0, p.getMoveCounter()[0]);
    }

   /* @Test
    public void setCoins() {
        p.setup();
        float testFloat = p.getCoins();
        p.getHand().add(c);
        p.sellCard(c);
        assertEquals(testFloat, p.getCoins()-1f,0);
    }*/

   /* @Test
    public void resetCoins() {
        p.setup();
        p.sellCard(c);
        p.resetCoins();
        assertEquals(0, p.getCoins(),0);
    }*/

    @Test
    public void setPlayerLeft() {
        p.setup();
        p.setPlayerLeft(true);
        assertTrue(p.getPlayerLeft());
    }

    @Test
    public void setIsInGoal() {
        p.setup();
        p.setIsInGoal(true);
        assertTrue(p.getIsInGoal());
    }

    @Test
    public void setColor() {
        p.setup();
        p.setColor("green");
        assertEquals("green", p.getColor());
    }

    @Test
    public void setupCards(){
        p.setColor("blue");
        p.setup();
        assertEquals("blue", p.getPlayingPiece().getColor());
        assertEquals(4,p.getHand().size());
        assertEquals(0, p.getPlayedList().size());
        assertEquals(4,p.getDeck().size());

    }
    @Test
    public void setup() {
        p.setColor("green");
        p.setup();
        assertEquals("green", p.getPlayingPiece().getColor());
        assertEquals(4,p.getHand().size());
        assertEquals(0, p.getPlayedList().size());
        assertEquals(4,p.getDeck().size());

    }
}
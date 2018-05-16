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

/*    @Test
    public void getPlayerLeft() {
        assertEquals(false, p.getPlayerLeft());
    }*/

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
        assertNull(p.getPlayingPiece2());
    }

    @Test
    public void playCard() {
        p.playCard(c);
        p.getHand().add(c);
        assertEquals(5,p.getHand().size());
        p.playCard(c);
        assertEquals(4, p.getHand().size());
        p.playCard(null);
    }

    @Test
    public void buyCard() {
        assertEquals(0, p.getDiscardPile().size());
        p.coins= 10;
        p.buyCard(m.getOpenSlots().get(0)[0].getId(), m);
        assertEquals(1, p.getDiscardPile().size());
        assertEquals(2, m.getOpenSlots().get(0).length);
        assertEquals(9,p.getCoins(),0);
        p.buyCard(m.getOpenSlots().get(4)[0].getId(), m);
        assertEquals(6,p.getCoins(),0);
        p.coins = 0;
    }

    @Test
    public void tradeinCard(){
        p.coins =0;
        float l = p.getHand().get(0).getGoldValue();
        p.tradeinCard(p.getHand().get(0).getId());
        assertEquals(l,p.getCoins(),0);
    }

    @Test
    public void getCardFromHandById(){
        p.hand.add(c);
        p.getCardFromHandById(c.getId());
        p.getCardFromHandById(12223);
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
        p.drawCard();
        p.drawCard();
        p.drawCard();
        p.drawCard();
        p.drawCard();
        p.drawCard();
        p.drawCard();
        p.drawCard();
        p.drawCard();
        p.drawCard();
        p.drawCard();
        p.drawCard();
        p.drawCard();
        p.drawCard();
        p.drawCard();


    }

    @Test
    public void drawCardOnEndTurn(){
        assertEquals(4,p.getHand().size());
        p.getHand().remove(0);
        p.getHand().remove(0);
        assertEquals(2, p.getHand().size());
        p.drawCardOnEndTurn();
        assertEquals(4,p.getHand().size());
        p.drawCardOnEndTurn();
        assertEquals(4,p.getHand().size());
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
        assertEquals(0, p.getMoveCounter()[1]);
        assertEquals(0, p.getMoveCounter()[2]);

    }

    @Test
    public void getMoveCounterColor(){
        p.setMoveCounter(1,"green");
        assertEquals("green", p.getMoveCounterColor());
        p.resetMoveCounter();
        p.setMoveCounter(1,"blue");
        assertEquals("blue", p.getMoveCounterColor());
        p.resetMoveCounter();
        p.setMoveCounter(1, "yellow");
        assertEquals("yellow", p.getMoveCounterColor());
        p.resetMoveCounter();
    }

    @Test
    public void setBoughtCardId(){
        p.setBoughtCardId(14);
        assertEquals(14,p.getBoughtCardId());
    }


    @Test
    public void resetCoins() {
        p.setup();
        p.resetCoins();
        assertEquals(0, p.getCoins(),0);
    }


 /*   @Test
    public void setPlayerLeft() {
        p.setPlayerLeft(true);
        assertTrue(p.getPlayerLeft());
    }*/

    @Test
    public void setIsInGoal() {
        p.setIsInGoal(true);
        assertTrue(p.getIsInGoal());
    }

    @Test
    public void setWinner(){
        p.setWinner();
        assertTrue(p.getWinner());

    }

    @Test
    public void setColor() {
        p.setColor("green");
        assertEquals("green", p.getColor());
    }

    @Test
    public void setupCards(){
        assertEquals(4,p.getHand().size());
        assertEquals(0, p.getPlayedList().size());
        assertEquals(4,p.getDeck().size());
        assertEquals(0, p.getDiscardPile().size());
    }

    @Test
    public void setup() {
        p.setColor("green");
        p.setup();
        assertEquals("green", p.getPlayingPiece().getColor());
        assertEquals(4,p.getHand().size());
        assertEquals(0, p.getPlayedList().size());
        assertEquals(4,p.getDeck().size());
        assertEquals(0, p.getDiscardPile().size());
    }

    @Test
    public void setupTest(){
        p.setColor("green");
        p.setup();
        assertEquals("green", p.getPlayingPiece().getColor());
        assertEquals(4,p.getHand().size());
        assertEquals(0, p.getPlayedList().size());
        assertEquals(0, p.getDiscardPile().size());

    }

    @Test
    public void setupFastForward(){
        p.setupFastForward("HillsOfGold");

    }
}
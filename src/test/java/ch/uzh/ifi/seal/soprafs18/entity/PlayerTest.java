package ch.uzh.ifi.seal.soprafs18.entity;

import ch.uzh.ifi.seal.soprafs18.entity.card.Card;
import ch.uzh.ifi.seal.soprafs18.entity.card.ExpeditionCard;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PlayerTest {

    Player p = new Player();
    Card c = new ExpeditionCard(1f,1f,"CardName", "Description", "green", 1, true);
    ArrayList<Card> testPile;

    @Test
    public void getId() {
        p.setGameId((long) 1);
        assertEquals(java.util.Optional.of(1),p.getId());
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

    @Test
    public void getDeck() {
        p.deck.add(c);
        testPile.add(c);
        assertEquals(testPile,p.getDeck());
    }

    @Test
    public void getHand() {
        p.hand.add(c);
        testPile.add(c);
        assertEquals(testPile, p.getHand());
    }

    @Test
    public void getMoveCounter() {

    }

    @Test
    public void getPlayerLeft() {
        assertEquals(false, p.getPlayerLeft());
    }

    @Test
    public void getIsInGoal() {
        assertEquals(false, p.getIsInGoal());
    }

    @Test
    public void getDiscardPile() {
        testPile.add(c);
        p.addCardToDiscardPile(c);
        assertEquals(testPile,p.getDiscardPile());
    }

    @Test
    public void getPlayedList() {
        testPile.add(c);
        p.addCardToPlayingList(c);
        assertEquals(testPile, p.getPlayedList());
    }

    @Test
    public void getGameId() {
        p.setGameId((long) 1);
        assertEquals(java.util.Optional.of(1), p.getGameId());
    }

    @Test
    public void getPlayingPiece() {
        p.setColor("green");
        p.setup();
        assertEquals("green",p.getPlayingPiece().getColor());
    }

    @Test
    public void playCard() {
    }

    @Test
    public void move() {
    }

    @Test
    public void buyCard() {
    }

    @Test
    public void sellCard() {
        p.setup();
        p.getHand().add(c);
        p.sellCard(c);
        assertEquals(c.getGoldValue(),p.getCoins(),0f);
    }

    @Test
    public void drawCard() {
        p.setup();
        int testInt = p.getHand().size();
        p.drawCard();
        int testInt2 = p.getHand().size();
        assertEquals(testInt+1, testInt2);
    }

    @Test
    public void addCardToDeck() {
        p.setup();
        int testInt = p.getDeck().size();
        p.addCardToDeck(c);
        assertEquals(testInt, p.getDeck().size()-1);
    }

    @Test
    public void addCardToDiscardPile() {
        p.setup();
        int testInt = p.getDiscardPile().size();
        p.addCardToDiscardPile(c);
        assertEquals(testInt, p.getDiscardPile().size()-1);
    }

    @Test
    public void addCardToPlayingList() {
        p.setup();
        int testInt = p.getPlayedList().size();
        p.addCardToPlayingList(c);
        assertEquals(testInt, p.getPlayedList().size()-1);
    }

    @Test
    public void removeCardFromHand() {
        p.setup();
        p.getHand().add(c);
        int testInt = p.getHand().size();
        p.removeCardFromHand(c);
        assertEquals(testInt-1,p.getHand().size());
    }

    @Test
    public void removeCardFromDiscardPile() {
        p.setup();
        p.getDiscardPile().add(c);
        int testInt = p.getDiscardPile().size();
        p.removeCardFromDiscardPile(c);
        assertEquals(testInt-1,p.getDiscardPile().size());
    }

    @Test
    public void removeCardFromDeck() {
        p.setup();
        p.getDeck().add(c);
        int testInt = p.getDeck().size();
        p.removeCardFromDeck(c);
        assertEquals(testInt-1,p.getDeck().size());
    }

    @Test
    public void resetPlayedList() {
        p.setup();
        p.getPlayedList().add(c);
        p.resetPlayedList();
        assertEquals(0, p.getPlayedList().size());
    }

    @Test
    public void setMoveCounter() {

    }

    @Test
    public void resetMoveCounter() {
    }

    @Test
    public void setCoins() {
    }

    @Test
    public void resetCoins() {
    }

    @Test
    public void setPlayerLeft() {
    }

    @Test
    public void setIsInGoal() {
    }

    @Test
    public void setColor() {
    }

    @Test
    public void setup() {
    }
}
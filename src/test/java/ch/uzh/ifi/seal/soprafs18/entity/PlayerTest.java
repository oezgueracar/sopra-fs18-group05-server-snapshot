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
    }

    @Test
    public void drawCard() {
    }

    @Test
    public void addCardToDeck() {
    }

    @Test
    public void addCardToDiscardPile() {
    }

    @Test
    public void addCardToPlayingList() {
    }

    @Test
    public void removeCardFromHand() {
    }

    @Test
    public void removeCardFromDiscardPile() {
    }

    @Test
    public void removeCardFromDeck() {
    }

    @Test
    public void resetPlayedList() {
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
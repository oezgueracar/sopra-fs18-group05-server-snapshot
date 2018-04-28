package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class TravelLogTest {

    @Test
    public void play() {
        Player p = new Player();
        Card c = new TravelLog();
        p.setup();
        p.getHand().add(c);
        int i = p.getHand().size();
        c.play(p);
        int newI =p.getHand().size();
        assertEquals(i+1,newI);
    }
}
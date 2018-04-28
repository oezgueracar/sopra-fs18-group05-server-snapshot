package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompassTest {

    @Test
    public void play() {
        Player p = new Player();
        Card c = new Compass();
        p.setup();
        int i = p.getHand().size();
        c.play(p);
        int newI =p.getHand().size();
        assertEquals(i+3,newI);
    }
}
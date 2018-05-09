package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class CartographerTest {

    @Test
    public void play() {
        Player p = new Player();
        Card c = new Cartographer();
        p.setup();
        p.getHand().add(c);
        int i = p.getHand().size();
        int j = p.getPlayedList().size();
        c.play(p);

        assertEquals(i+1,p.getHand().size());
        assertEquals(j+1, p.getPlayedList().size());
    }
}
package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class CartographerTest {

    @Test
    public void play() {
        Player p = new Player();
        Card c = new Cartographer(4,0.5f,"Cartographer","Description");
        p.setup();
        int i = p.getHand().size();
        c.play(p);
        int newI =p.getHand().size();
        assertEquals(i+2,newI);
    }
}
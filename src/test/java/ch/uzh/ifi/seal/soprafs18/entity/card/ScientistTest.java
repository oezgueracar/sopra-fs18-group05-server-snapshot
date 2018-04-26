package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScientistTest {

    @Test
    public void play() {
        Player p = new Player();
        Card c = new Scientist(2,0.5f,"Scientist","Description");
        p.setup();
        p.getHand().add(c);
        int i = p.getHand().size();
        c.play(p);
        int newI =p.getHand().size();
        assertEquals(i,newI);
    }
}
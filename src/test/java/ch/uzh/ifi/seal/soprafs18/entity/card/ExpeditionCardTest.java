package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExpeditionCardTest {

    @Test
    public void play() {
        Player p = new Player();
        ExpeditionCard c = new ExpeditionCard(2,0.5f,"Cartographer", "green", 1, false);
        p.setup();
        int[] testVar = p.getMoveCounter();
        c.play(p);
        testVar[0] = testVar[0]+c.getValue();
        assertEquals(testVar,p.getMoveCounter());
    }

    @Test
    public void play2() {
        Player p = new Player();
        ExpeditionCard c = new ExpeditionCard(2,0.5f,"Cartographer", "green", 1, false);
        p.setup();
        p.getHand().add(c);
        int i = p.getHand().size();
        c.play(p);
        int newI =p.getHand().size();
        assertEquals(i-1,newI);
    }

    @Test
    public void getValue() {
        ExpeditionCard c = new ExpeditionCard(2,0.5f,"Cartographer", "green", 1, false);
        assertEquals(1, c.getValue());
    }

    @Test
    public void getColor() {
        ExpeditionCard c = new ExpeditionCard(2,0.5f,"Cartographer", "green", 1, false);
        assertEquals("green", c.getColor());
    }

    @Test
    public void isItemCard() {
        ExpeditionCard c = new ExpeditionCard(2,0.5f,"Cartographer", "green", 1, false);
        assertFalse(c.isItemCard());
    }
}
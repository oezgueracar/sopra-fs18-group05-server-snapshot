package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExpeditionCardTest {

    Player p;
    ExpeditionCard c;

    @Before
    public void setUp(){
        p = new Player();
        c = new ExpeditionCard(2,0.5f,"Cartographer", "green", 1, false);
        p.setup();

    }

    @Test
    public void play() {
        int[] testVar = p.getMoveCounter();
        c.play(p);
        testVar[0] = testVar[0]+c.getValue();
        assertEquals(testVar,p.getMoveCounter());
    }

    @Test
    public void play2() {
        p.getHand().add(c);
        c.play(p);
        int newI =p.getHand().size();
        assertEquals(0,newI);
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
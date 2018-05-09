package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExpeditionCardTest {

    Player p;
    ExpeditionCard c;
    ExpeditionCard d;

    @Before
    public void setUp(){
        p = new Player();
        c = new ExpeditionCard(2,0.5f,"Cartographer", "green", 1, false);
        d = new ExpeditionCard(2,0.5f,"Cartographer", "yellow", 2, true);
    }
    @Test
    public void play() {

        p.setup();
        p.getHand().add(c);
        int[] testVar = p.getMoveCounter();
        int i = p.getHand().size();
        int j = p.getPlayedList().size();
        c.play(p);
        testVar[0] = testVar[0] + c.getValue();
        assertEquals(testVar,p.getMoveCounter());
        assertEquals(1, p.getPlayedList().size());
        assertEquals(i-1, p.getHand().size());
        assertEquals(j+1, p.getPlayedList().size());

    }

    @Test
    public void play2() {
        p.setup();
        p.getHand().add(d);
        int i = p.getHand().size();
        int j = p.getPlayedList().size();
        d.play(p);
        assertEquals(i-1,p.getHand().size());
        assertEquals(j, p.getPlayedList().size());
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
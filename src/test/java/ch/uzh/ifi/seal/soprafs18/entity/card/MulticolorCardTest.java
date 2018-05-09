package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MulticolorCardTest {

    Player p;
    MulticolorCard c;
    MulticolorCard d;

    @Before
    public void setUp(){
        p = new Player();
        c = new MulticolorCard(2,0.5f,"Cartographer","multicolor",  1, false);
        d = new MulticolorCard(2,0.5f,"Cartographer","multicolor",  1, true);
        d.setChosenColor("green");
        c.setChosenColor("yellow");
    }

    @Test
    public void play() {
        p.setup();
        p.getHand().add(c);
        int i = p.getHand().size();
        int j = p.getPlayedList().size();
        c.play(p);
        assertEquals(i-1,p.getHand().size());
        assertEquals(j+1, p.getPlayedList().size());
    }

    @Test
    public void play2(){
        p.setup();
        p.getHand().add(d);
        int i = p.getHand().size();
        int j = p.getPlayedList().size();
        d.play(p);
        assertEquals(j, p.getPlayedList().size());
        assertEquals(i-1, p.getHand().size());
    }

    @Test
    public void setChosenColor() {
        MulticolorCard c = new MulticolorCard(2,0.5f,"Cartographer", "multicolor", 1, false);
        c.setChosenColor("green");
        assertEquals("green",c.getChosenColor());
    }

    @Test
    public void getChosenColor() {
        MulticolorCard c = new MulticolorCard(2,0.5f,"Cartographer", "multicolor", 1, false);
        c.setChosenColor("green");
        assertEquals("green", c.getChosenColor());
    }
}
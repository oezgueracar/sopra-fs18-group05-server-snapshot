package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class MulticolorCardTest {

    /*@Test
    public void play() {
        Player p = new Player();
        MulticolorCard c = new MulticolorCard(2,0.5f,"Cartographer","Description", "multicolor", 1, false);
        p.setup();
        p.getHand().add(c);
        int i = p.getHand().size();
        c.play(p);
        int newI =p.getHand().size();
        assertEquals(i-1,newI);
    }*/

    @Test
    public void play2(){

    }

    @Test
    public void setChosenColor() {
        MulticolorCard c = new MulticolorCard(2,0.5f,"Cartographer","Description", "multicolor", 1, false);
        c.setChosenColor("green");
        assertEquals("green",c.getChosenColor());
    }

    @Test
    public void getChosenColor() {
        MulticolorCard c = new MulticolorCard(2,0.5f,"Cartographer","Description", "multicolor", 1, false);
        c.setChosenColor("green");
        assertEquals("green", c.getChosenColor());
    }
}
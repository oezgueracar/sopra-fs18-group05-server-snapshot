package ch.uzh.ifi.seal.soprafs18.entity.map;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceTest {

    Space s;

    @Before
    public void setUp(){
        s = new Space("green",1,1,false, false);

    }

    @Test
    public void getFirstOnNewTile() {
        assertFalse(s.isFirstOnNewTile());
    }

    @Test
    public void getLastSpace() {
        assertFalse(s.isLastSpace());
    }

    @Test
    public void switchOccupied() {
        s.switchOccupied();
        assertTrue(s.getOccupied());
    }

    @Test
    public void getColor() {
        assertEquals("green", s.getColor());
    }

    @Test
    public void getValue() {
        assertEquals(1, s.getValue());
    }

    @Test
    public void getOccupied() {
        assertFalse(s.getOccupied());
    }

    @Test
    public void removeBlockadeStatus(){
        Space s1 = new Space("green",1,1,true, false);
        Space s2 = new Space("green",1,1,false, true);

        s1.removeBlockadeStatus();
        s2.removeBlockadeStatus();
        assertFalse(s1.isFirstOnNewTile());
        assertFalse(s2.isLastSpace());
    }

    @Test
    public void equals(){
        Space s1 = new Space("green",1,1,false, false);
        Space s2 = new Space("red",2,2,true, false);

        assertFalse(s.equals(s2));
        assertTrue(s.equals(s1));
    }
}
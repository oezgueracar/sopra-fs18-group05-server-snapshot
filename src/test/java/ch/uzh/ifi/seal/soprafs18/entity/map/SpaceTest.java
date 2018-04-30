package ch.uzh.ifi.seal.soprafs18.entity.map;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceTest {



    @Test
    public void getFirstOnNewTile() {
        Space s = new Space("green",1,1,false, false);
        assertFalse(s.getOccupied());
    }

    @Test
    public void switchOccupied() {
        Space s = new Space("green",1,1,false, false);
        s.switchOccupied();
        assertTrue(s.getOccupied());
    }

    @Test
    public void getColor() {
        Space s = new Space("green",1,1,false, false);
        assertEquals("green", s.getColor());
    }

    @Test
    public void getValue() {
        Space s = new Space("green",1,1,false, false);
        assertEquals(1, s.getValue());
    }

    @Test
    public void getOccupied() {
        Space s = new Space("green",1,1,false, false);
        assertFalse(s.getOccupied());
    }
}
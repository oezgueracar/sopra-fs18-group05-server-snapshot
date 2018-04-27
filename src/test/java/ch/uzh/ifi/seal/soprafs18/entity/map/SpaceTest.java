package ch.uzh.ifi.seal.soprafs18.entity.map;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceTest {

    Space s = new Space("green",1,1,false);

    /*@Test
    public void getBlockade() {
        assertFalse(s.getOccupied());
    }*/

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
}
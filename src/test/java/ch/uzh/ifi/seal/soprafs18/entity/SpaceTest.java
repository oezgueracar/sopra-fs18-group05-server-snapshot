package ch.uzh.ifi.seal.soprafs18.entity;

import ch.uzh.ifi.seal.soprafs18.entity.map.Space;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceTest {

    Space s1 = new Space(1, "green", 1, false);
    Space s2 = new Space(2, "green", 1, false);
    Space s3 = new Space(3, "green", 1, false);
    Space s4 = new Space(4, "green", 1, false);
    Space s5 = new Space(5, "green", 1, false);
    Space s6 = new Space(6, "green", 1, false);
    Space s7 = new Space(7, "green", 1, false);

    @Test
    public void switchOccupied() {
        s1.switchOccupied();
        assertEquals(true, s1.getOccupied());
    }

    @Test
    public void switchBlockade() {
        s1.switchBlockade();
        assertEquals(true, s1.getBlockade());
    }

    @Test
    public void setNeighbours() {
        Space[] spaces = {s2, s3, s4, s5, s6, s7};
        s1.setNeighbours(s2, s3, s4, s5, s6, s7);
        assertArrayEquals(spaces, s1.getNeighbours());
    }

    @Test
    public void getSpaceID() {
        assertEquals(1, s1.getSpaceID());
    }

    @Test
    public void getNeighbours() {
        Space[] spaces = {s2, s3, s4, s5, s6, s7};
        s1.setNeighbours(s2, s3, s4, s5, s6, s7);
        assertArrayEquals(spaces, s1.getNeighbours());
    }

    @Test
    public void getColor() {
        assertEquals("green", s1.getColor());
    }

    @Test
    public void getValue() {
        assertTrue(s1.getValue() == 1);
    }

    @Test
    public void getOccupied() {
        assertTrue(s1.getOccupied() == false);
    }

    @Test
    public void getBlockade() {
        assertTrue(s1.getBlockade() == false);
    }
}
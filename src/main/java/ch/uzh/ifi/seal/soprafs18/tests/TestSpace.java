package ch.uzh.ifi.seal.soprafs18.tests;

import ch.uzh.ifi.seal.soprafs18.entity.Space;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSpace {

    Space s1 = new Space(1, "green", 1, false);
    Space s2 = new Space(2, "green", 1, false);
    Space s3 = new Space(3, "green", 1, false);
    Space s4 = new Space(4, "green", 1, false);
    Space s5 = new Space(5, "green", 1, false);
    Space s6 = new Space(6, "green", 1, false);
    Space s7 = new Space(7, "green", 1, false);

//    Space[] spaces = {s2, s3, s4, s5, s6, s7};


    @Test
    void switchOccupied() {
        s1.switchOccupied();
        assertEquals(true, s1.getOccupied());
    }

    @Test
    void setNeighbours() {
        Space[] spaces = {s2, s3, s4, s5, s6, s7};
        s1.setNeighbours(s2, s3, s4, s5, s6, s7);
        assertArrayEquals(spaces, s1.getNeighbours());

    }

    @Test
    void getSpaceID() {
        assertEquals(1, s1.getSpaceID());
    }

    @Test
    void getNeighbours() {
        Space[] spaces = {s2, s3, s4, s5, s6, s7};
        s1.setNeighbours(s2, s3, s4, s5, s6, s7);
        assertArrayEquals(spaces, s1.getNeighbours());
    }

    @Test
    void getColor() {
        assertEquals("green", s1.getColor());
    }

    @Test
    void getValue() {
        assertTrue(s1.getValue() == 1);
    }

    @Test
    void getOccupied() {
        assertTrue(s1.getOccupied() == false);
    }
}

package ch.uzh.ifi.seal.soprafs18.entity;

import ch.uzh.ifi.seal.soprafs18.entity.map.Blockade;
import ch.uzh.ifi.seal.soprafs18.entity.map.Space;
import org.junit.Test;
import static org.junit.Assert.*;

public class BlockadeTest {

    Space s1 = new Space(1, "green", 1, true);
    Space s2 = new Space(2, "green", 1, true);
    Space s3 = new Space(3, "green", 1, true);
    Space s4 = new Space(4, "green", 1, true);

    Blockade b1 = new Blockade(s1, s2, s3, s4, "green", 1);

    @Test
    public void getBlockadeLocation() {
        Space[] blockade = {s1, s2, s3, s4};
        assertArrayEquals(blockade, b1.getBlockadeLocation());
    }

    @Test
    public void getColor() {
        assertEquals("green", b1.getColor());
    }

    @Test
    public void getValue() {
        assertTrue(b1.getValue() == 1);
    }

    @Test
    public void removeBlockade() {
        b1.removeBlockade();

        assertTrue(b1.getBlockadeLocation()[0].getBlockade() == false);
        assertTrue(b1.getBlockadeLocation()[1].getBlockade() == false);
        assertTrue(b1.getBlockadeLocation()[2].getBlockade() == false);
        assertTrue(b1.getBlockadeLocation()[3].getBlockade() == false);


    }
}
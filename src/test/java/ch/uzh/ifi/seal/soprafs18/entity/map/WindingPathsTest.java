package ch.uzh.ifi.seal.soprafs18.entity.map;

import org.junit.Test;

import static org.junit.Assert.*;

public class WindingPathsTest {

    @Test
    public void getEndTile() {
        WindingPaths m = new WindingPaths();
        assertEquals(3, m.getEndTile().length);
    }

    @Test
    public void getStartingSpaces() {
        WindingPaths m = new WindingPaths();
        assertEquals(4, m.getStartingSpaces().length);
    }
}
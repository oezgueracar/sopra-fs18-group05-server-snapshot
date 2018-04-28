package ch.uzh.ifi.seal.soprafs18.entity.map;

import org.junit.Test;

import static org.junit.Assert.*;

public class SerpentineTest {

    @Test
    public void getEndTile() {
        Serpentine m = new Serpentine();
        assertEquals(3,m.getEndTile().length);
    }

    @Test
    public void getStartingSpaces() {
        Serpentine m = new Serpentine();
        assertEquals(4, m.getStartingSpaces().length);
    }
}
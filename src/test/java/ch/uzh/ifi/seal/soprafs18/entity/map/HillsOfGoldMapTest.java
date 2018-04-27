package ch.uzh.ifi.seal.soprafs18.entity.map;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HillsOfGoldMapTest {


    @Test
    public void getEndTile() {
        HillsOfGoldMap m = new HillsOfGoldMap();
        assertEquals(3, m.getEndTile().length);
    }

    @Test
    public void getStartingSpaces() {
    }
}
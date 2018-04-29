package ch.uzh.ifi.seal.soprafs18.entity.map;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HillsOfGoldMapTest {

    @Test
    public void HillsOfGoldMap(){

    }
    @Test
    public void getEndTile() {
        HillsOfGoldMap m = new HillsOfGoldMap();
        assertEquals(3, m.getEndTile().length);
    }

    @Test
    public void getStartingSpaces() {
        HillsOfGoldMap m = new HillsOfGoldMap();
        assertEquals(4, m.getStartingSpaces().length);
    }

 /*   @Test
    public void setup() {
        HillsOfGoldMap m = new HillsOfGoldMap();
        assertEquals(12, m.getMapTiles().size());
    }*/
}
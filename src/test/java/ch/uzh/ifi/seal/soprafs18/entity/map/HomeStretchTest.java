package ch.uzh.ifi.seal.soprafs18.entity.map;

import org.junit.Test;

import static org.junit.Assert.*;

public class HomeStretchTest {

 /*   @Test
    public void setup() {
        HomeStretch m = new HomeStretch();
        assertEquals(4,m.getStartingSpaces().length);
    }*/

    @Test
    public void getEndTile() {
        HomeStretch m = new HomeStretch();
        assertEquals(3, m.getEndTile().length);
    }

    @Test
    public void getStartingSpaces() {
        HomeStretch m = new HomeStretch();
        assertEquals(11, m.getMapTiles().size());
    }
}
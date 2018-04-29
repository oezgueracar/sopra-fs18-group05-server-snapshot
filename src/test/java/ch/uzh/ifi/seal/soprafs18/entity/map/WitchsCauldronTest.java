package ch.uzh.ifi.seal.soprafs18.entity.map;

import org.junit.Test;

import static org.junit.Assert.*;

public class WitchsCauldronTest {

    @Test
    public void getEndTile() {
        WitchsCauldron m =new WitchsCauldron();
        assertEquals(3, m.getEndTile().length);
    }

    @Test
    public void getStartingSpaces() {
        WitchsCauldron m = new WitchsCauldron();
        assertEquals(4,m.getStartingSpaces().length);
    }
}
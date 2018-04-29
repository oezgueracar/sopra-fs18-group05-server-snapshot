package ch.uzh.ifi.seal.soprafs18.entity.map;

import com.sun.xml.internal.bind.v2.runtime.SwaRefAdapterMarker;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwanplandsTest {

    @Test
    public void getEndTile() {
        Swanplands m = new Swanplands();
        assertEquals(3, m.getEndTile().length);
    }

    @Test
    public void getStartingSpaces() {
        Swanplands m = new Swanplands();
        assertEquals(4, m.getStartingSpaces().length);
    }
}
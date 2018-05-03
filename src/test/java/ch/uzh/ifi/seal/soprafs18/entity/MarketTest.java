package ch.uzh.ifi.seal.soprafs18.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MarketTest {

    Market m;

    @Before
    public void setUp(){
        m = new Market();
    }

    @Test
    public void getOpenSlots() {
        assertEquals(6,m.getOpenSlots().size());
    }

    @Test
    public void getClosedSlots() {
        assertEquals(12, m.getClosedSlots().size());
    }

    @Test
    public void removeCard() {
        assertEquals(3, m.getOpenSlots().get(0).length);
        m.removeCard(m.getOpenSlots().get(0)[0].getId());
        assertEquals(2,m.getOpenSlots().get(0).length);

        assertEquals(2, m.getOpenSlots().get(0).length);
        m.removeCard(m.getOpenSlots().get(0)[0].getId());
        assertEquals(1,m.getOpenSlots().get(0).length);

        assertEquals(1, m.getOpenSlots().get(0).length);
        m.removeCard(m.getOpenSlots().get(0)[0].getId());
        assertNull(m.getOpenSlots().get(0));

        assertEquals(3, m.getClosedSlots().get(0).length);
        m.removeCard(m.getClosedSlots().get(0)[0].getId());
        assertNull(m.getClosedSlots().get(0));
        assertEquals(2,m.getOpenSlots().get(0).length);
    }

    @Test
    public void setup(){
        for(int i = 0; i<m.getClosedSlots().size(); i++){
           assertEquals(3, m.getClosedSlots().get(i).length);
        }
        for(int i = 0; i<m.getOpenSlots().size(); i++){
            assertEquals(3, m.getOpenSlots().get(i).length);
        }

    }
}
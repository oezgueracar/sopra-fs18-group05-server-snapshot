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

        for(int i=0; i<m.getOpenSlots().size();i++){
            for(int j=0; j<3;j++){
                assertEquals(3-j,m.getOpenSlots().get(i).length);
                m.removeCard(m.getOpenSlots().get(i)[j].getId());
                assertEquals(2-j,m.getOpenSlots().get(i).length);
                System.out.println(i+"+"+j);
            }
        }
        for(int i=0; i<m.getClosedSlots().size();i++){
            for(int j=0; j<m.getClosedSlots().get(i).length;j++){
                System.out.println("a"+i+"+"+j);
                assertEquals(3-j,m.getClosedSlots().get(i).length);
                System.out.println("b"+i+"+"+j);
                m.removeCard(m.getClosedSlots().get(i)[j].getId());
                System.out.println("c"+i+"+"+j);
                assertEquals(2-j,m.getClosedSlots().get(i).length);
                System.out.println("d"+i+"+"+j);

            }
        }
        /*assertEquals(3, m.getOpenSlots().get(0).length);
        m.removeCard(m.getOpenSlots().get(0)[0].getId());
        assertEquals(2,m.getOpenSlots().get(0).length);

        m.removeCard(m.getOpenSlots().get(0)[0].getId());
        assertEquals(1,m.getOpenSlots().get(0).length);

        m.removeCard(m.getOpenSlots().get(0)[0].getId());
        assertNull(m.getOpenSlots().get(0));

        assertEquals(3, m.getClosedSlots().get(1).length);
        m.removeCard(m.getClosedSlots().get(1)[0].getId());
        assertNull(m.getClosedSlots().get(1));
        assertEquals(2,m.getOpenSlots().get(1).length);*/
    }

    @Test
    public void removeTransmitter(){
        assertEquals(3, m.getOpenSlots().get(1).length);
        m.removeTransmitter(m.getOpenSlots().get(1)[0].getId());
        assertEquals(2,m.getOpenSlots().get(1).length);

        m.removeTransmitter(m.getOpenSlots().get(1)[0].getId());
        assertEquals(1,m.getOpenSlots().get(1).length);

        m.removeTransmitter(m.getOpenSlots().get(1)[0].getId());
        assertNull(m.getOpenSlots().get(1));

        assertEquals(3, m.getClosedSlots().get(0).length);
        m.removeTransmitter(m.getClosedSlots().get(0)[0].getId());
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
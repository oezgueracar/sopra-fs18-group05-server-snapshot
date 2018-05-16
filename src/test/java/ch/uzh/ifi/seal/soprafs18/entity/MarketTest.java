package ch.uzh.ifi.seal.soprafs18.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MarketTest {

    Market m;
    Market n;

    @Before
    public void setUp(){
        m = new Market();
        n = new Market();
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

            assertEquals(3,m.getOpenSlots().get(i).length);
            m.removeCard(m.getOpenSlots().get(i)[0].getId());
            assertEquals(2,m.getOpenSlots().get(i).length);
            System.out.println("Oarray+"+i+" has"+m.getOpenSlots().get(i).length);

            m.removeCard(m.getOpenSlots().get(i)[0].getId());
            assertEquals(1,m.getOpenSlots().get(i).length);
            System.out.println("Oarray+"+i+" has"+m.getOpenSlots().get(i).length);

            m.removeCard(m.getOpenSlots().get(i)[0].getId());
            System.out.println("Oarray+"+i+" has"+m.getOpenSlots().get(i));

        }
        for(int i=0; i<m.getClosedSlots().size();i++){
            System.out.println("Carray+"+i+" has"+m.getOpenSlots().get(0));
            assertEquals(3,m.getClosedSlots().get(i).length);
            m.removeCard(m.getClosedSlots().get(i)[0].getId());
            System.out.println("Oarray+"+i+" has"+m.getOpenSlots().get(0).length);
        }
    }

/*    @Test
    public void removeTransmitter() {
        for (int i = 0; i < n.getOpenSlots().size(); i++) {

            assertEquals(3, n.getOpenSlots().get(i).length);
            n.removeTransmitter(n.getOpenSlots().get(i)[0].getId());
            assertEquals(2, n.getOpenSlots().get(i).length);
            System.out.println("Oarray+" + i + " has" + n.getOpenSlots().get(i).length);

            n.removeTransmitter(n.getOpenSlots().get(i)[0].getId());
            assertEquals(1, n.getOpenSlots().get(i).length);
            System.out.println("Oarray+" + i + " has" + n.getOpenSlots().get(i).length);

            n.removeTransmitter(n.getOpenSlots().get(i)[0].getId());
            System.out.println("Oarray+" + i + " has" + n.getOpenSlots().get(i));

        }
        for(int i=0; i<n.getClosedSlots().size();i++){
            System.out.println(n.getClosedSlots().size());
            System.out.println("CArray+"+i+" has"+n.getClosedSlots().get(i).length);
            assertEquals(3,n.getClosedSlots().get(i).length);
            n.removeTransmitter(n.getClosedSlots().get(i)[0].getId());
            System.out.println("Carray+"+i+" has"+n.getClosedSlots().get(i).length);
            assertEquals(2,n.getClosedSlots().get(i).length);
            n.removeTransmitter(n.getClosedSlots().get(i)[0].getId());
            System.out.println("Carray+"+i+" has"+n.getClosedSlots().get(i).length);
            assertEquals(1,n.getClosedSlots().get(i).length);
            n.removeTransmitter(n.getClosedSlots().get(i)[0].getId());
            assertNull(n.getClosedSlots().get(i));
        }
    }*/

    @Test
    public void setup(){
        for(int i = 0; i<m.getClosedSlots().size(); i++){
           assertEquals(3, m.getClosedSlots().get(i).length);
        }
        for(int i = 0; i<m.getOpenSlots().size(); i++){
            assertEquals(3, m.getOpenSlots().get(i).length);
        }
    }

    @Test
    public void getCardById(){
        //System.out.println(m.getOpenSlots().get(5)[0].getId());
        assertEquals(m.getOpenSlots().get(5)[0].getId(), m.getCardByCardId(m.getOpenSlots().get(5)[0].getId()).getId());

       /* m.removeCard(16);
        m.removeCard(17);
        m.removeCard(18);

        System.out.println(m.getOpenSlots().get(5));

        System.out.println(m.getClosedSlots().get(0)[0].getId());*/

    }

    @Test
    public void getCardById2(){
        System.out.println(m.getCardByCardId(53));
        assertNull(m.getCardByCardId(52));
        assertNull(m.getCardByCardId(1234));
    }
}
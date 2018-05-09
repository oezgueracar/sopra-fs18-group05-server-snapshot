package ch.uzh.ifi.seal.soprafs18.entity.map;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlockadeTest {

    Blockade b1;

    @Before
    public void setUp() {
        b1 = new Blockade("green", 1, 1);
    }

    @Test
    public void getColor() {
        assertEquals("green",b1.getColor());
    }

    @Test
    public void getValue() {
    assertEquals(1,b1.getValue());
    }

    @Test
    public void getPowerValue(){
        assertEquals(1, b1.getPowerValue());
    }
}
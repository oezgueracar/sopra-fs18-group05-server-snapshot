package ch.uzh.ifi.seal.soprafs18.entity.map;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class EndTileTest {

    EndTile t1 = new EndTile();
    List<Space> testRow = new ArrayList<>();
    Space s1 = new Space("green",1,1,false);

    @Test
    public void addRow1() {
        int size1 = t1.getRow1().size();
        t1.addRow1(s1);
        int size2 = t1.getRow1().size();
        assertEquals(size1+1,size2);
    }

    @Test
    public void getRow1() {
        testRow.add(s1);
        t1.addRow1(s1);
        assertEquals(t1.getRow1(),testRow);
    }

    @Test
    public void setNextTilePos() {
        int testPos = 1;
        t1.setNextTilePos(1);
        assertEquals(testPos,t1.getNextTilePos());
    }

    @Test
    public void setRotation() {
        int testRotation=60;
        t1.setRotation(60);
        assertEquals(testRotation,t1.getRotation());
    }

    @Test
    public void getNextTilePos() {
        t1.setNextTilePos(1);
        assertEquals(1,t1.getNextTilePos());
    }

    @Test
    public void getRotation() {
        t1.setRotation(60);
        assertEquals(60,t1.getRotation());
    }
}
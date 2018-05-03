package ch.uzh.ifi.seal.soprafs18.entity.map;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwamplandsTest {
    Swamplands m;

    @Before
    public void setUO(){
        m = new Swamplands();
    }

    @Test
    public void getEndTile() {
        Swamplands m = new Swamplands();
        assertEquals(3, m.getEndTile().length);
    }

    @Test
    public void getStartingSpaces() {
        Swamplands m = new Swamplands();
        assertEquals(4, m.getStartingSpaces().length);
    }
    @Test
    public void setup() {
        //Testing rows of tiles
        for(int i=0;i<m.getMapTiles().size();i++){
            if(m.getMapTiles().get(i) instanceof Tile){
                assertEquals(4,m.getMapTiles().get(i).getRow1().size());
                assertEquals(5,m.getMapTiles().get(i).getRow2().size());
                assertEquals(6,m.getMapTiles().get(i).getRow3().size());
                assertEquals(7,m.getMapTiles().get(i).getRow4().size());
                assertEquals(6,m.getMapTiles().get(i).getRow5().size());
                assertEquals(5,m.getMapTiles().get(i).getRow6().size());
                assertEquals(4,m.getMapTiles().get(i).getRow7().size());
            }
            if(m.getMapTiles().get(i) instanceof TerrainStrip){
                assertEquals(5,m.getMapTiles().get(i).getRow1().size());
                assertEquals(6,m.getMapTiles().get(i).getRow2().size());
                assertEquals(5,m.getMapTiles().get(i).getRow3().size());
            }
            if(m.getMapTiles().get(i) instanceof EndTile){
                assertEquals(3, m.getMapTiles().get(i).getRow1().size());
            }
        }
    }
}
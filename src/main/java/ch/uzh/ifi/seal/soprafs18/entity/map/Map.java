package ch.uzh.ifi.seal.soprafs18.entity.map;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Map implements Serializable{

    protected List<MapElement> mapTiles = new ArrayList<MapElement>();

    protected List<Blockade> blockades = new ArrayList<Blockade>();
    protected Random random;

    protected Blockade getRandomBlockade(){
        random = new Random();
        int index = random.nextInt(blockades.size());
        Blockade blockade = blockades.get(index);
        blockades.remove(index);

        return blockade;
    }

    public List<MapElement> getMapTiles() {
        return mapTiles;
    }

    public List<Blockade> getBlockades() {
        return blockades;
    }

    public abstract long[] getEndTile();
}

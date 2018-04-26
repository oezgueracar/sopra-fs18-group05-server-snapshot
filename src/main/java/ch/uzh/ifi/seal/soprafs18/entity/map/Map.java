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

    public Space getSpace(long spaceId){
        for(int i = 0; i < mapTiles.size(); i++){
            if(!(mapTiles.get(i) instanceof Blockade)){
                if(mapTiles.get(i) instanceof Tile){
                    return ((Tile) mapTiles.get(i)).getSpace(spaceId);
                }
                if(mapTiles.get(i) instanceof TerrainStrip){
                    return ((TerrainStrip) mapTiles.get(i)).getSpace(spaceId));
                }
                if(mapTiles.get(i) instanceof EndTile){
                    return ((EndTile) mapTiles.get(i)).getSpace(spaceId);
                }
            }
        }
        return null;
    }
}

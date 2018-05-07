package ch.uzh.ifi.seal.soprafs18.entity.map;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Map{

    protected List<MapElement> mapTiles = new ArrayList<>();

    protected List<Blockade> blockades = new ArrayList<>();
    protected Random random;

    /**
     * Selects random a blockade instance in the list blockades.
     * @return a blockade instance
     */
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

    //Needed for Serializing.
    public List<Blockade> getBlockades() {
        return blockades;
    }

    public abstract long[] getEndTile();

    public abstract  long[] getStartingSpaces();

    /**
     * Gets the space instance matching the spaceId
     * @param spaceId the id of the space that is wanted
     * @return the space instance according to the spaceId
     */
    public Space getSpace(long spaceId){
        for(MapElement mapElement : mapTiles){
            if(!(mapElement instanceof Blockade)){
                if(mapElement instanceof Tile){
                    return ((Tile) mapElement).getSpace(spaceId);
                }
                if(mapElement instanceof TerrainStrip){
                    return ((TerrainStrip) mapElement).getSpace(spaceId);
                }
                if(mapElement instanceof EndTile){
                    return ((EndTile) mapElement).getSpace(spaceId);
                }
            }
        }
        return null;
    }
}

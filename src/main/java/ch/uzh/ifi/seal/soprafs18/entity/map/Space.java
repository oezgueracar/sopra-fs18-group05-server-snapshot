package ch.uzh.ifi.seal.soprafs18.entity.map;

import java.io.Serializable;

public class Space implements Serializable {

    private long id;
    private String color;
    private int value;
    private boolean isFirstOnNewTile;
    private boolean isLastSpace;
    private boolean occupied;
    private long[] neighbours;

    /**
     * Constructor
     *
     * @param col the color
     * @param spaceId the id
     * @param val the value
     * @param first If it's the first Space of a Tile.
     * @param last If it's the last Space of a Tile.
     */
    public Space(String col, long spaceId, int val, boolean first, boolean last){
        color = col;
        id = spaceId;
        value = val;
        isFirstOnNewTile = first;
        isLastSpace = last;
        occupied = false;
        neighbours = new long[6];
    }

    public void switchOccupied(){
        occupied = !occupied;
    }

    public void removeBlockadeStatus(){
        if(isFirstOnNewTile){
            isFirstOnNewTile = false;
        }
        else if (isLastSpace){
            isLastSpace = false;
        }
    }


    public long[] getNeighbours(){
        return neighbours;
    }

    public String getColor(){
        return color;
    }

    public int getValue(){
        return value;
    }

    public boolean getOccupied(){
        return occupied;
    }

    public boolean isFirstOnNewTile(){
        return isFirstOnNewTile;
    }

    public boolean isLastSpace() {
        return isLastSpace;
    }

    public long getId(){
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Space space = (Space) o;
        return this.id == space.getId();
    }

    @Override
    public int hashCode() {
        return Long.hashCode(this.id);
    }
}

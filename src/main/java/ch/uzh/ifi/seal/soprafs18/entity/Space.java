package ch.uzh.ifi.seal.soprafs18.entity;

import java.util.ArrayList;

public class Space {
    private long id;
    private Space[] neighbours = new Space[6];
    private String color;
    private int value;
    private Boolean blockade;
    private Boolean occupied;

    public Space(long ID, String col, int val, Boolean block){
        id=ID;
        color=col;
        value=val;
        blockade=block;
    }

    public void switchOccupied(){
        occupied = !occupied;
    }

    public void setNeighbours(Space n1, Space n2, Space n3, Space n4, Space n5, Space n6){
        Space[] neighbours = {n1, n2, n3, n4, n5, n6};
    }

    public long getSpaceID(){
        return id;
    }

    public Space[] getNeighbours(){
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

}

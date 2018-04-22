package ch.uzh.ifi.seal.soprafs18.entity.map;


import net.minidev.json.annotate.JsonIgnore;

import java.io.Serializable;

public class Space implements Serializable {
    private Space[] neighbours = new Space[6];
    private String color;
    private int value;
    private boolean blockade;
    private static boolean occupied = false;

    @JsonIgnore
    public Space(String col, int val, boolean block){
        color=col;
        value=val;
        blockade=block;
    }

    @JsonIgnore
    public void switchOccupied(){
        occupied = !occupied;
    }

    @JsonIgnore
    public void switchBlockade(){

        blockade = !blockade;
    }

    @JsonIgnore
    public void setNeighbours(Space n1, Space n2, Space n3, Space n4, Space n5, Space n6){
        neighbours[0] = n1;
        neighbours[1] = n2;
        neighbours[2] = n3;
        neighbours[3] = n4;
        neighbours[4] = n5;
        neighbours[5] = n6;
    }

    @JsonIgnore
    public Space[] getNeighbours(){
        return neighbours;
    }

    @JsonIgnore
    public String getColor(){
        return color;
    }

    @JsonIgnore
    public int getValue(){
        return value;
    }

    @JsonIgnore
    public boolean getOccupied(){
        return occupied;
    }

    @JsonIgnore
    public boolean getBlockade(){
        return blockade;
    }

}

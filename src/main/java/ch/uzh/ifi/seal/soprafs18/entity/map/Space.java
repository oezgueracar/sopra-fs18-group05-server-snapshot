package ch.uzh.ifi.seal.soprafs18.entity.map;

import java.io.Serializable;

public class Space implements Serializable {

    private long id;
    private String color;
    private int value;
    private boolean blockade;
    private static boolean occupied = false;
    private long[] neighbours;

    public Space(String col, long spaceId, int val, boolean block){
        color=col;
        id=spaceId;
        value=val;
        blockade=block;
        neighbours = new long[6];
    }

    public void switchOccupied(){
        occupied = !occupied;
    }

/*    public void setNeighbours(Space n1, Space n2, Space n3, Space n4, Space n5, Space n6){
        neighbours[0] = n1;
        neighbours[1] = n2;
        neighbours[2] = n3;
        neighbours[3] = n4;
        neighbours[4] = n5;
        neighbours[5] = n6;
    }*/

    public long[] getNeighbours(){
        return neighbours;
    }

/*    public void addNeighbour(Space s){
        for(int i= 0; i< neighbours.length;i++) {
            if (neighbours[i] == null)
                neighbours[i] = s;
        }
    }*/

    public String getColor(){
        return color;
    }

    public int getValue(){
        return value;
    }

    public boolean getOccupied(){
        return occupied;
    }

    public boolean getBlockade(){
        return blockade;
    }

    public long getId(){
        return id;
    }

}

package ch.uzh.ifi.seal.soprafs18.entity;


public class Space {
    private long id;
    private Space[] neighbours = new Space[6];
    private String color;
    private int value;
    private Boolean blockade;
    private static Boolean occupied = false;

    public Space(long ID, String col, int val, Boolean block){
        id=ID;
        color=col;
        value=val;
        blockade=block;
    }

    public static void switchOccupied(){
        occupied = !occupied;
    }

    public void setNeighbours(Space n1, Space n2, Space n3, Space n4, Space n5, Space n6){
        neighbours[0] = n1;
        neighbours[1] = n2;
        neighbours[2] = n3;
        neighbours[3] = n4;
        neighbours[4] = n5;
        neighbours[5] = n6;
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

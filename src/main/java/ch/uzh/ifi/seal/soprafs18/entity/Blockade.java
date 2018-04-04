package ch.uzh.ifi.seal.soprafs18.entity;

public class Blockade {

    private Space[] blockadeLocation = new Space[4];
    private String color;
    private int value;

    public Blockade(Space s1, Space s2, Space s3,  Space s4, String col, int val){
        blockadeLocation[0] = s1;
        blockadeLocation[1] = s2;
        blockadeLocation[2] = s3;
        blockadeLocation[3] = s4;
        color = col;
        value = val;
    }

    public Space[] getBlockadeLocation(){
        return blockadeLocation;
    }

    public String getColor(){
        return color;
    }

    public int getValue(){
        return value;
    }

    // This method changes the Boolean "blockade" of all Spaces which belong to a Blockade when the Blockade is removed
    public void removeBlockade(){
        for(int i = 0; i < blockadeLocation.length; i++){
            blockadeLocation[i].switchBlockade();
        }
    }
}

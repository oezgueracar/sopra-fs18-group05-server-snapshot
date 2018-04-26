package ch.uzh.ifi.seal.soprafs18.entity.map;

import java.util.List;

public class Blockade extends MapElement {

    private String color;
    private int value;

    public Blockade(String col, int val){
        color = col;
        value = val;
    }

    public String getColor(){return color;}
    public int getValue(){return value;}

    @Override
    public List<Space> getRow1() {
        return null;
    }
}

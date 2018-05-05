package ch.uzh.ifi.seal.soprafs18.entity.map;

import java.util.List;

public class Blockade extends MapElement {

    private String color;
    private int value;
    private int powerValue;
    private List<Space> row1;
    private List<Space> row2;
    private List<Space> row3;
    private List<Space> row4;
    private List<Space> row5;
    private List<Space> row6;
    private List<Space> row7;

    /**
     * Constructor
     * @param col the color of the blockade
     * @param val the value of the blockade
     */
    public Blockade(String col, int val, int powVal){
        color = col;
        value = val;
        powerValue = powVal;
    }

    // Getter
    public String getColor(){return color;}
    public int getValue(){return value;}
    public int getPowerValue(){
        return powerValue;
    }

    @Override
    public List<Space> getRow1(){return null;}
    @Override
    public List<Space> getRow2(){return null;}
    @Override
    public List<Space> getRow3(){return null;}
    @Override
    public List<Space> getRow4(){return null;}
    @Override
    public List<Space> getRow5(){return null;}
    @Override
    public List<Space> getRow6(){return null;}
    @Override
    public List<Space> getRow7(){return null;}

    @Override
    public boolean equals(Object o) {
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        Blockade blockade = (Blockade) o;
        // field comparison
        return (color.equals(blockade.getColor()) && value == blockade.getValue());
    }
}

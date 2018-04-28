package ch.uzh.ifi.seal.soprafs18.entity.map;

import java.util.List;

public class Blockade extends MapElement {

    private String color;
    private int value;
    private List<Space> row1;
    private List<Space> row2;
    private List<Space> row3;
    private List<Space> row4;
    private List<Space> row5;
    private List<Space> row6;
    private List<Space> row7;

    public Blockade(String col, int val){
        color = col;
        value = val;
    }

    //Getter
    public String getColor(){return color;}
    public int getValue(){return value;}

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

}

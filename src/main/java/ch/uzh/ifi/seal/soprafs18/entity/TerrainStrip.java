package ch.uzh.ifi.seal.soprafs18.entity;

import java.util.ArrayList;

public class TerrainStrip extends MapElement {
    ArrayList<Space> row1 = new ArrayList<Space>();
    ArrayList<Space> row2 = new ArrayList<Space>();
    ArrayList<Space> row3 = new ArrayList<Space>();

    public TerrainStrip(){
        ArrayList<Space> row1 = new ArrayList<Space>();
        ArrayList<Space> row2 = new ArrayList<Space>();
        ArrayList<Space> row3 = new ArrayList<Space>();
    }

    //Fill Rows
    public void addRow1(Space s){row1.add(s);}
    public void addRow2(Space s){row2.add(s);}
    public void addRow3(Space s){row3.add(s);}
    //Getter
    public ArrayList getRow1(){return row1;}
    public ArrayList getRow2(){return row2;}
    public ArrayList getRow3(){return row3;}
}

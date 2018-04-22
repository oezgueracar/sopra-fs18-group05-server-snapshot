package ch.uzh.ifi.seal.soprafs18.entity.map;

import java.util.ArrayList;

public class TerrainStrip extends MapElement {
    ArrayList<Space> row1;
    ArrayList<Space> row2;
    ArrayList<Space> row3;

    public TerrainStrip(){
        row1 = new ArrayList<>();
        row2 = new ArrayList<>();
        row3 = new ArrayList<>();
    }

    //Fill Rows
    @Override
    public void addRow1(Space s){row1.add(s);}
    @Override
    public void addRow2(Space s){row2.add(s);}
    @Override
    public void addRow3(Space s){row3.add(s);}
    //Getter
    public ArrayList getRow1(){return row1;}
    public ArrayList getRow2(){return row2;}
    public ArrayList getRow3(){return row3;}
}

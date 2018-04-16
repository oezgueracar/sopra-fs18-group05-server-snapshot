package ch.uzh.ifi.seal.soprafs18.entity;

import java.util.ArrayList;

public class Tile {

    private ArrayList<Space> row1 = new ArrayList<>();
    private ArrayList<Space> row2;
    private ArrayList<Space> row3;
    private ArrayList<Space> row4;
    private ArrayList<Space> row5;
    private ArrayList<Space> row6;
    private ArrayList<Space> row7;

    private int nextTilePos;
    private int rotation;

    //Fill Rows
    public void addRow1(Space s){row1.add(s);}
    public void addRow2(Space s){row2.add(s);}
    public void addRow3(Space s){row3.add(s);}
    public void addRow4(Space s){row4.add(s);}
    public void addRow5(Space s){row5.add(s);}
    public void addRow6(Space s){row6.add(s);}
    public void addRow7(Space s){row7.add(s);}
    //Getter
    public ArrayList getRow1(){return row1;}
    public ArrayList getRow2(){return row2;}
    public ArrayList getRow3(){return row3;}
    public ArrayList getRow4(){return row4;}
    public ArrayList getRow5(){return row5;}
    public ArrayList getRow6(){return row6;}
    public ArrayList getRow7(){return row7;}
    //Setter
    public void setNextTilePos(int p){
        this.nextTilePos = p;
    }
    public void setRotarion(int r){
        this.rotation = r;
    }



}

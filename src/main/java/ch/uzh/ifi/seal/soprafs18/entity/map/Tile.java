package ch.uzh.ifi.seal.soprafs18.entity.map;

import net.minidev.json.annotate.JsonIgnore;

import java.util.ArrayList;

public class Tile extends MapElement {

    private ArrayList<Space> row1;
    private ArrayList<Space> row2;
    private ArrayList<Space> row3;
    private ArrayList<Space> row4;
    private ArrayList<Space> row5;
    private ArrayList<Space> row6;
    private ArrayList<Space> row7;



    private int nextTilePos;
    private int rotation;

    @JsonIgnore
    public Tile(){
        row1 = new ArrayList<>();
        row2 = new ArrayList<>();
        row3 = new ArrayList<>();
        row4 = new ArrayList<>();
        row5 = new ArrayList<>();
        row6 = new ArrayList<>();
        row7 = new ArrayList<>();
    }

    //Fill Rows
    @Override
    @JsonIgnore
    public void addRow1(Space s){row1.add(s);}
    @Override
    @JsonIgnore
    public void addRow2(Space s){row2.add(s);}
    @Override
    @JsonIgnore
    public void addRow3(Space s){row3.add(s);}
    @Override
    @JsonIgnore
    public void addRow4(Space s){row4.add(s);}
    @Override
    @JsonIgnore
    public void addRow5(Space s){row5.add(s);}
    @Override
    @JsonIgnore
    public void addRow6(Space s){row6.add(s);}
    @Override
    @JsonIgnore
    public void addRow7(Space s){row7.add(s);}
    //Getter
    @JsonIgnore
    public ArrayList getRow1(){return row1;}
    @JsonIgnore
    public ArrayList getRow2(){return row2;}
    @JsonIgnore
    public ArrayList getRow3(){return row3;}
    @JsonIgnore
    public ArrayList getRow4(){return row4;}
    @JsonIgnore
    public ArrayList getRow5(){return row5;}
    @JsonIgnore
    public ArrayList getRow6(){return row6;}
    @JsonIgnore
    public ArrayList getRow7(){return row7;}
    //Setter
    @Override
    @JsonIgnore
    public void setNextTilePos(int p){
        this.nextTilePos = p;
    }
    @Override
    @JsonIgnore
    public void setRotation(int r){
        this.rotation = r;
    }


}

package ch.uzh.ifi.seal.soprafs18.entity;

import java.util.ArrayList;

public class EndTile extends MapElement {

    ArrayList<Space> row1 = new ArrayList<Space>();

    public EndTile(){
        ArrayList<Space> row1 = new ArrayList<Space>();
    }

    //Fill Rows
    @Override
    public void addRow1(Space s){row1.add(s);}
}

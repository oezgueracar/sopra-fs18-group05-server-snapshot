package ch.uzh.ifi.seal.soprafs18.entity.map;

import java.util.ArrayList;

public class EndTile extends MapElement {

    ArrayList<Space> row1;

    public EndTile(){
        row1 = new ArrayList<>();
    }

    //Fill Rows
    @Override
    public void addRow1(Space s){row1.add(s);}
}

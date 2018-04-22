package ch.uzh.ifi.seal.soprafs18.entity.map;

import net.minidev.json.annotate.JsonIgnore;

import java.util.ArrayList;

public class EndTile extends MapElement {

    ArrayList<Space> row1;

    @JsonIgnore
    public EndTile(){
        row1 = new ArrayList<>();
    }

    //Fill Rows
    @Override
    @JsonIgnore
    public void addRow1(Space s){row1.add(s);}
}

package ch.uzh.ifi.seal.soprafs18.entity.map;

import java.util.ArrayList;
import java.util.List;

public class EndTile extends MapElement {

    public List<Space> row1;

    public EndTile(){
        row1 = new ArrayList<>();
    }

    //Fill Rows
    @Override
    public void addRow1(Space s){row1.add(s);}

    //Getter
    public List<Space> getRow1() {
        return row1;
    }
    public int getNextTilePos(){return nextTilePos;}
    public int getRotation(){return rotation;}

    //Setter
    @Override
    public void setNextTilePos(int p){
        this.nextTilePos = p;
    }
    @Override
    public void setRotation(int r){
        this.rotation = r;
    }

}

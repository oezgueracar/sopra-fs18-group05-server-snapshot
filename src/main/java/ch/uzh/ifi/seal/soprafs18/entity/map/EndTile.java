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
    @Override
    public List<Space> getRow1() {
        return row1;
    }
    @Override
    public List<Space> getRow7(){return null;}
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

    public Space getSpace(long spaceId) {
        for (int j = 0; j < this.getRow1().size(); j++) {
            if (this.getRow1().get(j).getId() == spaceId) {
                return this.getRow1().get(j);
            }
        }
        return null;
    }

    @Override
    public void setNeighbours(){
        this.row1.get(0).getNeighbours()[0] = 0;
        this.row1.get(0).getNeighbours()[1] = this.row1.get(1).getId();
        this.row1.get(0).getNeighbours()[2] = 0;
        this.row1.get(0).getNeighbours()[3] = 0;
        this.row1.get(0).getNeighbours()[4] = 0;
        this.row1.get(0).getNeighbours()[5] = 0;

        this.row1.get(0).getNeighbours()[0] = 0;
        this.row1.get(0).getNeighbours()[1] = 0;
        this.row1.get(0).getNeighbours()[2] = this.row1.get(2).getId();
        this.row1.get(0).getNeighbours()[3] = 0;
        this.row1.get(0).getNeighbours()[4] = this.row1.get(0).getId();
        this.row1.get(0).getNeighbours()[5] = 0;

        this.row1.get(0).getNeighbours()[0] = 0;
        this.row1.get(0).getNeighbours()[1] = 0;
        this.row1.get(0).getNeighbours()[2] = 0;
        this.row1.get(0).getNeighbours()[3] = 0;
        this.row1.get(0).getNeighbours()[4] = this.row1.get(1).getId();
        this.row1.get(0).getNeighbours()[5] = 0;
    }

}

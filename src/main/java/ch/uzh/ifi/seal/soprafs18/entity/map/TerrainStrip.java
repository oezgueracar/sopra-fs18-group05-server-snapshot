package ch.uzh.ifi.seal.soprafs18.entity.map;

import java.util.ArrayList;
import java.util.List;

public class TerrainStrip extends MapElement {
    List<Space> row1;
    List<Space> row2;
    List<Space> row3;

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
    @Override
    public List<Space> getRow1(){return row1;}
    public List<Space> getRow2(){return row2;}
    public List<Space> getRow3(){return row3;}
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
        for (int j = 0; j < this.getRow2().size(); j++) {
            if (this.getRow2().get(j).getId() == spaceId) {
                return this.getRow2().get(j);
            }
        }
        for (int j = 0; j < this.getRow3().size(); j++) {
            if (this.getRow3().get(j).getId() == spaceId) {
                return this.getRow3().get(j);
            }
        }
        return null;
    }
}

package ch.uzh.ifi.seal.soprafs18.entity.map;

import java.util.ArrayList;
import java.util.List;

public class EndTile extends MapElement {

    public List<Space> row1;
    private List<Space> row2;
    private List<Space> row3;
    private List<Space> row4;
    private List<Space> row5;
    private List<Space> row6;
    private List<Space> row7;

    /**
     * Constructor
     */
    public EndTile(){
        row1 = new ArrayList<>();
    }

    //Fill Rows
    @Override
    public void addRow1(Space s){row1.add(s);}

    //Getter
    @Override
    public List<Space> getRow1(){return row1;}
    @Override
    public List<Space> getRow2(){return null;}
    @Override
    public List<Space> getRow3(){return null;}
    @Override
    public List<Space> getRow4(){return null;}
    @Override
    public List<Space> getRow5(){return null;}
    @Override
    public List<Space> getRow6(){return null;}
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
        //this.row1.get(0).getNeighbours()[0] = 0;
        this.row1.get(0).getNeighbours()[1] = this.row1.get(1).getId();
/*        this.row1.get(0).getNeighbours()[2] = 0;
        this.row1.get(0).getNeighbours()[3] = 0;
        this.row1.get(0).getNeighbours()[4] = 0;
        this.row1.get(0).getNeighbours()[5] = 0;*/

        /*this.row1.get(0).getNeighbours()[0] = 0;
        this.row1.get(0).getNeighbours()[1] = 0;*/
        this.row1.get(1).getNeighbours()[2] = this.row1.get(2).getId();
        //this.row1.get(0).getNeighbours()[3] = 0;
        this.row1.get(1).getNeighbours()[4] = this.row1.get(0).getId();
       /* this.row1.get(0).getNeighbours()[5] = 0;

        this.row1.get(0).getNeighbours()[0] = 0;
        this.row1.get(0).getNeighbours()[1] = 0;
        this.row1.get(0).getNeighbours()[2] = 0;
        this.row1.get(0).getNeighbours()[3] = 0;*/
        this.row1.get(2).getNeighbours()[4] = this.row1.get(1).getId();
        //this.row1.get(0).getNeighbours()[5] = 0;
    }

}

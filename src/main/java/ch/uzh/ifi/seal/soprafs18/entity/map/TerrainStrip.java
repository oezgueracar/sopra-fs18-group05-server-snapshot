package ch.uzh.ifi.seal.soprafs18.entity.map;

import java.util.ArrayList;
import java.util.List;

public class TerrainStrip extends MapElement {
    private List<Space> row1;
    private List<Space> row2;
    private List<Space> row3;
    private List<Space> row4;
    private List<Space> row5;
    private List<Space> row6;
    private List<Space> row7;

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
    @Override
    public List<Space> getRow2(){return row2;}
    @Override
    public List<Space> getRow3(){return row3;}
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

    @Override
    public void setNeighbours(){

        //Row1
        for(int i = 0; i<this.getRow1().size(); i++){
            this.row1.get(i).getNeighbours()[0] = 0;
            if(i == this.getRow1().size()-1)  {this.row1.get(i).getNeighbours()[1] = 0;}
            else                              {this.row1.get(i).getNeighbours()[1] = this.row1.get(i+1).getId();}
            this.row1.get(i).getNeighbours()[2] = this.row2.get(i+1).getId();
            this.row1.get(i).getNeighbours()[3] = this.row2.get(i).getId();
            if(i == 0)  {this.row1.get(i).getNeighbours()[4] = 0;}
            else        {this.row1.get(i).getNeighbours()[4] = this.row1.get(i-1).getId();}
            this.row1.get(i).getNeighbours()[5] = 0;
        }
        //Row2
        for(int i = 0; i<this.getRow2().size(); i++){
            if(i == getRow2().size()-1)    {this.row2.get(i).getNeighbours()[0] = 0;}
            else                         {this.row2.get(i).getNeighbours()[0] = this.row1.get(i).getId();}
            if(i == getRow2().size()-1)    {this.row2.get(i).getNeighbours()[1] = 0;}
            else                         {this.row2.get(i).getNeighbours()[1] = this.row2.get(i+1).getId();}
            if(i == getRow2().size()-1)    {this.row2.get(i).getNeighbours()[2] = 0;}
            else                         {this.row2.get(i).getNeighbours()[2] = this.row3.get(i).getId();}
            if(i == 0)                   {this.row2.get(i).getNeighbours()[3] = 0;}
            else                         {this.row2.get(i).getNeighbours()[3] = this.row3.get(i-1).getId();}
            if(i == 0)  {this.row2.get(i).getNeighbours()[4] = 0;}
            else        {this.row2.get(i).getNeighbours()[4] = this.row2.get(i-1).getId();}
            if(i == 0)  {this.row2.get(i).getNeighbours()[5] = 0;}
            else        {this.row2.get(i).getNeighbours()[5] = this.row1.get(i-1).getId();}
        }
        //Row7
        for(int i = 0; i<this.getRow3().size(); i++){
            this.row3.get(i).getNeighbours()[0] = this.row2.get(i+1).getId();
            if(i == this.getRow3().size()-1)  {this.row3.get(i).getNeighbours()[1] = 0;}
            else                            {this.row3.get(i).getNeighbours()[1] = this.row3.get(i+1).getId();}
            this.row3.get(i).getNeighbours()[2] = 0;
            this.row3.get(i).getNeighbours()[3] = 0;
            if(i == 0)  {this.row3.get(i).getNeighbours()[4] = 0;}
            else        {this.row3.get(i).getNeighbours()[4] = this.row3.get(i-1).getId();}
            this.row3.get(i).getNeighbours()[5] = this.row2.get(i).getId();
        }
    }
}

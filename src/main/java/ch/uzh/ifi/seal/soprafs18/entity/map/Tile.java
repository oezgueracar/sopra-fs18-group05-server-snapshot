package ch.uzh.ifi.seal.soprafs18.entity.map;

import java.util.ArrayList;
import java.util.List;

public class Tile extends MapElement {

    private List<Space> row1;
    private List<Space> row2;
    private List<Space> row3;
    private List<Space> row4;
    private List<Space> row5;
    private List<Space> row6;
    private List<Space> row7;

    /**
     * Constructor
     */
    public Tile(){
        row1 = new ArrayList<>();
        row2 = new ArrayList<>();
        row3 = new ArrayList<>();
        row4 = new ArrayList<>();
        row5 = new ArrayList<>();
        row6 = new ArrayList<>();
        row7 = new ArrayList<>();
    }

    @Override
    public void addRow1(Space s){row1.add(s);}
    @Override
    public void addRow2(Space s){row2.add(s);}
    @Override
    public void addRow3(Space s){row3.add(s);}
    @Override
    public void addRow4(Space s){row4.add(s);}
    @Override
    public void addRow5(Space s){row5.add(s);}
    @Override
    public void addRow6(Space s){row6.add(s);}
    @Override
    public void addRow7(Space s){row7.add(s);}

    @Override
    public List<Space> getRow1(){return row1;}
    @Override
    public List<Space> getRow2(){return row2;}
    @Override
    public List<Space> getRow3(){return row3;}
    @Override
    public List<Space> getRow4(){return row4;}
    @Override
    public List<Space> getRow5(){return row5;}
    @Override
    public List<Space> getRow6(){return row6;}
    @Override
    public List<Space> getRow7(){return row7;}

    public int getNextTilePos(){return nextTilePos;}
    public int getRotation(){return rotation;}

    @Override
    public void setNextTilePos(int p){
        this.nextTilePos = p;
    }
    @Override
    public void setRotation(int r){
        this.rotation = r;
    }

    protected Space getSpace(long spaceId){
        for(int j = 0;j < this.getRow1().size();j++){
            if(this.getRow1().get(j).getId() == spaceId){
                return this.getRow1().get(j);
            }
        }
        for(int j = 0;j < this.getRow2().size();j++){
            if(this.getRow2().get(j).getId() == spaceId){
                return this.getRow2().get(j);
            }
        }
        for(int j = 0;j < this.getRow3().size();j++){
            if(this.getRow3().get(j).getId() == spaceId){
                return this.getRow3().get(j);
            }
        }        for(int j = 0;j < this.getRow4().size();j++){
            if(this.getRow4().get(j).getId() == spaceId){
                return this.getRow4().get(j);
            }
        }        for(int j = 0;j < this.getRow5().size();j++){
            if(this.getRow5().get(j).getId() == spaceId){
                return this.getRow5().get(j);
            }
        }        for(int j = 0;j < this.getRow6().size();j++){
            if(this.getRow6().get(j).getId() == spaceId){
                return this.getRow6().get(j);
            }
        }        for(int j = 0;j < this.getRow7().size();j++){
            if(this.getRow7().get(j).getId() == spaceId){
                return this.getRow7().get(j);
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
            if(i == this.row2.size()-1)          {this.row2.get(i).getNeighbours()[0] = 0;}
            else                                 {this.row2.get(i).getNeighbours()[0] = this.row1.get(i).getId();}
            if(i == this.getRow2().size()-1)  {this.row2.get(i).getNeighbours()[1] = 0;}
            else                            {this.row2.get(i).getNeighbours()[1] = this.row2.get(i+1).getId();}
            this.row2.get(i).getNeighbours()[2] = this.row3.get(i+1).getId();
            this.row2.get(i).getNeighbours()[3] = this.row3.get(i).getId();
            if(i == 0)  {this.row2.get(i).getNeighbours()[4] = 0;}
            else        {this.row2.get(i).getNeighbours()[4] = this.row2.get(i-1).getId();}
            if(i == 0)  {this.row2.get(i).getNeighbours()[5] = 0;}
            else        {this.row2.get(i).getNeighbours()[5] = this.row1.get(i-1).getId();}
        }
        //Row3
        for(int i = 0; i<this.getRow3().size(); i++){
            if(i == this.row3.size()-1)          {this.row3.get(i).getNeighbours()[0] = 0;}
            else                                 {this.row3.get(i).getNeighbours()[0] = this.row2.get(i).getId();}
            if(i == this.getRow3().size()-1)  {this.row3.get(i).getNeighbours()[1] = 0;}
            else                            {this.row3.get(i).getNeighbours()[1] = this.row3.get(i+1).getId();}
            this.row3.get(i).getNeighbours()[2] = this.row4.get(i+1).getId();
            this.row3.get(i).getNeighbours()[3] = this.row4.get(i).getId();
            if(i == 0)  {this.row3.get(i).getNeighbours()[4] = 0;}
            else        {this.row3.get(i).getNeighbours()[4] = this.row3.get(i-1).getId();}
            if(i == 0)  {this.row3.get(i).getNeighbours()[5] = 0;}
            else        {this.row3.get(i).getNeighbours()[5] = this.row2.get(i-1).getId();}
        }
        //Row4
        for(int i = 0; i<this.getRow4().size(); i++){
            if(i == getRow4().size()-1)    {this.row4.get(i).getNeighbours()[0] = 0;}
            else                         {this.row4.get(i).getNeighbours()[0] = this.row3.get(i).getId();}
            if(i == getRow4().size()-1)    {this.row4.get(i).getNeighbours()[1] = 0;}
            else                         {this.row4.get(i).getNeighbours()[1] = this.row4.get(i+1).getId();}
            if(i == getRow4().size()-1)    {this.row4.get(i).getNeighbours()[2] = 0;}
            else                         {this.row4.get(i).getNeighbours()[2] = this.row5.get(i).getId();}
            if(i == 0)                   {this.row4.get(i).getNeighbours()[3] = 0;}
            else                         {this.row4.get(i).getNeighbours()[3] = this.row5.get(i-1).getId();}
            if(i == 0)  {this.row4.get(i).getNeighbours()[4] = 0;}
            else        {this.row4.get(i).getNeighbours()[4] = this.row4.get(i-1).getId();}
            if(i == 0)  {this.row4.get(i).getNeighbours()[5] = 0;}
            else        {this.row4.get(i).getNeighbours()[5] = this.row3.get(i-1).getId();}
        }
        //Row5
        for(int i = 0; i<this.getRow5().size(); i++){
            this.row5.get(i).getNeighbours()[0] = this.row4.get(i+1).getId();
            if(i == this.getRow5().size()-1)  {this.row5.get(i).getNeighbours()[1] = 0;}
            else                            {this.row5.get(i).getNeighbours()[1] = this.row5.get(i+1).getId();}
            if (i == this.row5.size()-1)    {this.row5.get(i).getNeighbours()[2] = 0;}
            else                            {this.row5.get(i).getNeighbours()[2] = this.row6.get(i).getId();}
            if(i == 0)  {this.row5.get(i).getNeighbours()[3] = 0;}
            else        {this.row5.get(i).getNeighbours()[3] = this.row6.get(i-1).getId();}
            if(i == 0)  {this.row5.get(i).getNeighbours()[4] = 0;}
            else        {this.row5.get(i).getNeighbours()[4] = this.row5.get(i-1).getId();}
            this.row5.get(i).getNeighbours()[5] = this.row4.get(i).getId();
        }
        //Row6
        for(int i = 0; i<this.getRow6().size(); i++){
            this.row6.get(i).getNeighbours()[0] = this.row5.get(i+1).getId();
            if(i == this.getRow6().size()-1)  {this.row6.get(i).getNeighbours()[1] = 0;}
            else                            {this.row6.get(i).getNeighbours()[1] = this.row6.get(i+1).getId();}
            if (i == this.row6.size()-1)    {this.row6.get(i).getNeighbours()[2] = 0;}
            else                            {this.row6.get(i).getNeighbours()[2] = this.row7.get(i).getId();}
            if(i == 0)  {this.row6.get(i).getNeighbours()[3] = 0;}
            else        {this.row6.get(i).getNeighbours()[3] = this.row7.get(i-1).getId();}
            if(i == 0)  {this.row6.get(i).getNeighbours()[4] = 0;}
            else        {this.row6.get(i).getNeighbours()[4] = this.row6.get(i-1).getId();}
            this.row6.get(i).getNeighbours()[5] = this.row5.get(i).getId();

        }
        //Row7
        for(int i = 0; i<this.getRow7().size(); i++){
            this.row7.get(i).getNeighbours()[0] = this.row6.get(i+1).getId();
            if(i == this.getRow7().size()-1)  {this.row7.get(i).getNeighbours()[1] = 0;}
            else                              {this.row7.get(i).getNeighbours()[1] = this.row7.get(i+1).getId();}
            this.row7.get(i).getNeighbours()[2] = 0;
            this.row7.get(i).getNeighbours()[3] = 0;
            if(i == 0)  {this.row7.get(i).getNeighbours()[4] = 0;}
            else        {this.row7.get(i).getNeighbours()[4] = this.row7.get(i-1).getId();}
            this.row7.get(i).getNeighbours()[5] = this.row6.get(i).getId();
        }
    }
}

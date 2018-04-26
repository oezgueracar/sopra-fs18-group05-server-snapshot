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
    //Getter
    public List<Space> getRow1(){return row1;}
    public List<Space> getRow2(){return row2;}
    public List<Space> getRow3(){return row3;}
    public List<Space> getRow4(){return row4;}
    public List<Space> getRow5(){return row5;}
    public List<Space> getRow6(){return row6;}
    public List<Space> getRow7(){return row7;}

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

    public Space getSpace(long spaceId){
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
}

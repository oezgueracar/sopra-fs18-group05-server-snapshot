package ch.uzh.ifi.seal.soprafs18.entity.map;

import java.io.Serializable;
import java.util.List;

public abstract class MapElement implements Serializable {

    protected int nextTilePos;
    protected int rotation;

    public void addRow1(Space s){}
    public void addRow2(Space s){}
    public void addRow3(Space s){}
    public void addRow4(Space s){}
    public void addRow5(Space s){}
    public void addRow6(Space s){}
    public void addRow7(Space s){}

    public abstract List<Space> getRow1();
    public abstract List<Space> getRow2();
    public abstract List<Space> getRow3();
    public abstract List<Space> getRow4();
    public abstract List<Space> getRow5();
    public abstract List<Space> getRow6();
    public abstract List<Space> getRow7();

    public void setNextTilePos(int p){}
    public void setRotation(int r){}

    public void setNeighbours() {
    }
}

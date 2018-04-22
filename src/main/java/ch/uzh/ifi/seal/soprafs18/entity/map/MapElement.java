package ch.uzh.ifi.seal.soprafs18.entity.map;

import net.minidev.json.annotate.JsonIgnore;

import java.io.Serializable;

public abstract class MapElement implements Serializable {

    @JsonIgnore
    public void addRow1(Space s){}
    @JsonIgnore
    public void addRow2(Space s){}
    @JsonIgnore
    public void addRow3(Space s){}
    @JsonIgnore
    public void addRow4(Space s){}
    @JsonIgnore
    public void addRow5(Space s){}
    @JsonIgnore
    public void addRow6(Space s){}
    @JsonIgnore
    public void addRow7(Space s){}

    @JsonIgnore
    public void setNextTilePos(int p){}
    @JsonIgnore
    public void setRotation(int r){}

}

package ch.uzh.ifi.seal.soprafs18.entity;

import java.util.ArrayList;

public abstract class Map {

    private ArrayList<Space> spaces = new ArrayList<Space>();
    protected Space startingSpaceP1;
    protected Space startingSpaceP2;
    protected Space startingSpaceP3;
    protected Space startingSpaceP4;

    public Space getStartingSpaceP1(){
        return startingSpaceP1;
    }

    public Space getStartingSpaceP2(){
        return startingSpaceP2;
    }

    public Space getStartingSpaceP3(){
        return startingSpaceP3;
    }

    public Space getStartingSpaceP4(){
        return startingSpaceP4;
    }

}

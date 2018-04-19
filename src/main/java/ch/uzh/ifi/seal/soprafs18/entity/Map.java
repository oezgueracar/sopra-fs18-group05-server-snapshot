package ch.uzh.ifi.seal.soprafs18.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
public abstract class Map implements Serializable{

    @Column
    protected ArrayList<Space> spaces = new ArrayList<Space>();
    @Column
    protected Space startingSpaceP1;
    @Column
    protected Space startingSpaceP2;
    @Column
    protected Space startingSpaceP3;
    @Column
    protected Space startingSpaceP4;

    @Id
    @GeneratedValue
    private Long id;



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

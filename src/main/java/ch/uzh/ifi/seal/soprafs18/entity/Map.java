package ch.uzh.ifi.seal.soprafs18.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

@Entity
public abstract class Map implements Serializable{

    @Column
    protected ArrayList<MapElement> mapTiles = new ArrayList<MapElement>();

    protected ArrayList<Blockade> blockades = new ArrayList<Blockade>();
    protected Random random;


    @Id
    @GeneratedValue
    private Long id;

    protected Blockade getRandomBlockade(){
        random = new Random();
        int index = random.nextInt(blockades.size());
        Blockade blockade = blockades.get(index);
        blockades.remove(index);

        return blockade;
    }

}

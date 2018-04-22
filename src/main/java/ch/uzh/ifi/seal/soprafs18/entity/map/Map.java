package ch.uzh.ifi.seal.soprafs18.entity.map;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public abstract class Map implements Serializable{

    private Long id;

    protected ArrayList<MapElement> mapTiles = new ArrayList<MapElement>();

    protected String name;

    protected ArrayList<Blockade> blockades = new ArrayList<Blockade>();
    protected Random random;

    @JsonIgnore
    protected Blockade getRandomBlockade(){
        random = new Random();
        int index = random.nextInt(blockades.size());
        Blockade blockade = blockades.get(index);
        blockades.remove(index);

        return blockade;
    }

}

package ch.uzh.ifi.seal.soprafs18.entity.map;

import net.minidev.json.annotate.JsonIgnore;

public class Blockade extends MapElement {

    private String color;
    private int value;

    @JsonIgnore
    public Blockade(String col, int val){
        color = col;
        value = val;
    }
}

package ch.uzh.ifi.seal.soprafs18.entity;

import ch.uzh.ifi.seal.soprafs18.entity.map.Space;

import java.io.Serializable;

public class PlayingPiece implements Serializable {

	private String color;
	private Space position;

	public PlayingPiece(String color){
		this.color = color;
	}

	public void setPosition(Space position){
		this.position = position;
	}

	public String getColor(){
		return color;
	}

	public Space getPosition(){
		return position;
	}
}

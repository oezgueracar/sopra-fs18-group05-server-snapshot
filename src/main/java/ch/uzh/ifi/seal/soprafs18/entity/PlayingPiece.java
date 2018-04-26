package ch.uzh.ifi.seal.soprafs18.entity;

import ch.uzh.ifi.seal.soprafs18.entity.map.Space;

import java.io.Serializable;

public class PlayingPiece implements Serializable {

	private String color;
	private int position;

	public PlayingPiece(String color){
		this.color = color;
	}

	public void setPosition(int position){
		this.position = position;
	}

	public String getColor(){
		return color;
	}

	public int getPosition(){
		return position;
	}
}

package ch.uzh.ifi.seal.soprafs18.entity;

import ch.uzh.ifi.seal.soprafs18.entity.map.Space;

import java.io.Serializable;

public class PlayingPiece implements Serializable {

	private String color;
	private long position;

	public PlayingPiece(String color){
		this.color = color;
	}

	public void setPosition(long position){
		this.position = position;
	}

	public String getColor(){
		return color;
	}

	public long getPosition(){
		return position;
	}
}

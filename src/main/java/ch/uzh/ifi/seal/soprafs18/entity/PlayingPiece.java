package ch.uzh.ifi.seal.soprafs18.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class PlayingPiece implements Serializable {

	private String color;
	private long position;

	/**
	 * Constructor
	 * @param color the color
	 */

	//Needed for Serializing
	public PlayingPiece(){

	}

	@JsonIgnore
	public PlayingPiece(String color){
		this.color = color;
	}

	public void setPosition(long position){
		this.position = position;
	}

	public void setColor(String color){
		this.color = color;
	}

	public String getColor(){
		return color;
	}

	public long getPosition(){
		return position;
	}
}

package ch.uzh.ifi.seal.soprafs18.entity;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.Entity;

@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
public class PlayerMode2 extends Player {

	private PlayingPiece assignedPiece2;

    public PlayerMode2(){
		super();
	}

	public PlayingPiece getAssignedPiece2(){
    	return assignedPiece2;
	}

	@Override
	public void setup(){
    	super.setup();
		this.assignedPiece = new PlayingPiece(this.color);
	}
}

package ch.uzh.ifi.seal.soprafs18.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
public class PlayerMode2 extends Player {

	@Lob
	@Column(name = "assignedPiece2", length = Integer.MAX_VALUE - 1)
	@JsonProperty
	private PlayingPiece assignedPiece2;

    public PlayerMode2(){
		super();
	}

	@Override
	public PlayingPiece getPlayingPiece2(){
    	return assignedPiece2;
	}

	@Override
	public void setup(){
    	super.setup();
		this.assignedPiece2 = new PlayingPiece(this.color);
	}
}

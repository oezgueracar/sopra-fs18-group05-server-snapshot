package ch.uzh.ifi.seal.soprafs18.entity;

public class PlayerMode2 extends Player {

	private String colorPieceTwo;

	private PlayingPiece assignedPiece2;

	// TODO: initialization of second playingPiece of a player - add parameter to recognize player.
	/**
	 * Constructor
	 *
	 * @param color1 color of the first playingPiece
	 * @param color2 color of the second playingPiece
	 */
    public PlayerMode2(){
		super();
	}

	public void setColorPieceTwo(String colorPieceTwo) {
		this.colorPieceTwo = colorPieceTwo;
	}

	public String getColorPieceTwo(){
		return colorPieceTwo;
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

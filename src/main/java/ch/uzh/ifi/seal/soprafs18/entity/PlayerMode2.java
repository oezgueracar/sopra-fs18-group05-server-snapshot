package ch.uzh.ifi.seal.soprafs18.entity;

public class PlayerMode2 extends Player {

	private String colorPieceTwo;

	private PlayingPiece assignedPiece2;

    public PlayerMode2(String color, String name, String token){
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

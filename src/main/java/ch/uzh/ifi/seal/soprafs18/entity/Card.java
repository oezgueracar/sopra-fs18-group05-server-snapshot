package ch.uzh.ifi.seal.soprafs18.entity;

public abstract class Card {

	protected long id;
	protected float buyingCost;
	protected float goldValue;
	protected boolean isRemoved;
	protected String cardName;
	protected String cardDescription;

	// TODO: remove a card instance from a game
	public void remove(){
	}

	public long getId(){
		return id;
	}

	public float getBuyingCost() {
		return buyingCost;
	}

	public float getGoldValue() {
		return goldValue;
	}

	public boolean getRemoved() {
		return isRemoved;
	}

	public String getCardName() {
		return cardName;
	}

	public String getCardDescription() {
		return cardDescription;
	}
}

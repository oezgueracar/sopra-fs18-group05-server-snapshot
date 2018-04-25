package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;

import java.io.Serializable;

public abstract class Card implements Serializable {

	protected long id;
	protected float buyingCost;
	protected float goldValue;
	protected boolean itemCard;
	protected String cardName;
	protected String cardDescription;

	// TODO: remove a card instance from a game
	// TODO: ...idea: we could just remove it from the playedPile and NOT move it to the discardPile (if itemCard)
	// TODO: ...(no) idea: how do we handle red spaces???
	public void remove(){
	}

	public void play(Player player){}

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
		return itemCard;
	}

	public String getCardName() {
		return cardName;
	}

	public String getCardDescription() {
		return cardDescription;
	}
}

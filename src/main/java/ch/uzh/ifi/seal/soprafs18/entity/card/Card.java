package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;

import java.io.Serializable;

public class Card implements Serializable {

	private static long count = 0;
	protected long id;
	protected float buyingCost;
	protected float goldValue;
	protected boolean itemCard;
	protected String cardName;

	public void play(Player player){}

	public static void resetStatic(){
		count = 0;
	}

	protected long getNewId(){
		count++;
		return count;
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

	public boolean isItemCard() {
		return itemCard;
	}

	//Needed for Serializing.
	public String getCardName() {
		return cardName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		Card card = (Card) o;
		return this.id == card.getId();
	}

	@Override
	public int hashCode() {
		return Long.hashCode(this.id);
	}
}

package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;
import ch.uzh.ifi.seal.soprafs18.entity.card.Card;

public class ExpeditionCard extends Card {

	protected int value;
	private String color;
	protected boolean itemCard;

	/**
	 * Constructor for class ExpeditionCard
	 * @param buyingCost the amount of gold a card costs to buy
	 * @param goldValue the amount of gold a card is worth when selling it
	 * @param cardName the name of the card
	 * @param color the color of the card
	 * @param value the power value of the card
	 * @param itemCard item cards can only be played once, but if only traded in for gold this effect is not triggered
	 */
	public ExpeditionCard(float buyingCost, float goldValue, String cardName, String color, int value, boolean itemCard) {
		this.buyingCost = buyingCost;
		this.goldValue = goldValue;
		this.cardName = cardName;
		this.color = color;
		this.value = value;
		this.itemCard = itemCard;
		this.id = getNewId();
	}

	/**
	 * Plays a card and moves it from the hand to the playedlist. If the card is an item card it is not moved to the playedlist but still removed from the hand.
	 * @param player the player who plays the card
	 */
	@Override
	public void play(Player player){
			player.setMoveCounter(value, color);
			if(!itemCard){
				player.getPlayedList().add(this);
				player.getHand().remove(this);
			}

			player.getHand().remove(this);
	}

	public int getValue(){
		return value;
	}

	public String getColor(){
		return color;
	}

	protected boolean isItemCard(){
		return itemCard;
	}
}

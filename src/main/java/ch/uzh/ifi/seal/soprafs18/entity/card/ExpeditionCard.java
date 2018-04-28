package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;
import ch.uzh.ifi.seal.soprafs18.entity.card.Card;

public class ExpeditionCard extends Card {

	protected int value;
	private String color;
	protected boolean itemCard;

	// TODO: documentation for constructor
	/**
	 * Constructor for class ExpeditionCard
	 * @param buyingCost
	 * @param goldValue
	 * @param cardName
	 * @param color
	 * @param value
	 * @param itemCard
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

	@Override
	public void play(Player player){
			player.setMoveCounter(value, color);
			if(itemCard){
				return;
			}else{
				player.getPlayedList().add(this);
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

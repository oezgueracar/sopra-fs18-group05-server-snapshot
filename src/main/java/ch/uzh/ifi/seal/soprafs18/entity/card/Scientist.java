package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;
import ch.uzh.ifi.seal.soprafs18.entity.card.ActionCard;

public class Scientist extends ActionCard {

	// TODO: documentation for constructor
	/**
	 * Constructor for class Scientist
	 * @param buyingCost
	 * @param goldValue
	 * @param cardName
	 * @param cardDescription
	 */
	public Scientist(float buyingCost, float goldValue, String cardName, String cardDescription) {
		this.buyingCost = buyingCost;
		this.goldValue = goldValue;
		this.cardName = cardName;
		this.cardDescription = cardDescription;
	}

	public void play(Player player){
		player.drawCard();
		player.getHand().remove(this);
	}
}

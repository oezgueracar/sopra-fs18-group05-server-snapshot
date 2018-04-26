package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;
import ch.uzh.ifi.seal.soprafs18.entity.card.ActionCard;

public class TravelLog extends ActionCard {

	// TODO: documentation for constructor
	/**
	 * Constructor for class TravelLog
	 * @param buyingCost
	 * @param goldValue
	 * @param cardName
	 * @param cardDescription
	 */
	public TravelLog(float buyingCost, float goldValue, String cardName, String cardDescription) {
		this.buyingCost = buyingCost;
		this.goldValue = goldValue;
		this.cardName = cardName;
		this.cardDescription = cardDescription;
		this.id = getNewId();
	}
	public void play(Player player){
		player.drawCard();
		player.drawCard();
		player.getHand().remove(this);
	}
}

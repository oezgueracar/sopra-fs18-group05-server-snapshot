package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.card.ActionCard;

public class Native extends ActionCard {

	// TODO: documentation for constructor
	/**
	 * Constructor for class Native
	 * @param buyingCost
	 * @param goldValue
	 * @param cardName
	 * @param cardDescription
	 */
	public Native(float buyingCost, float goldValue, String cardName, String cardDescription) {
		this.buyingCost = buyingCost;
		this.goldValue = goldValue;
		this.cardName = cardName;
		this.cardDescription = cardDescription;
	}
}

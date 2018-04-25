package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;
import ch.uzh.ifi.seal.soprafs18.entity.card.ActionCard;
import ch.uzh.ifi.seal.soprafs18.entity.map.Space;

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

	public void play(Player player){//TODO service has to move the laying piece
		player.getPlayedList().add(this);
		player.getHand().remove(this);
	}
}

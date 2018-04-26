package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;
import ch.uzh.ifi.seal.soprafs18.entity.card.ActionCard;

public class Compass extends ActionCard {

	// TODO: documentation for constructor
	/**
	 * Constructor for class Compass
	 * @param buyingCost
	 * @param goldValue
	 * @param cardName
	 * @param cardDescription
	 */
	public Compass(float buyingCost, float goldValue, String cardName, String cardDescription) {
		this.buyingCost = buyingCost;
		this.goldValue = goldValue;
		this.cardName = cardName;
		this.cardDescription = cardDescription;
		this.id = getNewId();
	}

	@Override
	public void play(Player player){
		player.drawCard();
		player.drawCard();
		player.drawCard();
		player.getHand().remove(this);
		player.getPlayedList().add(this);
	}
}

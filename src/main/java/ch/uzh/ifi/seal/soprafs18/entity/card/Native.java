package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;
import ch.uzh.ifi.seal.soprafs18.entity.card.ActionCard;
import ch.uzh.ifi.seal.soprafs18.entity.map.Space;

public class Native extends ActionCard {

	/**
	 * Constructor for class Native
	 */
	public Native() {
		this.buyingCost = 5f;
		this.goldValue = 0.5f;
		this.cardName = "Native";
		this.cardDescription = "Move your playing piece to an adjacent space.";
		this.id = getNewId();
	}

	public void play(Player player){//TODO service has to move the playing piece
		player.getPlayedList().add(this);
		player.getHand().remove(this);
	}
}

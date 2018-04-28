package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;
import ch.uzh.ifi.seal.soprafs18.entity.card.ActionCard;

public class Cartographer extends ActionCard {

	// TODO: documentation for constructor
	/**
	 * Constructor for class Cartographer
	 */

	public Cartographer() {
		this.buyingCost = 4f;
		this.goldValue = 0.5f;
		this.cardName = "Cartographer";
		this.cardDescription = "Draw 2 cards from your draw pile.";
		this.id = getNewId();
	}

	@Override
	public void play(Player player){
		player.drawCard();
		player.drawCard();
		player.getHand().remove(this);
		player.getPlayedList().add(this);
	}
}

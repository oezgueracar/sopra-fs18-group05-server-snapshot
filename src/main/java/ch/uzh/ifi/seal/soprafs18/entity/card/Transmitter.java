package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;
import ch.uzh.ifi.seal.soprafs18.entity.card.ActionCard;

public class Transmitter extends ActionCard {

	// TODO: documentation for constructor
	/**
	 * Constructor for class Transmitter
	 */
	public Transmitter() {
		this.buyingCost = 4f;
		this.goldValue = 0.5f;
		this.cardName = "Transmitter";
		this.cardDescription = "Choose any one card from the market (off board cards are allowed) and place it on your discard pile.";
		this.id = getNewId();
	}

	public void play(Player player){
		// TODO: service has to delete the card from the market - item card
		// TODO: get card from market
		player.getHand().remove(this);
	}
}

package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;
import ch.uzh.ifi.seal.soprafs18.entity.card.ActionCard;

public class Transmitter extends ActionCard {

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

	/**
	 * The card is played and removed from the hand, since it is an item card it is not added to the playedlist.
	 * @param player the player who plays the card
	 */
	public void play(Player player){
		// TODO: Choose card from market and move it to the discard pile
		player.getHand().remove(this);
	}
}

package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;

public class Transmitter extends ActionCard {

	/**
	 * Constructor for class Transmitter
	 */
	public Transmitter() {
		this.buyingCost = 4f;
		this.goldValue = 0.5f;
		this.cardName = "Transmitter";
		this.id = getNewId();
	}

	/**
	 * The card is played and removed from the hand, since it is an item card it is not added to the playedlist.
	 * @param player the player who plays the card
	 */
	public void play(Player player){
		player.getHand().remove(this);
	}
}

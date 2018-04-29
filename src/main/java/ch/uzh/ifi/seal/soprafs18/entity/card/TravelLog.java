package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;
import ch.uzh.ifi.seal.soprafs18.entity.card.ActionCard;

public class TravelLog extends ActionCard {

	/**
	 * Constructor for class TravelLog
	 */
	public TravelLog() {
		this.buyingCost = 3f;
		this.goldValue = 0.5f;
		this.cardName = "Travel Log";
		this.cardDescription = "Draw 2 cards from your draw pile. Then choose up to 2 cards in your hand and remove them from the game.";
		this.id = getNewId();
	}
	public void play(Player player){
		player.drawCard();
		player.drawCard();
		player.getHand().remove(this);

		// A player is allowed to remove up to 2 cards from his hand by playing this card.
		// TODO: How do we remove 2 cards

	}
}

package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;
import ch.uzh.ifi.seal.soprafs18.entity.card.ActionCard;

public class Scientist extends ActionCard {

	// TODO: documentation for constructor
	/**
	 * Constructor for class Scientist
	 */
	public Scientist() {
		this.buyingCost = 4f;
		this.goldValue = 0.5f;
		this.cardName = "Scientist";
		this.cardDescription = "Draw 1 card from your draw pile. Then choose up to 1 card in your hand and remove it from the game.";
		this.id = getNewId();
	}

	public void play(Player player){//TODO Frontend needs to send discarded card
		player.drawCard();
		player.getHand().remove(this);
		player.getPlayedList().add(this);
	}
}

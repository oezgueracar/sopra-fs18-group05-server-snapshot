package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;
import ch.uzh.ifi.seal.soprafs18.entity.card.ActionCard;

public class Scientist extends ActionCard {

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

	/**
	 * The card is played and removed from the hand, then it is added to the played list.
	 * @param player the player who plays the card
	 */
	public void play(Player player){
		player.drawCard();
		player.getHand().remove(this);
		player.getPlayedList().add(this);

		// A player is allowed to remove up to 1 card from his hand by playing this card.
		// TODO: How do we remove a card?
	}
}

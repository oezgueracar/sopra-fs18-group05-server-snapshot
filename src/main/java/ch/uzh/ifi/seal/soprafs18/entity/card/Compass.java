package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;
import ch.uzh.ifi.seal.soprafs18.entity.card.ActionCard;

public class Compass extends ActionCard {

	// TODO: item card!!
	/**
	 * Constructor for class Compass
	 */
	public Compass() {
		this.buyingCost = 2f;
		this.goldValue = 0.5f;
		this.cardName = "Compass";
		this.cardDescription = "Draw 3 cards from your draw pile.";
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

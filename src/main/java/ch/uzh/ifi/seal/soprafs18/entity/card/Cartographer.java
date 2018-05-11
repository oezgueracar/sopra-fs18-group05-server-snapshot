package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;

public class Cartographer extends ActionCard {

	/**
	 * Constructor for class Cartographer
	 */
	public Cartographer() {
		this.buyingCost = 4f;
		this.goldValue = 0.5f;
		this.cardName = "Cartographer";
		this.id = getNewId();
		this.itemCard = false;
	}

	/**
	 * The card is played and removed from the hand, then it is added to the played list.
	 * @param player the player who plays the card
	 */
	@Override
	public void play(Player player){
		player.drawCard();
		player.drawCard();
		player.getPlayedList().add(this);
		player.getHand().remove(this);
	}
}

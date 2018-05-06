package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;

public class Compass extends ActionCard {

	/**
	 * Constructor for class Compass
	 */
	public Compass() {
		this.buyingCost = 2f;
		this.goldValue = 0.5f;
		this.cardName = "Compass";
		this.id = getNewId();
		this.itemCard = true;
	}

	/**
	 * The card is played and removed from the hand, since it is an item card it is not added to the played list.
	 * @param player the player who plays the card
	 */
	@Override
	public void play(Player player){
		player.drawCard();
		player.drawCard();
		player.drawCard();

		player.getHand().remove(this);
	}
}

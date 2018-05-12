package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;

public class Scientist extends ActionCard {

	/**
	 * Constructor for class Scientist
	 */
	public Scientist() {
		this.buyingCost = 4f;
		this.goldValue = 0.5f;
		this.cardName = "Scientist";
		this.id = getNewId();
	}

	/**
	 * The card is played and removed from the hand, then it is added to the played list.
	 * @param player the player who plays the card
	 */
	public void play(Player player){
		player.drawCard();
		player.getPlayedList().add(this);
		for(int i = 0; i < player.getHand().size(); i++){
			if(this.id == player.getHand().get(i).getId()){
				player.getHand().remove(i);
				break;
			}
		}
	}
}

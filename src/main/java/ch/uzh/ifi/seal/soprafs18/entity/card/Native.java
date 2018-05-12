package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;

public class Native extends ActionCard {

	/**
	 * Constructor for class Native
	 */
	public Native() {
		this.buyingCost = 5f;
		this.goldValue = 0.5f;
		this.cardName = "Native";
		this.id = getNewId();
	}

	/**
	 * The card is played and removed from the hand, then it is added to the played list.
	 * @param player the player who plays the card
	 */
	public void play(Player player){
		player.getPlayedList().add(this);
		for(int i = 0; i < player.getHand().size(); i++){
			if(this.id == player.getHand().get(i).getId()){
				player.getHand().remove(i);
				break;
			}
		}
	}
}

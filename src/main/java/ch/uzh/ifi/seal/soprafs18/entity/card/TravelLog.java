package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;

public class TravelLog extends ActionCard {

	/**
	 * Constructor for class TravelLog
	 */
	public TravelLog() {
		this.buyingCost = 3f;
		this.goldValue = 0.5f;
		this.cardName = "Travel Log";
		this.id = getNewId();
	}

	public void play(Player player){
		player.drawCard();
		player.drawCard();
		for(int i = 0; i < player.getHand().size(); i++){
			if(this.id == player.getHand().get(i).getId()){
				player.getHand().remove(i);
				break;
			}
		}
	}
}

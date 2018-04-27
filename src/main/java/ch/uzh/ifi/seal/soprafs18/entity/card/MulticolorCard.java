package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;
import ch.uzh.ifi.seal.soprafs18.entity.card.ExpeditionCard;

public class MulticolorCard extends ExpeditionCard {

    private String chosenColor;
    /**
     * Constructor for class ExpeditionCard
     * @param buyingCost
     * @param goldValue
     * @param cardName
     * @param cardDescription
     * @param color
     * @param value
     * @param itemCard
     */

    public MulticolorCard(float buyingCost, float goldValue, String cardName, String cardDescription, String color, int value, boolean itemCard){
        super(buyingCost, goldValue, cardName, cardDescription, color, value, itemCard);
    }

    @Override
    public void play(Player player){
        player.setMoveCounter(this.value, chosenColor);
        if(itemCard){
            return;
        }else{
            player.getPlayedList().add(this);
        }
        player.getHand().remove(this);
    }

    public void setChosenColor(String newChosenColor) {
        this.chosenColor = newChosenColor;
    }

    public String getChosenColor(){
        return chosenColor;
    }
}

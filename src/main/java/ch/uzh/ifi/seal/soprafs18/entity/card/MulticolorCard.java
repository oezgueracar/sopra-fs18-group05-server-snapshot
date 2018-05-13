package ch.uzh.ifi.seal.soprafs18.entity.card;

import ch.uzh.ifi.seal.soprafs18.entity.Player;

public class MulticolorCard extends ExpeditionCard {

    protected String chosenColor;
    /**
     * Constructor for class ExpeditionCard
     * @param buyingCost the amount of gold a card costs to buy
     * @param goldValue the amount of gold a card is worth when selling it
     * @param cardName the name of the card
     * @param color the color of the card
     * @param value the power value of the card
     * @param itemCard item cards can only be played once, but if only traded in for gold this effect is not triggered
     */
    public MulticolorCard(float buyingCost, float goldValue, String cardName, String color, int value, boolean itemCard){
        super(buyingCost, goldValue, cardName, color, value, itemCard);
        chosenColor = null;
    }

    /**
     * The card is played and removed from the hand, if it is an item card it is not added to the played list.
     * @param player the player who plays the card
     */
    @Override
    public void play(Player player){
        player.resetMoveCounter();
        player.setMoveCounter(this.value, chosenColor);
        if(itemCard){
            for(int i = 0; i < player.getHand().size(); i++){
                if(this.id == player.getHand().get(i).getId()){
                    player.getHand().remove(i);
                    break;
                }
            }
        }
        else {
            player.getPlayedList().add(this);
            for(int i = 0; i < player.getHand().size(); i++){
                if(this.id == player.getHand().get(i).getId()){
                    player.getHand().remove(i);
                    break;
                }
            }
        }
        player.setChosenColor(null);
    }

    public void setChosenColor(String newChosenColor) {
        this.chosenColor = newChosenColor;
    }

    public String getChosenColor(){
        return chosenColor;
    }
}

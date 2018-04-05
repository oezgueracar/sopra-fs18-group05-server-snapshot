package ch.uzh.ifi.seal.soprafs18.entity;

public class MulticolorCard extends ExpeditionCard {

    private String chosenColor;

    public MulticolorCard(float buyingCost, float goldValue, String cardName, String cardDescription, String color, int value, boolean itemCard){
        super(buyingCost, goldValue, cardName, cardDescription, color, value, itemCard);
    }

    public void setChosenColor(String newChosenColor) {
        this.chosenColor = newChosenColor;
    }

    public String getChosenColor(){
        return chosenColor;
    }
}

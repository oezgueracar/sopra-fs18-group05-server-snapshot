package ch.uzh.ifi.seal.soprafs18.entity;

public class Scientist extends ActionCard{
	public Scientist(float buyingCost, float goldValue, String cardName, String cardDescription) {
		this.buyingCost = buyingCost;
		this.goldValue = goldValue;
		this.cardName = cardName;
		this.cardDescription = cardDescription;
	}
}

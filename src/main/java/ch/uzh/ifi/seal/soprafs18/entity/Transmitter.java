package ch.uzh.ifi.seal.soprafs18.entity;

public class Transmitter extends ActionCard{
	public Transmitter(float buyingCost, float goldValue, String cardName, String cardDescription) {
		this.buyingCost = buyingCost;
		this.goldValue = goldValue;
		this.cardName = cardName;
		this.cardDescription = cardDescription;
	}
}

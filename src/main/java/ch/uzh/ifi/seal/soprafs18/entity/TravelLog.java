package ch.uzh.ifi.seal.soprafs18.entity;

public class TravelLog extends ActionCard{
	public TravelLog(float buyingCost, float goldValue, String cardName, String cardDescription) {
		this.buyingCost = buyingCost;
		this.goldValue = goldValue;
		this.cardName = cardName;
		this.cardDescription = cardDescription;
	}
}

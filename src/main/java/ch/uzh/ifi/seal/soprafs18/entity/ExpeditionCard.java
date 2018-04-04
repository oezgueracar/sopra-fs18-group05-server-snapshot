package ch.uzh.ifi.seal.soprafs18.entity;

public class ExpeditionCard extends Card{

	private int value;
	private String color;

	public ExpeditionCard(float buyingCost, float goldValue, String cardName, String cardDescription, String color, int value) {
		this.buyingCost = buyingCost;
		this.goldValue = goldValue;
		this.cardName = cardName;
		this.cardDescription = cardDescription;
		this.color = color;
		this.value = value;
	}
}

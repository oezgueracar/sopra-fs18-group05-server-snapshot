package ch.uzh.ifi.seal.soprafs18.entity;

public class ExpeditionCard extends Card{

	private int value;
	private String color;

	// TODO: documentation for constructor
	/**
	 * Constructor for class ExpeditionCard
	 * @param buyingCost
	 * @param goldValue
	 * @param cardName
	 * @param cardDescription
	 * @param color
	 * @param value
	 */
	public ExpeditionCard(float buyingCost, float goldValue, String cardName, String cardDescription, String color, int value) {
		this.buyingCost = buyingCost;
		this.goldValue = goldValue;
		this.cardName = cardName;
		this.cardDescription = cardDescription;
		this.color = color;
		this.value = value;
	}
}

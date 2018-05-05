package ch.uzh.ifi.seal.soprafs18.entity;

import ch.uzh.ifi.seal.soprafs18.entity.card.Card;
import ch.uzh.ifi.seal.soprafs18.entity.card.ExpeditionCard;
import ch.uzh.ifi.seal.soprafs18.entity.map.Blockade;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.persistence.*;

@Entity
public class Player implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "playerId")
	protected Long id;

	@Column(nullable = false)
	protected String name;

	// A unique token for a player - Is generated in Service
	@Column(nullable = false, unique = true)
	protected String token;

	/*@Column(nullable = false)
	private PlayerStatus status;*/

	@Column(nullable = false)
	protected String color;

	// Is set to false in Service when creating player
	@Column(nullable = false)
	protected boolean playerLeft;

	@Column(nullable = false)
	protected boolean ready;

	// Is the amount of coins a player has in a turn
	@Column()
	protected float coins;

	// Is true if the playingPiece of the player is in an end space
	@Column(nullable = false)
	protected boolean isInGoal;

	@Column
	protected boolean winner;

    private Long gameId;

	@Column()
	protected long boughtCardId;

    // Contains the cards that are in the hand
	@Type(type = "serializable")
	@Column(name = "hand", length = Integer.MAX_VALUE - 1)
	@JsonProperty
    protected List<Card> hand;

    // Contains the cards that are in the deck
	@Type(type = "serializable")
	@Column(name = "deck", length = Integer.MAX_VALUE - 1)
	@JsonProperty
    protected List<Card> deck;

    // Contains the cards in the discardPile
	@Type(type = "serializable")
	@Column(name = "discardPile", length = Integer.MAX_VALUE - 1)
	@JsonProperty
    protected List<Card> discardPile;

    // Contains the cards that were played in this turn
	@Type(type = "serializable")
	@Column(name = "playedList", length = Integer.MAX_VALUE - 1)
	@JsonProperty
    protected List<Card> playedList;

	@Type(type = "serializable")
	@Column(name = "blockades", length = Integer.MAX_VALUE - 1)
	@JsonProperty
	protected List<Blockade> blockades;

    // Depending on the position in the ArrayList the counter is referring to the color - only one entry can be different from 0!
	// [green, blue, yellow]
    protected int[] moveCounter = new int[3];

	@Lob
	@Column(name = "assignedPiece", length = Integer.MAX_VALUE - 1)
	@JsonProperty
	protected PlayingPiece assignedPiece;

	/**
	 * Constructor of the class Player
	 * The Array moveCounter is initialized
	 */
	public Player() {
		playerLeft = false;
		ready = false;
		isInGoal = false;
		winner = false;
		setToken(UUID.randomUUID().toString());
		boughtCardId = 0;
	}

	public Long getId() {
		return id;
	}

	public String getToken(){
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getName() {
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public boolean getReady() {
		return ready;
	}

	public void setReady(boolean b) {
		this.ready = b;
	}

	public void setGameId(Long gameId){
		this.gameId = gameId;
	}

	public String getColor(){
		return color;
	}

	public float getCoins(){return coins;}

	public List<Card> getDeck(){
		return deck;
	}

	public List<Card> getHand() {
		return hand;
	}

	public int[] getMoveCounter() {
		return moveCounter;
	}

	public boolean getPlayerLeft() {
		return playerLeft;
	}

	public boolean getIsInGoal(){
		return isInGoal;
	}

	//Needed for Serializing
	public boolean getWinner(){
		return winner;
	}

	public List<Card> getDiscardPile(){
		return discardPile;
	}

	public List<Card> getPlayedList(){
		return playedList;
	}

	public List<Blockade> getBlockades(){
		return blockades;
	}

	public Long getGameId(){
		return gameId;
	}

	@JsonIgnore
	public PlayingPiece getPlayingPiece(){
		return assignedPiece;
	}

	public long getBoughtCardId(){
		return boughtCardId;
	}

	@JsonIgnore
	public String getMoveCounterColor(){
		if (this.getMoveCounter()[0] != 0) {
			return "green";
		} else if (this.getMoveCounter()[1] != 0) {
			return "blue";
		} else if (this.getMoveCounter()[2] != 0) {
			return "yellow";
		}
		return null;
	}

	public void setBoughtCardId(long boughtCardId){
		this.boughtCardId = boughtCardId;
	}

	/**
	 * Plays
	 * @pre hand.contains(card)
	 * @post (hand.size()@pre == hand.size()+1) && (playedCards.size()@pre = playedCards.size()-1)
	 * @param card the card that is played
	 * (@throws NoSuchElementException If the hand does not contain card)
	 */
	protected void playCard(Card card){ // throws NoSuchElementException
		if (card == null){
			return; // throw new NoSuchElementException("This card is not in the player's hand.");
		}
		else {
			card.play(this);
		}
	}

	/**
	 * Checks if a requested card is in this player's hand.
	 * @param cardId
	 * @return instance Card matching cardId, if the card is in this player's hand, otherwise null
	 */
	public Card getCardFromHandById(long cardId){
		for (Card c : hand){
			if (c.getId() == cardId) {
				return c;
			}
		}
		return null;
	}

	// TODO: precondition not valid yet
	// TODO: A player can only buy one card a turn! Is handled in GameService but should rather be handled here.
	/**
	 * Buys a card - moves a card from the market to the discardPile and resets coins
	 *
	 * @pre market.openSlot.contains(card) || (market.openSlots.contains(null) && market.closedSlots.contains(card))
	 * @post (coins@pre >= card.buyingCost())
	 * @param cardId the card that is bought
	 * (@throws NoSuchElementException If the market does not contain card)
	 */
	public void buyCard(long cardId, Market m){
		Card boughtCard = m.removeCard(cardId);

		if(boughtCard != null && (this.getCoins() >= boughtCard.getBuyingCost())){
			this.decreaseCoins(boughtCard.getBuyingCost());
			this.discardPile.add(boughtCard);
		}
	}

	/**
	 * Moves a card from the hand to the playedList and adjusts coins
	 *
	 * @pre hand.contains(card)
	 * @post (hand.size()@pre == hand.size()+1) && (playedCards.size()@pre = playedCards.size()-1) && (coins@pre == coins+card.getGoldValue())
	 * @param cardId the card that is sold
	 * (@throws NoSuchElementException If the hand does not contain card)
	 */
	// TODO: Exception throwing and handling
	public void tradeinCard(long cardId) { // throws NoSuchElementException
		Card tradedInCard = getCardFromHandById(cardId);
		if(tradedInCard == null){
			// throw new NoSuchElementException("This card is not in the player's hand.");
		}
		else{
			increaseCoins(tradedInCard.getGoldValue());
			hand.remove(tradedInCard);
			playedList.add(tradedInCard);
		}
	}

	/**
	 * Draws a card from the deck and moves it to the hand.
	 *
	 * @pre (!deck.isEmpty()) && (!discardPile.isEmpty())
	 * @post (hand.size()@pre == hand.size()-1) && (deck.size()@pre==deck.size()+1)
	 * (@throws NoSuchElementException If no further card is available to be drawn)
	 */
	// TODO: Exception throwing and handling
	public void drawCard() { // throws NoSuchElementException
		if(deck.isEmpty()){
			if (discardPile.isEmpty()){
				return;	// throw new NoSuchElementException("No further card is available to be drawn.");
			}else {
				flushDiscardPile();
			}
		}
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(deck.size());
		Card card = deck.get(index);
		hand.add(card);
		deck.remove(card);
	}

	/**
	 * Draws a card from the deck and moves it to the hand.
	 */
	public void drawCardOnEndTurn(){
		if(hand != null && deck != null) {
			while ((hand.size() <= 4) && !(deck.isEmpty())) {
				drawCard();
			}
		}
	}

	/**
	 * Moves all entries in playedList to the discardPile.
	 */
	public void flushPlayedList(){
		discardPile.addAll(playedList);
		playedList.clear();
	}

	/**
	 * Moves all entries in discardPile to the deck.
	 */
	private void flushDiscardPile(){
		deck.addAll(discardPile);
		discardPile.clear();
	}

	/**
	 * Sets an entry (depending on the color) in moveCounter to the according value
	 * @param i the value of the counter
	 * @param color the color of the counter
	 */
	public void setMoveCounter(int i, String color){
		switch (color.toLowerCase()){
			case "green":
				moveCounter[0] = i;
				break;
			case "blue":
				moveCounter[1] = i;
				break;
			case "yellow":
				moveCounter[2] = i;
				break;
		}
	}

	/**
	 * Resets the moveCounter (Empties all entries in the Array)
	 */
	public void resetMoveCounter(){
		moveCounter[0]=0;
		moveCounter[1]=0;
		moveCounter[2]=0;
	}

	protected void increaseCoins(float f){
		coins += f;
	}

	protected void decreaseCoins(float f){
		coins -= f;
	}

	public void resetCoins(){coins=0f;}

	public void setPlayerLeft(boolean b){
		playerLeft = b;
	}

	public void setIsInGoal(boolean b){
		isInGoal = b;
	}

	public void setWinner(){
		winner = !winner;
	}

	public void setColor(String newColor){
		this.color = newColor;
	}

	/**
	 * Sets up the cards that belong to the starting hand or deck of a player.
	 * Three explorers, one sailor and four travelers are given to each player at the start of the game.
	 */
	private void setupCards(){
		for(int i = 0; i < 3; i++){
			this.deck.add(new ExpeditionCard(1, 0.5f, "Explorer", "green", 1, false));
		}

		this.deck.add(new ExpeditionCard(1, 0.5f, "Sailor", "blue", 1, false));

		for(int i = 0; i < 4; i++){
			this.deck.add(new ExpeditionCard(1, 1.0f, "Traveler", "yellow", 1, false));
		}
	}

	/**
	 * Sets up the player by initializing his playingPiece, hand, deck, discardPile, playedList and owned blockades.
	 */
	public void setup(){
		this.assignedPiece = new PlayingPiece(this.color);

		hand = new ArrayList<>();
		deck = new ArrayList<>();
		discardPile = new ArrayList<>();
		playedList = new ArrayList<>();
		blockades = new ArrayList<>();

		this.setupCards();

		this.drawCard();
		this.drawCard();
		this.drawCard();
		this.drawCard();
	}

	// TODO: Organized structure: setup - play/buy/tradein - move from arrays to arrays - increase/decrease counters - resetter - getters - setters

	// TODO: setups here

	// TODO: play/buy/tradein

	// TODO: Moving cards

	// TODO: counters

	// TODO: resetters

	// TODO: getters here

	// TODO: setters here



	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (o == null)
			return false;
		if (getClass() != o.getClass())
			return false;
		Player player = (Player) o;
		return this.id == player.getId();
	}

	@Override
	public int hashCode() {
		if (this.id != null) {
			return Long.hashCode(this.id);
		}
		else {
			return super.hashCode();
		}
	}
}

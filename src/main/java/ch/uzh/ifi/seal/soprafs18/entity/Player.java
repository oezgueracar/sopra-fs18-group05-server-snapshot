package ch.uzh.ifi.seal.soprafs18.entity;

import ch.uzh.ifi.seal.soprafs18.entity.card.Card;
import ch.uzh.ifi.seal.soprafs18.entity.card.ExpeditionCard;
import ch.uzh.ifi.seal.soprafs18.entity.map.Space;
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

	// TODO: check at point of setting status to "ready" if valid color
	@Column(nullable = false)
	protected String color;

	// Is set to false in Service when creating player
	@Column(nullable = false)
	protected Boolean playerLeft;

	@Column(nullable = false)
	protected Boolean ready;

	// Is the amount of coins a player has in a turn
	@Column()
	protected float coins;

	// Is true if the playingPiece of the player is in an end space
	@Column(nullable = false)
	protected Boolean isInGoal;

    //@ManyToOne
	//@Column(name="playersGameId", nullable = false)
    private Long gameId; // TODO: Check if Game or Long as type

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
		setToken(UUID.randomUUID().toString());
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

	public Boolean getReady() {
		return ready;
	}

	public void setReady(Boolean b) {
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

	public Boolean getPlayerLeft() {
		return playerLeft;
	}

	public Boolean getIsInGoal(){
		return isInGoal;
	}

	public List<Card> getDiscardPile(){
		return discardPile;
	}

	public List<Card> getPlayedList(){
		return playedList;
	}

	public Long getGameId(){
		return gameId;
	}

	public PlayingPiece getPlayingPiece(){
		return assignedPiece;
	}

	/**
	 * Plays
	 * @pre hand.contains(card)
	 * @post (hand.size()@pre == hand.size()+1) && (playedCards.size()@pre = playedCards.size()-1)
	 * @param card the card that is played
	 * (@throws NoSuchElementException If the hand does not contain card)
	 */
	protected void playCard(Card card){ // throws NoSuchElementException
		if (!hand.contains(card)){
			return; // throw new NoSuchElementException("This card is not in the player's hand.");
		}else{ // TODO: multiColorCard has to set its chosen color first in PlayerService before calling playCard!
			card.play(this);
		}
	}

	protected void move(PlayingPiece piece, Integer selectedSpaceID){

	}

	// TODO: precondition not valid yet
	// TODO: A player can only buy one card a turn!
	/**
	 * Buys a card - moves a card from the market to the discardPile and resets coins
	 *
	 * @pre market.openSlot.contains(card) || (market.openSlots.contains(null) && market.closedSlots.contains(card))
	 * @post (coins@pre >= card.buyingCost())
	 * @param card the card that is bought
	 * (@throws NoSuchElementException If the market does not contain card)
	 */
	protected void buyCard(Card card){
		//if (!market.getOpenSlots().contains(card)){}


	}

	/**
	 * Moves a card from the hand to the playedList and adjusts coins
	 *
	 * @pre hand.contains(card)
	 * @post (hand.size()@pre == hand.size()+1) && (playedCards.size()@pre = playedCards.size()-1) && (coins@pre == coins+card.getGoldValue())
	 * @param card the card that is sold
	 * (@throws NoSuchElementException If the hand does not contain card)
	 */
	// TODO: Exception throwing and handling
	protected void sellCard(Card card) { // throws NoSuchElementException
		if (!hand.contains(card)){
			// throw new NoSuchElementException("This card is not in the player's hand.");
		}else{
			setCoins(card.getGoldValue());
			playedList.add(card);
			hand.remove(card);
		}
	}

	/**
	 * Draws a card from the deck and moves it to the hand
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
				deck = new ArrayList<>(discardPile);
				resetDiscardPile();
			}
		}
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(deck.size());
		Card card = deck.get(index);
		hand.add(card);
		deck.remove(card);
	}

	protected void addCardToDeck(Card card){
		deck.add(card);
	}

	protected void addCardToDiscardPile(Card card){
		discardPile.add(card);
	}

	public void addCardToPlayingList(Card card){
		playedList.add(card);
	}

	protected void removeCardFromHand(Card card){
		hand.remove(card);
	}

	protected void removeCardFromDiscardPile(Card card){
		discardPile.remove(card);
	}

	protected void removeCardFromDeck(Card card){
		deck.remove(card);
	}

	protected void resetPlayedList(){
		playedList.clear();
	}

	/**
	 * Resets the discardPile (Empties the ArrayList)
	 */
	private void resetDiscardPile(){
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
				moveCounter[0] = moveCounter[0]+i;
				break;
			case "blue":
				moveCounter[1] = moveCounter[1]+i;
				break;
			case "yellow":
				moveCounter[2] = moveCounter[2]+i;
				break;
		}
	}

	/**
	 * Resets the moveCounter (Empties all entries in the Array)
	 */
	protected void resetMoveCounter(){
		moveCounter[0]=0;
		moveCounter[1]=0;
		moveCounter[2]=0;
	}

	protected void setCoins(float f){
		coins += f;
	}

	protected void resetCoins(){coins=0f;}

	public void setPlayerLeft(Boolean b){
		playerLeft = b;
	}

	public void setIsInGoal(Boolean b){
		isInGoal = b;
	}

	public void setColor(String newColor){
		this.color = newColor;
	}

	//Fill the deck of the player with the starting cards as stated in the game manual.
	private void setupCards(){
		for(int i = 0; i < 3; i++){
			this.addCardToDeck(new ExpeditionCard(1, 0.5f, "Explorer", "Allows you to move your Playing Piece to a green Space by increasing your Move Counter to \"1\"", "green", 1, false));
		}

		this.addCardToDeck(new ExpeditionCard(1, 0.5f, "Sailor", "Allows you to move your Playing Piece to a blue Space by increasing your Move Counter to \"1\"", "blue", 1, false));

		for(int i = 0; i < 4; i++){
			this.addCardToDeck(new ExpeditionCard(1, 1.0f, "Traveler", "Allows you to move your Playing Piece to a yellow Space by increasing your Move Counter to \"1\"", "yellow", 1, false));
		}
	}

	//Sets up the player so he's ready before entering the game.
	public void setup(){
		this.assignedPiece = new PlayingPiece(this.color);

		// Contains the cards that are in the hand
		hand = new ArrayList<>();

		// Contains the cards that are in the deck
		deck = new ArrayList<>();

		// Contains the cards in the discardPile
		discardPile = new ArrayList<>();

		// Contains the cards that were played in this turn
		playedList = new ArrayList<>();

		this.setupCards();
	}

	// ##############################################################################################################

	/*
	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof Player)) {
			return false;
		}
		Player player = (Player) o;
		return this.getId().equals(player.getId());
	}*/

}

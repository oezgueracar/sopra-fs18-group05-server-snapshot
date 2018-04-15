package ch.uzh.ifi.seal.soprafs18.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import javax.persistence.*;

import ch.uzh.ifi.seal.soprafs18.constant.PlayerStatus;
import com.sun.org.apache.xpath.internal.operations.Bool;

@Entity
public class Player implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	protected Long id;

	@Column(nullable = false) 
	protected String name;
	
	/*@Column(nullable = false, unique = true)
	private String playerName;*/

	// A unique token for a player
	@Column(nullable = false, unique = true) 
	protected String token;

	@Column(nullable = false)
	private PlayerStatus status;

	// Is the amount of coins a player has in a turn
	@Column(nullable = false)
	protected float coins;

	@Column(nullable = false)
	protected Boolean playerLeft;

	//
	@Column(nullable = false)
	protected String color;

	// Is true if the playingPiece of the player is in an end space
	@Column(nullable = false)
	protected Boolean isInGoal;

    @ManyToOne
	@JoinColumn(name="game_id")
    private Game game;
	/*
    @OneToMany(mappedBy="player")
    private List<Move> moves;*/

    // Contains the cards that are in the hand
    //@OneToMany(mappedBy = "player")
    protected ArrayList<Card> hand;

    // Contains the cards that are in the deck
    protected ArrayList<Card> deck;

    // Contains the cards in the discardPile
    protected ArrayList<Card> discardPile;

    // Contains the cards that were played in this turn
    protected ArrayList<Card> playedList;

    // Depending on the position in the ArrayList the counter is referring to the color - only one entry can be different from 0
    protected int moveCounter;

	//protected PlayingPiece assignedPiece;

	/**
	 * Constructor of the class Player
	 * @param
	 *//*
	public Player(String name) {
		this.name = name;
	}NO CONSTRUCTOR NEEDED*/

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

	public String getColor(){
		return color;
	}

	public ArrayList<Card> getDeck(){
		return deck;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public int getMoveCounter() {
		return moveCounter;
	}

	public Boolean getPlayerLeft() {
		return playerLeft;
	}

	public Boolean getIsInGoal(){
		return isInGoal;
	}

	public ArrayList<Card> getDiscardPile(){
		return discardPile;
	}

	public ArrayList<Card> getPlayedList(){
		return playedList;
	}

	/**
	 * @pre hand.contains(card)
	 * @post (hand.size()@pre == hand.size()+1) && (playedCards.size()@pre = playedCards.size()-1)
	 * @param card the card that is played
	 * (@throws NoSuchElementException If the hand does not contain card)
	 */
	protected void playCard(Card card){ // throws NoSuchElementException
		if (!hand.contains(card)){
			return; // throw new NoSuchElementException("This card is not in the player's hand.");
		}else{ // TODO: multiColorCard has to set its chosen color first in PlayerService before calling playCard!
			card.play();
			playedList.add(card);
			hand.remove(card);
		}
	}

	protected void move(PlayingPiece piece, Integer selectedSpaceID){

	}

	// TODO: precondition not valid yet
	/**
	 * @pre market.openSlot.contains(card) || (market.openSlots.contains(null) && market.closedSlots.contains(card))
	 * @post (coins@pre >= card.buyingCost())
	 * @param card the card that is bought
	 * (@throws NoSuchElementException If the market does not contain card)
	 */
	protected void buyCard(Card card){
		//if (!market.getOpenSlots().contains(card)){}


	}

	/**
	 * @pre hand.contains(card)
	 * @post (hand.size()@pre == hand.size()+1) && (playedCards.size()@pre = playedCards.size()-1) && (coins@pre == coins+card.getGoldValue())
	 * @param card the card that is sold
	 * (@throws NoSuchElementException If the hand does not contain card)
	 */
	protected void sellCard(Card card) { // throws NoSuchElementException
		if (!hand.contains(card)){
			return; // throw new NoSuchElementException("This card is not in the player's hand.");
		}else{
			setCoins(card.getGoldValue());
			playedList.add(card);
			hand.remove(card);
		}
	}

	/**
	 * @pre (!deck.isEmpty()) && (!discardPile.isEmpty())
	 * @post (hand.size()@pre == hand.size()-1) && (deck.size()@pre==deck.size()+1)
	 * (@throws NoSuchElementException If no further card is available to be drawn)
	 */
	protected void drawCard() { // throws NoSuchElementException
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

	// Adds a specific card to the deck
	protected void addCardToDeck(Card card){
		deck.add(card);
	}

	protected void addCardToDiscardPile(Card card){
		discardPile.add(card);
	}

	protected void addCardToPlayingList(Card card){
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

	protected void resetDiscardPile(){
		discardPile.clear();
	}

	protected void setMoveCounter(ArrayList<Integer> movesTaken){

	}

	protected void setCoins(float f){
		coins += f;
	}

	protected void setPlayerLeft(Boolean b){
		playerLeft = b;
	}

	protected void setIsInGoal(Boolean b){
		isInGoal = b;
	}

	// ##############################################################################################################

	/*
	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Move> getMoves() {
		return moves;
	}

	public void setMoves(List<Move> moves) {
		this.moves = moves;
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

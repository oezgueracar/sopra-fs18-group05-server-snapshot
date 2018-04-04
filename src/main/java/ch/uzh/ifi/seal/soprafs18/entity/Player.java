package ch.uzh.ifi.seal.soprafs18.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import ch.uzh.ifi.seal.soprafs18.constant.PlayerStatus;
import com.sun.org.apache.xpath.internal.operations.Bool;

@Entity
public class Player implements Serializable {
	

	private static final long serialVersionUID = 1L;
	private Random randomGenerator;

	@Id
	@GeneratedValue
	protected long id;

	@Column(nullable = false) 
	protected String name;
	
	/*@Column(nullable = false, unique = true)
	private String playerName;*/

	// A unique token for a player
	@Column(nullable = false, unique = true) 
	protected String token;
	
/*
	@Column(nullable = false)
	private PlayerStatus status;
*/

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

    @ManyToMany
    private List<Game> games;
	/*
    @OneToMany(mappedBy="player")
    private List<Move> moves;*/

    // Contains the cards that are in the hand
    @OneToMany(mappedBy = "player")
    protected ArrayList<Card> hand;

    // Contains the cards that are in the deck
    protected ArrayList<Card> deck;

    // Contains the cards in the discardPile
    protected ArrayList<Card> discardPile;

    // Contains the cards that were played in this turn
    protected ArrayList<Card> playedList;

    // Depending on the position in the ArrayList the counter is referring to the color - only one entry can be different from 0
    protected ArrayList<Integer> moveCounter;

	protected PlayingPiece assignedPiece;

	/**
	 * Constructor of the class Player
	 *
	 * @param name	the name of the player
	 * @param token	the unique token of the player
	 */
	public Player(String name, String token) {
		this.name = name;
		this.token = token;
	}

	public Long getId() {
		return id;
	}

	public String getToken(){
		return token;
	}

	public String getName() {
		return name;
	}

	public String getColor(){

	}

	public ArrayList<Card> getDeck(){

	}

	public ArrayList<Card> getHand() {

	}

	public ArrayList<Integer> getMoveCounter() {

	}

	public Boolean getPlayerLeft() {

	}

	public Boolean getIsInGoal(){

	}

	public ArrayList<Card> getDiscardPile(){

	}

	public ArrayList<Card> getPlayedList(){

	}

	protected void setName(String name){
		this.name = name;
	}

	protected void playCard(Card card){

	}

	protected void move(PlayingPiece piece, Integer selectedSpaceID){

	}

	protected void buyCard(Card card){

	}

	/**
	 * @pre hand.contains(card)
	 * @post (hand.size()@pre == hand.size()+1) && (playedCards.size()@pre = playedCards.size()-1) && (coins@pre == coins+card.getGoldValue())
	 * @param card the card that is sold
	 */
	protected float sellCard(Card card){

		setCoins(card.getGoldValue());

	}

	/**
	 * @pre (deck.isEmpty()!=true) && (discardPile.isEmpty()!=true)
	 * @post ((new)hand.size()==(old)hand.size()+1) && ((new)deck.size()==(old)deck.size()-1)
	 */
	protected void drawCard(){
		if(deck.isEmpty()==true){
			if (discardPile.isEmpty() == true){
				return;
			}else {
				deck = new ArrayList<>(discardPile);
				resetDiscardPile();
			}
		}
		randomGenerator = new Random();
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

	protected void setMoveCounter(ArrayList<int> movesTaken){

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

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof Player)) {
			return false;
		}
		Player player = (Player) o;
		return this.getId().equals(player.getId());
	}
	*/
}

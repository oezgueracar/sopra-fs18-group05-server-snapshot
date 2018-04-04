package ch.uzh.ifi.seal.soprafs18.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

	protected void playCard(String cardID){

	}

	protected void move(PlayingPiece piece, Integer selectedSpaceID){

	}

	protected void buyCard(String cardID){

	}

	protected float sellCard(String cardID){

	}

	protected void addCardToHand(String cardID){

	}

	protected void addCardToDeck(String cardID){

	}

	protected void addCardToDiscardPile(String cardID){

	}

	protected void addCardToPlayingList(String cardID){

	}

	protected void removeCardFromHand(String cardID){

	}

	protected void removeCardFromDiscardPile(String cardID){

	}

	protected void removeCardFromDeck(String cardID){

	}

	protected void resetPlayingList(){

	}

	protected void resetDiscardPile(){

	}

	protected void changeMoveCounter(ArrayList<int> movesTaken){

	}

	protected void setCoins(float f){

	}

	protected void setPlayerLeft(Boolean b){

	}

	protected void setIsInGoal(Boolean b){

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

package ch.uzh.ifi.seal.soprafs18.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.*;

import ch.uzh.ifi.seal.soprafs18.constant.GameConstants;
import ch.uzh.ifi.seal.soprafs18.constant.GameStatus;
import ch.uzh.ifi.seal.soprafs18.entity.map.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import static ch.uzh.ifi.seal.soprafs18.constant.GameStatus.*;

@Entity
public class Game implements Serializable {

	private static final long serialVersionUID = 1L;

	public Game(){
		setTurnTime(60);
		players = new ArrayList<>();
		setMapName("HillsOfGold");
		setStatus(ROOM);

		//assert((name != null) && (status == ROOM) && (turnTime == 60) && (mapName.equals("HillsOfGold")));
    }
	
	@Id
	@GeneratedValue
	@Column(name = "gameId")
	private Long id;

	//This is the same as game room name.
	@Column
	private String name;
	
	@Column 
	private GameStatus status;

	//Shows the integer of the player whose current turn it is during a game. The integer of a player is determined according to their position in the List<Player> of the game instance.
	@Column 
	private int currentPlayer;

	//Number of seconds that a player has to end his turn before the turn ends automatically.
	@Column
    private int turnTime;

	@Column
    private String mapName;

	@Lob
	@Column(name = "assignedMap", length = Integer.MAX_VALUE - 1)
	@JsonProperty
    private Map assignedMap;

	@Lob
	@Column(name = "assignedMarket", length = Integer.MAX_VALUE - 1)
	@JsonProperty
    private Market assignedMarket;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="playersGameId", referencedColumnName="gameId")
	private List<Player> players;

    /* Should check if players exist already in db as precondition; should check if players are assigned to correct game id in DB as post
       The added players index should not be able to be 0 or bigger than 4 while adding.
       Post condition should check if the player was added successfully.
       Invariant should check that there is at least always 1 player (the leader) in "players".
    */

    //TODO: How to display to frontend that a new player couldn't be added?
	/**
	 * Adds a new player to an existing game, that is not yet full and is not running.
	 * @param player the new player that is added to the game.
	 * @pre !playerAlreadyInRoom
	 * @post this.getPlayers().contains(player)
	 */
    public void addPlayer(Player player){
    	boolean playerAlreadyInRoom = false;
    	if(this.getPlayers() != null) {
			for (Player p : this.getPlayers()) {
				if (p.getToken().equals(player.getToken())) {
					playerAlreadyInRoom = true;
				}
			}
		}
		if(!playerAlreadyInRoom && this.getPlayers() != null && this.getPlayers().size() < GameConstants.MAX_PLAYERS) {
			this.players.add(player);

			assert(this.getPlayers().contains(player));
		}
    }

    public void castPlayersToPlayer(List<Player> oldPlayers){
    	List<Player> tempPlayers = new ArrayList<>();
    	for (Player p : oldPlayers){
    		Player tempPlayer = new Player();
    		tempPlayer.setId(p.getId());
    		tempPlayer.setType("Player");
    		tempPlayer.setName(p.getName());
    		tempPlayer.setToken(p.getToken());
    		tempPlayer.setColor(p.getColor());
    		tempPlayer.setPlayerLeft(p.getPlayerLeft());
    		tempPlayer.setReady(p.getReady());
    		tempPlayer.resetCoins();
    		//isInGoal is already set to false
    		//Winner is already set to false
			tempPlayer.setGameId(p.getGameId());
			//boughtCardId is already set to 0

			tempPlayers.add(tempPlayer);
		}
		players = tempPlayers;
	}

	//TODO: Important Invariant: Always check if players arraylist size == maxPlayers... you always have to fix it if a player leaves the game or if the amount of players is lower than maxPlayers.
	public void changeCurrentPlayer(){
		this.getPlayers().removeAll(Collections.singleton(null));
		if (this.currentPlayer + 1 == this.getPlayers().size()){
			this.currentPlayer = 0;
		}
		else {
			this.currentPlayer++;
		}
	}

	public boolean endTileIdArrayCheck(long idToBeChecked){
		boolean isTrue = false;
		long[] tempEndTileIdArray = this.assignedMap.getEndTile();

		for(long l : tempEndTileIdArray){
			if(idToBeChecked == l){
				isTrue = true;
			}
		}
		return isTrue;
	}

	private void initializeMap() {
		try{
			this.assignedMap = (Map) Class.forName("ch.uzh.ifi.seal.soprafs18.entity.map." + this.mapName).newInstance();
		}
		catch (ClassNotFoundException e1){
			System.out.println("Class not Found Exception");
		}
		catch (IllegalAccessException e2){
			System.out.println("Illegal Access Exception");
		}
		catch (InstantiationException e3){
			System.out.println("Instantiation Exception");
		}
	}

	/**
	 * Starts the game and initializes the map.
	 */
	public void startGame(){
		initializeMap();
		assignedMarket = new Market();
	}

	public void setName(String name){
		this.name = name;
	}

    public void setStatus(GameStatus status){
        this.status = status;
    }

	public void setTurnTime(Integer turnTime){
		this.turnTime = turnTime;
	}

    public void setMapName(String mapName){
        this.mapName = mapName;
    }
    
	public Long getId(){
		return id;
	}

	public String getName(){
		return name;
	}

	public GameStatus getStatus(){
		return status;
	}

	public int getCurrentPlayer(){
		return currentPlayer;
	}

	public int getTurnTime(){
		return turnTime;
	}

	public String getMapName(){
		return mapName;
	}

	@JsonIgnore
	public Map getMap(){
		if(assignedMap != null) {
			return assignedMap;
		}
		return null;
	}

	@JsonIgnore
	public Market getMarket() {
		if(assignedMarket != null) {
			return assignedMarket;
		}
		return null;
	}

	public List<Player> getPlayers(){
		return players;
	}
}

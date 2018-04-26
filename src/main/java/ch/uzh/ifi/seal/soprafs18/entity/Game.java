package ch.uzh.ifi.seal.soprafs18.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.*;

import ch.uzh.ifi.seal.soprafs18.constant.GameConstants;
import ch.uzh.ifi.seal.soprafs18.constant.GameStatus;
import ch.uzh.ifi.seal.soprafs18.entity.card.ExpeditionCard;
import ch.uzh.ifi.seal.soprafs18.entity.map.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

import static ch.uzh.ifi.seal.soprafs18.constant.GameStatus.*;

@Entity
public class Game implements Serializable {
	
	/**
	 * 
	 */
	//TODO: What the frick is this?
	private static final long serialVersionUID = 1L;

	//TODO: misses eventual setup? Where do we initialize all cards?
    // should check that game is PENDING after it got created in post condition and that all attributes are set correctly
	public Game(){
		setTurnTime(60);
		players = new ArrayList<>();
		setup();

		//assert((name != null) && (status == ROOM) && (turnTime == 60) && (mapName.equals("HillsOfGoldMap")));
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
	// Precondition: players is not null. Player does not exist in players already.
	// Postcondition: Player is added to players.
    public void addPlayer(Player newPlayer){
    	Boolean playerAlreadyInRoom = false;
    	if(this.getPlayers() != null) {
			for (Player p : this.getPlayers()) {
				if (p.getToken().equals(newPlayer.getToken())) {
					playerAlreadyInRoom = true;
				}
			}
		}
		if(!playerAlreadyInRoom && this.getPlayers().size() < GameConstants.MAX_PLAYERS) {
			this.players.add(newPlayer);

			assert(this.getPlayers().contains(newPlayer));
		}
		else {
    		System.out.println("Bad Request. Player is already in room or Max Number of Players reached.");
		}
    }

    public void setStatus(GameStatus newStatus){
        this.status = newStatus;
    }

    public void setMapName(String newMapName){
        this.mapName = newMapName;
    }

    public void setTurnTime(Integer newTurnTime){
        this.turnTime = newTurnTime;
    }

    public void setName(String newName){
        this.name = newName;
    }

    //TODO: Definitely need to test if the tryblock enables overloading so that right map is used. Why does typecasting to abstract class work?
	//TODO: assignedMap is not accepted, cannot resolve what type it is...idky???
    private void initializeMap() {
        try{
            assignedMap = (Map) Class.forName("ch.uzh.ifi.seal.soprafs18.entity.map." + mapName).newInstance();
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

    //TODO: post and pre to check if in right boundary and if it has been changed like planned
    //TODO: Important Invariant: Always check if players arraylist size == maxPlayers... you always have to fix it if a player leaves the game or if the amount of players is lower than maxPlayers.
    public void changeCurrentPlayer(){
    	this.getPlayers().removeAll(Collections.singleton(null));
        if (this.currentPlayer + 1 == this.getPlayers().size()){
            this.currentPlayer = 0;
        }
        else {
            currentPlayer++;
        }
    }

	//Helper function for setting up all associated Objects with game.
	//TODO: assignedMarket type is not known by the compiler idky...
	public void setup(){
        setMapName("HillsOfGoldMap");
		setStatus(ROOM);
	}

	public void startGame(){
    	this.initializeMap();
		assignedMarket = new Market();
	}
    
	public Long getId(){
		return id;
	}

	public List<Player> getPlayers(){
		return players;
	}

	public GameStatus getStatus(){
		return status;
	}

	public String getName(){
		return name;
	}

	public int getTurnTime(){
    	return turnTime;

	}

	public String getMapName(){
    	return mapName;
	}

	//TODO: Bad practice, do we need that.
	/*@Lob
	@Column(name = "assignedMap", length = Integer.MAX_VALUE - 1)
	private byte[] getMap(){
    	return assignedMap;
	}*/

	//TODO: Might not be needed
	public Player getPlayer(Integer index){
    	return players.get(index);
	}

	public long getCurrentPlayer(){
		return currentPlayer;
	}

	private long[] getMapEndTileIdArray (){
		return this.assignedMap.getEntTile();
	}

	public Boolean endTileIdArrayCheck(long idToBeChecked){
		boolean isTrue = false;
		long[] tempEndTileIdArray = getMapEndTileIdArray();

		for(int i = 0; i < tempEndTileIdArray.length; i++){
			if(idToBeChecked == tempEndTileIdArray[i]){
				isTrue = true;
			}
		}
		return isTrue;
	}
}

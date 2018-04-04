package ch.uzh.ifi.seal.soprafs18.entity;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import ch.uzh.ifi.seal.soprafs18.constant.GameStatus;

@Entity
public class Game implements Serializable {
	
	/**
	 * 
	 */
	//TODO: What the frick is this? Delete?
	private static final long serialVersionUID = 1L;

	//TODO: misses eventual setup?
    // should check that game is PENDING after it got created in postcondition and that all attributes are set correctly
	public Game(Player leader, String gn){
        players.add(leader);
	    setLeader (leader);
        setTurnTime (60);
        setName (gn);
        setMaxPlayers (4);
        map = new HillsOfGoldMap();
        currentPlayer = 0;
        setupCards();
    }
	
	@Id
	@GeneratedValue
	private long id;

	//This is the same as game room name set by the leader of the room.
	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String leader;
	
	@Column 
	private GameStatus status;

	//Shows the integer of the player whose current turn it is during a game. The integer of a player is determined according to their position in the List<Player> of the game instance.
	@Column 
	private int currentPlayer;

	@Column
    private int maxPlayers;

	//Number of seconds that a player has to end his turn before the turn ends automatically.
	@Column
    private int turnTime;

	@Column
    private Map map;

	//TODO: delete this after not needed for looking up on how a onetomany relationship works
    @OneToMany(mappedBy="game")
    private List<Move> moves;

    //TODO: how does mapping exactly work? how does manytomany exactly work?
    @ManyToMany(mappedBy="games")
    private ArrayList<Player> players;

    /* Should check if players exist already in db as precondition; should check if players are assigned to correct game id in DB as post
       The added players index should not be able to be 0 or bigger than 4 while adding.
       Postcondition should check if the player was added succesfully.
       Invariant should check that there is at least always 1 player (the leader) in "players".
    */
    private void addPlayer(Player newPlayer){
        this.players.add(newPlayer);
    }

    private void setStatus(GameStatus newStatus){
        this.status = status;
    }

    private void setLeader(Player newLeader){
        this.leader = newLeader;
    }

    //TODO: discuss if that is good practice to change reference
    private void setMap(Map newMap){
        map = newMap;
    }

    private void setTurnTime(Integer newTurnTime){
        this.turnTime = newTurnTime;
    }

    private void setName(String newName){
        this.name = newName;
    }

    //TODO: pre and post check that its not over 4 or under 2 and that it has been set
    //TODO: Do such checks for every setter
    private void setMaxPlayers(Integer newMaxPlayers){
        this.maxPlayers = newMaxPlayers;
    }

    //TODO: post and pre to check if in right boundary and if it has been changed like planned
    //TODO: Important Invariant: Always check if players arraylist size == maxPlayers... you always have to fix it if a player leaves the game or if the amount of players is lower than maxPlayers.
    private void changeCurrentPlayer(){
        if (this.currentPlayer + 1 == this.maxPlayers){
            this.currentPlayer = 0;
        }
        else {
            currentPlayer++;
        }
    }

	//TODO: Should be done after cards class is commited
	private void setupCards(){

	}

    //TODO: not clear on how to do endGame()
    private void endGame(){
        this.status = FINISHED;
    }
    
	public long getId(){
		return id;
	}

	public String getLeader(){
		return leader;
	}

	public ArrayList<Player> getPlayers(){
		return players;
	}

	public GameStatus getStatus(){
		return status;
	}

	public String getName(){
		return name;
	}

	public int getMaxPlayers(){
    	return maxPlayers;
	}

	public int getTurnTime(){
    	return turnTime;
	}

	//TODO: Bad practice, do we need that.
	public Map getMap(){
    	return map;
	}

	//TODO: Might not be needed
	public Player getPlayer(Integer index){
    	return players.get(index);
	}

	public int getCurrentPlayer(){
		return currentPlayer;
	}

}

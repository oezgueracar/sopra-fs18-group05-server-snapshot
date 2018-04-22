package ch.uzh.ifi.seal.soprafs18.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import ch.uzh.ifi.seal.soprafs18.constant.GameStatus;
import ch.uzh.ifi.seal.soprafs18.entity.card.ExpeditionCard;
import ch.uzh.ifi.seal.soprafs18.entity.map.Map;

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
        //players.add(leader);
	    //setLeader(leader);
		setTurnTime(60);
        //setName(gname);
		///setMaxPlayers(4);
		///currentPlayer = 0;
		setup();
    }
	
	@Id
	@GeneratedValue
	@Column(name = "gameId")
	private Long id;

	//This is the same as game room name.
	@Column()
	private String name;

	@Column()
	private Player leader;
	
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
    private String mapName;

    private Map assignedMap;

	/*@Column
    private Market assignedMarket;*/

	//TODO: delete this after not needed for looking up on how a onetomany relationship works
    @OneToMany(mappedBy="game")
    private List<Move> moves;

    //TODO: how does mapping exactly work? how does manytomany exactly work?
    //@ManyToMany(mappedBy="games")

	@OneToMany
	@JoinColumn(name="playersGameId", referencedColumnName="gameId")
	private List<Player> players;

    /* Should check if players exist already in db as precondition; should check if players are assigned to correct game id in DB as post
       The added players index should not be able to be 0 or bigger than 4 while adding.
       Post condition should check if the player was added successfully.
       Invariant should check that there is at least always 1 player (the leader) in "players".
    */
    public void addPlayer(Player newPlayer){
        this.players.add(newPlayer);
    }

    public void setStatus(GameStatus newStatus){
        this.status = newStatus;
    }

    public void setLeader(Player newLeader){
        this.leader = newLeader;
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

    /*//TODO: pre and post check that its not over 4 or under 2 and that it has been set
    //TODO: Do such checks for every setter
    public void setMaxPlayers(Integer newMaxPlayers){
        this.maxPlayers = newMaxPlayers;
    } -> not necessary min and max players in a game is defined in GameConstants and we start the game with the amount of players that are in game at start of the game
*/
    //TODO: Definitely need to test if the tryblock enables overloading so that right map is used. Why does typecasting to abstract class work?
	//TODO: assignedMap is not accepted, cannot resolve what type it is...idky???
    private void initializeMap() {
        try{
            assignedMap = (Map) Class.forName("ch.uzh.ifi.seal.soprafs18.entity." + mapName).newInstance();
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
        if (this.currentPlayer + 1 == this.maxPlayers){
            this.currentPlayer = 0;
        }
        else {
            currentPlayer++;
        }
    }

	//TODO: Should be done after cards class is committed
	private void setupCards(){
        //Fill the deck of each player with the starting cards as stated in the game manual.
        for(Player p : players){
            for(int i = 0; i < 3; i++){
                p.addCardToDeck(new ExpeditionCard(1, 0.5f, "Explorer", "Allows you to move your Playing Piece to a green Space by increasing your Move Counter to \"1\"", "green", 1, false));
            }
            p.addCardToDeck(new ExpeditionCard(1, 0.5f, "Sailor", "Allows you to move your Playing Piece to a blue Space by increasing your Move Counter to \"1\"", "blue", 1, false));
            for(int i = 0; i < 4; i++){
                p.addCardToDeck(new ExpeditionCard(1, 1.0f, "Traveler", "Allows you to move your Playing Piece to a yellow Space by increasing your Move Counter to \"1\"", "yellow", 1, false));
            }
        }
	}

	//Helper function for setting up all associated Objects with game.
	//TODO: assignedMarket type is not known by the compiler idky...
	public void setup(){
        //assignedMarket = new Market();
        setMapName("HillsOfGoldMap");
		setStatus(ROOM);
	}

	public void startGame(){
    	this.initializeMap();
    	//this.setupCards();
    	//this.assignedMarket = new Market();
	}
    
	public Long getId(){
		return id;
	}

	public Player getLeader(){
		return leader;
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

	public int getMaxPlayers(){
    	return maxPlayers;
	}

	public int getTurnTime(){
    	return turnTime;

	}

	public String getMapName(){
    	return mapName;
	}

	//TODO: Bad practice, do we need that.
	/*public Map getMap(){
    	return assignedMap;
	}*/

	//TODO: Might not be needed
	public Player getPlayer(Integer index){
    	return players.get(index);
	}

	public int getCurrentPlayer(){
		return currentPlayer;
	}

}

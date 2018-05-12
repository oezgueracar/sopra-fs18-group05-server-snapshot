package ch.uzh.ifi.seal.soprafs18.web.rest;

import ch.uzh.ifi.seal.soprafs18.Application;
import ch.uzh.ifi.seal.soprafs18.entity.Game;
import ch.uzh.ifi.seal.soprafs18.entity.Player;
import ch.uzh.ifi.seal.soprafs18.service.GameService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = Application.class)
@WebAppConfiguration
//@WebMvcTest(GameResource.class)
@SpringBootTest(classes = Application.class)

public class GameResourceTest {

    String gameJson;
    Player p1;
    String player2Json;
    Player p2;
    Player p3;
    Player p4;
    Player p5;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private GameService gameService;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        System.out.println("---------------------------------------------setup----------------------------------------------");
        ObjectMapper om = new ObjectMapper();
        om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();

        JsonNode game1 = om.createObjectNode();
        JsonNode game2 = om.createObjectNode();
        JsonNode playersNode1 = om.createArrayNode();
        JsonNode playersNode2 = om.createArrayNode();
        JsonNode player1 = om.createObjectNode();
        JsonNode player2 = om.createObjectNode();

        ((ObjectNode) player1).put("name", "p1").put("type", "PlayerMode2");
        ((ObjectNode) player2).put(  "name", "p2").put(  "type", "PlayerMode2");
        ((ArrayNode) playersNode1).add(player1);
        ((ArrayNode) playersNode2).add(player2);
        ((ObjectNode) game1).set("players", playersNode1);
        ((ObjectNode) game2).set("players", playersNode2);

        //A string of a POST request that should be sent to /games
        gameJson = om.writeValueAsString(game1);
        player2Json = om.writeValueAsString(player2);

        p1 = new Player();
        p2 = new Player();
        p3 = new Player();
        p4 = new Player();
        p5 = new Player();
    }

    //If you add a player, then addPlayer() is invoked. This method should not put a player into a game if a player with the same id is already in the game.
    //This test creates a game with a player and tries to add a player with the same id into the created game.
    //Expected result: The player should not be added into the game.
    @Test
    public void addPlayerNoPlayerAllowedTwice() throws Exception {
        System.out.println("-----------------------------------addplayernop--------------------------------------------------------");

        //create Game with a player
        String gameAsJson = mockMvc.perform(post("/games")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gameJson))
                .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();
        System.out.println("-----------------------------------create Game with a player\n--------------------------------------------------------");

        //Get request to the game created above. It must contain only 1 player.
        mockMvc.perform(get("/games/1"))
                .andExpect(status().isOk()).andExpect(content().string("{\"id\":1,\"name\":\"p1's Game\",\"status\":\"ROOM\",\"currentPlayer\":0,\"turnTime\":60,\"mapName\":\"HillsOfGold\",\"assignedMap\":null,\"assignedMarket\":null,\"players\":[{\"type\":\"PlayerMode2\",\"id\":2,\"type\":\"PlayerMode2\",\"name\":\"p1\",\"token\":\"c700d404-9bab-42ce-8688-872ddedc9020\",\"color\":\"red\",\"playerLeft\":false,\"ready\":true,\"coins\":0.0,\"isInGoal\":false,\"winner\":false,\"gameId\":1,\"boughtCardId\":0,\"chosenColor\":null,\"hand\":null,\"deck\":null,\"discardPile\":null,\"playedList\":null,\"blockades\":null,\"moveCounter\":[0,0,0],\"assignedPiece\":null,\"assignedPiece2\":null}]}"));
        System.out.println("-----------------------------------Get request to the game created above. It must contain only 1 player.--------------------------------------------------------");

        //try to add player with same id to the game
        mockMvc.perform(post("/games/1/players")
                .contentType(MediaType.APPLICATION_JSON)
                .content(player2Json))
                .andExpect(status().isCreated());
        System.out.println("-----------------------------------try to add player with same id to the game--------------------------------------------------------");

        //Get request to the game created above. It must contain 2 players.
        mockMvc.perform(get("/games/1"))
                .andExpect(status().isOk()).andExpect(content().string("{\"id\":1,\"name\":\"p1's Game\",\"status\":\"ROOM\",\"currentPlayer\":0,\"turnTime\":60,\"mapName\":\"HillsOfGold\",\"assignedMap\":null,\"assignedMarket\":null,\"players\":[{\"type\":\"PlayerMode2\",\"id\":2,\"type\":\"PlayerMode2\",\"name\":\"p1\",\"token\":\"c700d404-9bab-42ce-8688-872ddedc9020\",\"color\":\"red\",\"playerLeft\":false,\"ready\":true,\"coins\":0.0,\"isInGoal\":false,\"winner\":false,\"gameId\":1,\"boughtCardId\":0,\"chosenColor\":null,\"hand\":null,\"deck\":null,\"discardPile\":null,\"playedList\":null,\"blockades\":null,\"moveCounter\":[0,0,0],\"assignedPiece\":null,\"assignedPiece2\":null},{\"type\":\"PlayerMode2\",\"id\":3,\"type\":\"PlayerMode2\",\"name\":\"p2\",\"token\":\"76812fb1-f55e-4ddf-9bf8-963b4b83d52f\",\"color\":\"blue\",\"playerLeft\":false,\"ready\":false,\"coins\":0.0,\"isInGoal\":false,\"winner\":false,\"gameId\":1,\"boughtCardId\":0,\"chosenColor\":null,\"hand\":null,\"deck\":null,\"discardPile\":null,\"playedList\":null,\"blockades\":null,\"moveCounter\":[0,0,0],\"assignedPiece\":null,\"assignedPiece2\":null}]}"));
        System.out.println("-----------------------------------Get request to the game created above. It must contain 2 players.--------------------------------------------------------");
   }

    @Test
    public void listGames() throws Exception {

        //create Game1 with a player
        String game1AsJson = mockMvc.perform(post("/games")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gameJson))
                .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();
        System.out.println("-----------------------------------create Game1 with a player\n--------------------------------------------------------");

        //create Game with a player
        String game2AsJson = mockMvc.perform(post("/games")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gameJson))
                .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();
        System.out.println("-----------------------------------create Game with a player\n--------------------------------------------------------");


        //Get request to the games created above. Both must contain only 1 player.
        mockMvc.perform(get("/games/1"))
                .andExpect(status().isOk()).andExpect(content().string("{\"id\":1,\"name\":\"p1's Game\",\"status\":\"ROOM\",\"currentPlayer\":0,\"turnTime\":60,\"mapName\":\"HillsOfGold\",\"assignedMap\":null,\"assignedMarket\":null,\"players\":[{\"type\":\"PlayerMode2\",\"id\":2,\"type\":\"PlayerMode2\",\"name\":\"p1\",\"token\":\"c700d404-9bab-42ce-8688-872ddedc9020\",\"color\":\"red\",\"playerLeft\":false,\"ready\":true,\"coins\":0.0,\"isInGoal\":false,\"winner\":false,\"gameId\":1,\"boughtCardId\":0,\"chosenColor\":null,\"hand\":null,\"deck\":null,\"discardPile\":null,\"playedList\":null,\"blockades\":null,\"moveCounter\":[0,0,0],\"assignedPiece\":null,\"assignedPiece2\":null}]}"));
        System.out.println("-----------------------------------Get requests to the game created above. Both must contain only 1 player.--------------------------------------------------------");



    }

    @Test
    public void addGame() {
    }

    @Test
    public void getGame() {
    }

    @Test
    public void addPlayer() {
    }

    @Test
    public void listPlayers() {
    }

    @Test
    public void getPlayer() {
    }

    @Test
    public void updateGame() {
    }

    @Test
    public void updatePlayer() {
    }
}
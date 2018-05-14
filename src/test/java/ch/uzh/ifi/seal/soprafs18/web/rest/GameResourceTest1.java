package ch.uzh.ifi.seal.soprafs18.web.rest;

import ch.uzh.ifi.seal.soprafs18.Application;
import ch.uzh.ifi.seal.soprafs18.entity.Game;
import ch.uzh.ifi.seal.soprafs18.entity.Player;
import ch.uzh.ifi.seal.soprafs18.service.GameService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.After;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = Application.class)
@WebAppConfiguration
//@WebMvcTest(GameResource.class)
@SpringBootTest(classes = Application.class)

public class GameResourceTest1 {

    ObjectMapper om;
    String gameJson;
    String playersJson;
    String gameJson2;
    String gameJsonPutSettings;
    Player p1;
    String player1Json;
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
        om = new ObjectMapper();
        om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();

        JsonNode game1 = om.createObjectNode();
        JsonNode game2 = om.createObjectNode();
        JsonNode gamePutSettings = om.createObjectNode();
        JsonNode playersNode1 = om.createArrayNode();
        JsonNode playersNode2 = om.createArrayNode();
        JsonNode player1 = om.createObjectNode();
        JsonNode player2 = om.createObjectNode();


        /*((ArrayNode) playersNode1).add(player1);
        ((ArrayNode) playersNode2).add(player2);
        ((ObjectNode) game1).set("players", playersNode1);
        ((ObjectNode) game2).set("players", playersNode2);
        ((ObjectNode) gamePutSettings).put("name", "free exp for everyone - enter now").put("status", "ROOM").put("turnTime", 300).put("mapName", "HillsOfGold");
*/
        //A string of a POST request that should be sent to /games

        gameJson2 = om.writeValueAsString(game2);
        gameJsonPutSettings = om.writeValueAsString(gamePutSettings);

        player1Json = om.writeValueAsString(player1);
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
    public void integrationTestSetupAndStartGame() throws Exception {

        //Get request without any games
        mockMvc.perform(get("/games"))
                .andExpect(status().isOk()).andExpect(content().string("[]"));
        System.out.println("got 0 games");

        //create Game with a leader
        String gameAsJson = mockMvc.perform(post("/games")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"players\": [ { \"name\": \"Michinat\", \"type\": \"PlayerMode2\" } ] }"))
                .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();
        System.out.println("created game with leader");

        //Get request to the game created above. It must contain only 1 player.
        mockMvc.perform(get("/games/1"))
                .andExpect(status().isOk()).andExpect(content().string("{\"id\":1,\"name\":\"Michinat's Game\",\"status\":\"ROOM\",\"currentPlayer\":0,\"turnTime\":60,\"mapName\":\"HillsOfGold\",\"assignedMap\":null,\"assignedMarket\":null,\"players\":[{\"type\":\"PlayerMode2\",\"id\":2,\"type\":\"PlayerMode2\",\"name\":\"Michinat\",\"color\":\"red\",\"playerLeft\":false,\"ready\":true,\"coins\":0.0,\"isInGoal\":false,\"winner\":false,\"gameId\":1,\"boughtCardId\":0,\"chosenColor\":null,\"hand\":null,\"deck\":null,\"discardPile\":null,\"playedList\":null,\"blockades\":null,\"moveCounter\":[0,0,0],\"assignedPiece\":null,\"assignedPiece2\":null}]}"));
        System.out.println("got game1 with leader");

        // add player 2 3 and 4
        mockMvc.perform(post("/games/1/players")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"type\": \"PlayerMode2\", \"name\": \"Mikinat\" }"))
                .andExpect(status().isCreated());
        System.out.println("added a second player");

        mockMvc.perform(post("/games/1/players")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"type\": \"PlayerMode2\", \"name\": \"Mikinat\" }"))
                .andExpect(status().isCreated());
        System.out.println("added a third player");

        mockMvc.perform(post("/games/1/players")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"type\": \"PlayerMode2\", \"name\": \"Mikinat\" }"))
                .andExpect(status().isCreated());
        System.out.println("added a fourth player");

        //Get request for players of a specific game
        gameJson = mockMvc.perform(get("/games/1").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();

        //Get request for players
        playersJson = mockMvc.perform(get("/games/1/players").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();

        //Get request for players of a specific game
        mockMvc.perform(get("/games/1/players"))
                .andExpect(status().isOk()).andExpect(content().string(playersJson));
        System.out.println("got players of game1");

        //Get request for one player
        mockMvc.perform(get("/games/1/players/2"))
                .andExpect(status().isOk()).andExpect(content().string("{\"type\":\"PlayerMode2\",\"id\":2,\"type\":\"PlayerMode2\",\"name\":\"Michinat\",\"color\":\"red\",\"playerLeft\":false,\"ready\":true,\"coins\":0.0,\"isInGoal\":false,\"winner\":false,\"gameId\":1,\"boughtCardId\":0,\"chosenColor\":null,\"hand\":null,\"deck\":null,\"discardPile\":null,\"playedList\":null,\"blockades\":null,\"moveCounter\":[0,0,0],\"assignedPiece\":null,\"assignedPiece2\":null}"));
        System.out.println("got player with id 2");

        //put req on game1
        mockMvc.perform(put("/games/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"name\": \"free exp for everyone - enter now\", \"status\": \"ROOM\", \"turnTime\": 300, \"mapName\": \"HillsOfGold\" }"))
                .andExpect(status().isOk()).andExpect(content().string("{\"id\":1,\"name\":\"free exp for everyone - enter now\",\"status\":\"ROOM\",\"currentPlayer\":0,\"turnTime\":300,\"mapName\":\"HillsOfGold\",\"assignedMap\":null,\"assignedMarket\":null,\"players\":[{\"type\":\"PlayerMode2\",\"id\":2,\"type\":\"PlayerMode2\",\"name\":\"Michinat\",\"color\":\"red\",\"playerLeft\":false,\"ready\":true,\"coins\":0.0,\"isInGoal\":false,\"winner\":false,\"gameId\":1,\"boughtCardId\":0,\"chosenColor\":null,\"hand\":null,\"deck\":null,\"discardPile\":null,\"playedList\":null,\"blockades\":null,\"moveCounter\":[0,0,0],\"assignedPiece\":null,\"assignedPiece2\":null},{\"type\":\"PlayerMode2\",\"id\":3,\"type\":\"PlayerMode2\",\"name\":\"Mikinat\",\"color\":\"blue\",\"playerLeft\":false,\"ready\":false,\"coins\":0.0,\"isInGoal\":false,\"winner\":false,\"gameId\":1,\"boughtCardId\":0,\"chosenColor\":null,\"hand\":null,\"deck\":null,\"discardPile\":null,\"playedList\":null,\"blockades\":null,\"moveCounter\":[0,0,0],\"assignedPiece\":null,\"assignedPiece2\":null},{\"type\":\"PlayerMode2\",\"id\":4,\"type\":\"PlayerMode2\",\"name\":\"Mikinat\",\"color\":\"yellow\",\"playerLeft\":false,\"ready\":false,\"coins\":0.0,\"isInGoal\":false,\"winner\":false,\"gameId\":1,\"boughtCardId\":0,\"chosenColor\":null,\"hand\":null,\"deck\":null,\"discardPile\":null,\"playedList\":null,\"blockades\":null,\"moveCounter\":[0,0,0],\"assignedPiece\":null,\"assignedPiece2\":null},{\"type\":\"PlayerMode2\",\"id\":5,\"type\":\"PlayerMode2\",\"name\":\"Mikinat\",\"color\":\"white\",\"playerLeft\":false,\"ready\":false,\"coins\":0.0,\"isInGoal\":false,\"winner\":false,\"gameId\":1,\"boughtCardId\":0,\"chosenColor\":null,\"hand\":null,\"deck\":null,\"discardPile\":null,\"playedList\":null,\"blockades\":null,\"moveCounter\":[0,0,0],\"assignedPiece\":null,\"assignedPiece2\":null}]}"));
        System.out.println("put on game with id 1 to change settings");

        //put on player with id 3-5 to set himself ready
        mockMvc.perform(put("/games/1/players/3")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"type\": \"PlayerMode2\", \"ready\": true, \"color\": \"blue\" }"))
                .andExpect(status().isOk()).andExpect(content().string("{\"type\":\"PlayerMode2\",\"id\":3,\"type\":\"PlayerMode2\",\"name\":\"Mikinat\",\"color\":\"blue\",\"playerLeft\":false,\"ready\":true,\"coins\":0.0,\"isInGoal\":false,\"winner\":false,\"gameId\":1,\"boughtCardId\":0,\"chosenColor\":null,\"hand\":null,\"deck\":null,\"discardPile\":null,\"playedList\":null,\"blockades\":null,\"moveCounter\":[0,0,0],\"assignedPiece\":null,\"assignedPiece2\":null}"));
        mockMvc.perform(put("/games/1/players/4")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"type\": \"PlayerMode2\", \"ready\": true, \"color\": \"blue\" }"))
                .andExpect(status().isOk()).andExpect(content().string("{\"type\":\"PlayerMode2\",\"id\":4,\"type\":\"PlayerMode2\",\"name\":\"Mikinat\",\"color\":\"yellow\",\"playerLeft\":false,\"ready\":true,\"coins\":0.0,\"isInGoal\":false,\"winner\":false,\"gameId\":1,\"boughtCardId\":0,\"chosenColor\":null,\"hand\":null,\"deck\":null,\"discardPile\":null,\"playedList\":null,\"blockades\":null,\"moveCounter\":[0,0,0],\"assignedPiece\":null,\"assignedPiece2\":null}"));
        mockMvc.perform(put("/games/1/players/5")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"type\": \"PlayerMode2\", \"ready\": true, \"color\": \"blue\" }"))
                .andExpect(status().isOk()).andExpect(content().string("{\"type\":\"PlayerMode2\",\"id\":5,\"type\":\"PlayerMode2\",\"name\":\"Mikinat\",\"color\":\"white\",\"playerLeft\":false,\"ready\":true,\"coins\":0.0,\"isInGoal\":false,\"winner\":false,\"gameId\":1,\"boughtCardId\":0,\"chosenColor\":null,\"hand\":null,\"deck\":null,\"discardPile\":null,\"playedList\":null,\"blockades\":null,\"moveCounter\":[0,0,0],\"assignedPiece\":null,\"assignedPiece2\":null}"));
        System.out.println("put on players 3-5 to set ready");

        //put req on game1 to start
        mockMvc.perform(put("/games/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"name\": \"free exp for everyone - enter now\", \"status\": \"PENDING\", \"turnTime\": 120, \"mapName\": \"HillsOfGold\" }"))
                .andExpect(status().isOk());
        System.out.println("game after start");

        //Get request for players of a specific game
        gameJson = mockMvc.perform(get("/games/1").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();

        //Get for the started game
        mockMvc.perform(get("/games/1"))
                .andExpect(status().isOk()).andExpect(content().string(gameJson));
        System.out.println("got running game1");
    }
}
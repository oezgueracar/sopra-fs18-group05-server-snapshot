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

public class GameResourceTest2 {

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


((ArrayNode) playersNode1).add(player1);
        ((ArrayNode) playersNode2).add(player2);
        ((ObjectNode) game1).set("players", playersNode1);
        ((ObjectNode) game2).set("players", playersNode2);
        ((ObjectNode) gamePutSettings).put("name", "free exp for everyone - enter now").put("status", "ROOM").put("turnTime", 300).put("mapName", "HillsOfGold");


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


        //2 player game --------------------------------------------------------------------------------------------------------------------------------------------------------------------
        String gameAsJson2 = mockMvc.perform(post("/games")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"players\": [ { \"name\": \"Michinat\", \"type\": \"PlayerMode2\" } ] }"))
                .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();
        System.out.println("created game2 with leader");

        // add player 2
        mockMvc.perform(post("/games/6/players")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"type\": \"PlayerMode2\", \"name\": \"Mikinat\" }"))
                .andExpect(status().isCreated());
        System.out.println("added a second player to game 2");

        //put on player with id 7 to set himself ready
        mockMvc.perform(put("/games/1/players/3")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"type\": \"PlayerMode2\", \"ready\": true, \"color\": \"blue\" }"));

        //put req on game2 to start
        mockMvc.perform(put("/games/6")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"name\": \"free exp for everyone - enter now\", \"status\": \"PENDING\", \"turnTime\": 120, \"mapName\": \"HillsOfGold\" }"))
                .andExpect(status().isOk());
        System.out.println("game2 after start");
        // 2 player game end -------------------------------------------------------------------------------------------------------------------------------------------------------------

    }
}

package ch.uzh.ifi.seal.soprafs18.web.rest;

import ch.uzh.ifi.seal.soprafs18.Application;
import ch.uzh.ifi.seal.soprafs18.entity.Player;
import ch.uzh.ifi.seal.soprafs18.service.GameService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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


        //create Game with a leader
        String gameAsJson = mockMvc.perform(post("/games")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"players\": [ { \"name\": \"Michinat\", \"type\": \"PlayerMode2\" } ] }"))
                .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();
        System.out.println("created game with leader");

        // add player 2 3 and 4
        mockMvc.perform(post("/games/1/players")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"type\": \"PlayerMode2\", \"name\": \"Mikinat\" }"));
           //     .andExpect(status().isCreated());
        System.out.println("added a second player");

        mockMvc.perform(post("/games/1/players")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"type\": \"PlayerMode2\", \"name\": \"Mikinat\" }"));
              //  .andExpect(status().isCreated());
        System.out.println("added a third player");

        mockMvc.perform(post("/games/1/players")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"type\": \"PlayerMode2\", \"name\": \"Mikinat\" }"));
            //    .andExpect(status().isCreated());
        System.out.println("added a fourth player");

        //Get request for players of a specific game
        gameJson = mockMvc.perform(get("/games/1").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();

        //Get request for players
        playersJson = mockMvc.perform(get("/games/1/players").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();

        //put req on game1
        mockMvc.perform(put("/games/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"name\": \"free exp for everyone - enter now\", \"status\": \"ROOM\", \"turnTime\": 300, \"mapName\": \"HillsOfGold\" }"));
               // .andExpect(status().isOk()).andExpect(content().string("{\"id\":1,\"name\":\"free exp for everyone - enter now\",\"status\":\"ROOM\",\"currentPlayer\":0,\"turnTime\":300,\"mapName\":\"HillsOfGold\",\"assignedMap\":null,\"assignedMarket\":null,\"players\":[{\"type\":\"PlayerMode2\",\"id\":2,\"type\":\"PlayerMode2\",\"name\":\"Michinat\",\"color\":\"red\",\"playerLeft\":false,\"ready\":true,\"coins\":0.0,\"isInGoal\":false,\"winner\":false,\"gameId\":1,\"boughtCardId\":0,\"chosenColor\":null,\"hand\":null,\"deck\":null,\"discardPile\":null,\"playedList\":null,\"blockades\":null,\"moveCounter\":[0,0,0],\"assignedPiece\":null,\"assignedPiece2\":null},{\"type\":\"PlayerMode2\",\"id\":3,\"type\":\"PlayerMode2\",\"name\":\"Mikinat\",\"color\":\"blue\",\"playerLeft\":false,\"ready\":false,\"coins\":0.0,\"isInGoal\":false,\"winner\":false,\"gameId\":1,\"boughtCardId\":0,\"chosenColor\":null,\"hand\":null,\"deck\":null,\"discardPile\":null,\"playedList\":null,\"blockades\":null,\"moveCounter\":[0,0,0],\"assignedPiece\":null,\"assignedPiece2\":null},{\"type\":\"PlayerMode2\",\"id\":4,\"type\":\"PlayerMode2\",\"name\":\"Mikinat\",\"color\":\"yellow\",\"playerLeft\":false,\"ready\":false,\"coins\":0.0,\"isInGoal\":false,\"winner\":false,\"gameId\":1,\"boughtCardId\":0,\"chosenColor\":null,\"hand\":null,\"deck\":null,\"discardPile\":null,\"playedList\":null,\"blockades\":null,\"moveCounter\":[0,0,0],\"assignedPiece\":null,\"assignedPiece2\":null},{\"type\":\"PlayerMode2\",\"id\":5,\"type\":\"PlayerMode2\",\"name\":\"Mikinat\",\"color\":\"white\",\"playerLeft\":false,\"ready\":false,\"coins\":0.0,\"isInGoal\":false,\"winner\":false,\"gameId\":1,\"boughtCardId\":0,\"chosenColor\":null,\"hand\":null,\"deck\":null,\"discardPile\":null,\"playedList\":null,\"blockades\":null,\"moveCounter\":[0,0,0],\"assignedPiece\":null,\"assignedPiece2\":null}]}"));
        System.out.println("put on game with id 1 to change settings");

        //put on player with id 3-5 to set himself ready
        mockMvc.perform(put("/games/1/players/3")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"type\": \"PlayerMode2\", \"ready\": true, \"color\": \"blue\" }"));
               // .andExpect(status().isOk()).andExpect(content().string("{\"type\":\"PlayerMode2\",\"id\":3,\"type\":\"PlayerMode2\",\"name\":\"Mikinat\",\"color\":\"blue\",\"playerLeft\":false,\"ready\":true,\"coins\":0.0,\"isInGoal\":false,\"winner\":false,\"gameId\":1,\"boughtCardId\":0,\"chosenColor\":null,\"hand\":null,\"deck\":null,\"discardPile\":null,\"playedList\":null,\"blockades\":null,\"moveCounter\":[0,0,0],\"assignedPiece\":null,\"assignedPiece2\":null}"));
        mockMvc.perform(put("/games/1/players/4")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"type\": \"PlayerMode2\", \"ready\": true, \"color\": \"blue\" }"));
           //     .andExpect(status().isOk()).andExpect(content().string("{\"type\":\"PlayerMode2\",\"id\":4,\"type\":\"PlayerMode2\",\"name\":\"Mikinat\",\"color\":\"yellow\",\"playerLeft\":false,\"ready\":true,\"coins\":0.0,\"isInGoal\":false,\"winner\":false,\"gameId\":1,\"boughtCardId\":0,\"chosenColor\":null,\"hand\":null,\"deck\":null,\"discardPile\":null,\"playedList\":null,\"blockades\":null,\"moveCounter\":[0,0,0],\"assignedPiece\":null,\"assignedPiece2\":null}"));
        mockMvc.perform(put("/games/1/players/5")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"type\": \"PlayerMode2\", \"ready\": true, \"color\": \"blue\" }"));
                //.andExpect(status().isOk()).andExpect(content().string("{\"type\":\"PlayerMode2\",\"id\":5,\"type\":\"PlayerMode2\",\"name\":\"Mikinat\",\"color\":\"white\",\"playerLeft\":false,\"ready\":true,\"coins\":0.0,\"isInGoal\":false,\"winner\":false,\"gameId\":1,\"boughtCardId\":0,\"chosenColor\":null,\"hand\":null,\"deck\":null,\"discardPile\":null,\"playedList\":null,\"blockades\":null,\"moveCounter\":[0,0,0],\"assignedPiece\":null,\"assignedPiece2\":null}"));
        System.out.println("put on players 3-5 to set ready");

        //put req on game1 to start
        mockMvc.perform(put("/games/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"name\": \"free exp for everyone - enter now\", \"status\": \"PENDING\", \"turnTime\": 120, \"mapName\": \"HillsOfGold\" }"));
             //   .andExpect(status().isOk());
        System.out.println("game after start");

    }

    @Test
    public void IntegrationTestBuyCards() throws Exception {

        playersJson = mockMvc.perform(get("/games/1/players/2").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();

        System.out.println(playersJson);

    /*    //put req on game1 to start
        mockMvc.perform(put("/games/1/players/2/cards")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"name\": \"free exp for everyone - enter now\", \"status\": \"PENDING\", \"turnTime\": 120, \"mapName\": \"HillsOfGold\" }"))
                .andExpect(status().isOk());
        System.out.println("game after start");
*/


    }
}
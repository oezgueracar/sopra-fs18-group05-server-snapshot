package ch.uzh.ifi.seal.soprafs18.entity.AIntegrationTest;

import ch.uzh.ifi.seal.soprafs18.Application;
import ch.uzh.ifi.seal.soprafs18.entity.Game;
import ch.uzh.ifi.seal.soprafs18.entity.Player;
import ch.uzh.ifi.seal.soprafs18.repository.GameRepository;
import ch.uzh.ifi.seal.soprafs18.repository.PlayerRepository;
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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@WebAppConfiguration
@ActiveProfiles({"dev", "integration"})
//@WebAppConfiguration
//@WebMvcTest(GameResource.class)
@SpringBootTest

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

        //create Game with a leader
        String gameAsJson = mockMvc.perform(post("/games")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"players\": [ { \"name\": \"Michinat\", \"type\": \"PlayerMode2\" } ] }"))
                .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();

        //Get request to the game created above. It must contain only 1 player.
        mockMvc.perform(get("/games/1"))
                .andExpect(status().isOk()).andExpect(content().string("{\"id\":1,\"name\":\"Michinat's Game\",\"status\":\"ROOM\",\"currentPlayer\":0,\"turnTime\":60,\"mapName\":\"HillsOfGold\",\"assignedMap\":null,\"assignedMarket\":null,\"players\":[{\"type\":\"PlayerMode2\",\"id\":2,\"type\":\"PlayerMode2\",\"name\":\"Michinat\",\"color\":\"red\",\"ready\":true,\"coins\":0.0,\"isInGoal\":false,\"winner\":false,\"gameId\":1,\"boughtCardId\":0,\"chosenColor\":null,\"hand\":null,\"deck\":null,\"discardPile\":null,\"playedList\":null,\"blockades\":null,\"moveCounter\":[0,0,0],\"assignedPiece\":null,\"assignedPiece2\":null}],\"fastForward\":false}"));

        // add player 2 3 and 4
        mockMvc.perform(post("/games/1/players")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"name\": \"Mikinat\" , \"type\": \"PlayerMode2\"}"))
                .andExpect(status().isCreated());

        mockMvc.perform(post("/games/1/players")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"name\": \"Mikinat\" , \"type\": \"PlayerMode2\"}"))
                .andExpect(status().isCreated());

        mockMvc.perform(post("/games/1/players")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"name\": \"Mikinat\" , \"type\": \"PlayerMode2\"}"))
                .andExpect(status().isCreated());

        //Get request for players of a specific game
        gameJson = mockMvc.perform(get("/games/1").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();

        //Get request for players
        playersJson = mockMvc.perform(get("/games/1/players").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();

        //Get request for players of a specific game
        mockMvc.perform(get("/games/1/players"))
                .andExpect(status().isOk()).andExpect(content().string(playersJson));

        //Get request for one player
        mockMvc.perform(get("/games/1/players/2"))
                .andExpect(status().isOk()).andExpect(content().string("{\"type\":\"PlayerMode2\",\"id\":2,\"type\":\"PlayerMode2\",\"name\":\"Michinat\",\"color\":\"red\",\"ready\":true,\"coins\":0.0,\"isInGoal\":false,\"winner\":false,\"gameId\":1,\"boughtCardId\":0,\"chosenColor\":null,\"hand\":null,\"deck\":null,\"discardPile\":null,\"playedList\":null,\"blockades\":null,\"moveCounter\":[0,0,0],\"assignedPiece\":null,\"assignedPiece2\":null}"));

        //put req on game1
        mockMvc.perform(put("/games/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"name\": \"free exp for everyone - enter now\", \"status\": \"ROOM\", \"turnTime\": 300, \"mapName\": \"HillsOfGold\" }"))
                .andExpect(status().isOk()).andExpect(content().string("{\"id\":1,\"name\":\"free exp for everyone - enter now\",\"status\":\"ROOM\",\"currentPlayer\":0,\"turnTime\":300,\"mapName\":\"HillsOfGold\",\"assignedMap\":null,\"assignedMarket\":null,\"players\":[{\"type\":\"PlayerMode2\",\"id\":2,\"type\":\"PlayerMode2\",\"name\":\"Michinat\",\"color\":\"red\",\"ready\":true,\"coins\":0.0,\"isInGoal\":false,\"winner\":false,\"gameId\":1,\"boughtCardId\":0,\"chosenColor\":null,\"hand\":null,\"deck\":null,\"discardPile\":null,\"playedList\":null,\"blockades\":null,\"moveCounter\":[0,0,0],\"assignedPiece\":null,\"assignedPiece2\":null},{\"type\":\"PlayerMode2\",\"id\":3,\"type\":\"PlayerMode2\",\"name\":\"Mikinat\",\"color\":\"blue\",\"ready\":false,\"coins\":0.0,\"isInGoal\":false,\"winner\":false,\"gameId\":1,\"boughtCardId\":0,\"chosenColor\":null,\"hand\":null,\"deck\":null,\"discardPile\":null,\"playedList\":null,\"blockades\":null,\"moveCounter\":[0,0,0],\"assignedPiece\":null,\"assignedPiece2\":null},{\"type\":\"PlayerMode2\",\"id\":4,\"type\":\"PlayerMode2\",\"name\":\"Mikinat\",\"color\":\"yellow\",\"ready\":false,\"coins\":0.0,\"isInGoal\":false,\"winner\":false,\"gameId\":1,\"boughtCardId\":0,\"chosenColor\":null,\"hand\":null,\"deck\":null,\"discardPile\":null,\"playedList\":null,\"blockades\":null,\"moveCounter\":[0,0,0],\"assignedPiece\":null,\"assignedPiece2\":null},{\"type\":\"PlayerMode2\",\"id\":5,\"type\":\"PlayerMode2\",\"name\":\"Mikinat\",\"color\":\"white\",\"ready\":false,\"coins\":0.0,\"isInGoal\":false,\"winner\":false,\"gameId\":1,\"boughtCardId\":0,\"chosenColor\":null,\"hand\":null,\"deck\":null,\"discardPile\":null,\"playedList\":null,\"blockades\":null,\"moveCounter\":[0,0,0],\"assignedPiece\":null,\"assignedPiece2\":null}],\"fastForward\":false}"));

        //put on player with id 3-5 to set himself ready
        mockMvc.perform(put("/games/1/players/3")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"type\": \"PlayerMode2\", \"ready\": true, \"color\": \"blue\" }"))
                .andExpect(status().isOk()).andExpect(content().string("{\"type\":\"PlayerMode2\",\"id\":3,\"type\":\"PlayerMode2\",\"name\":\"Mikinat\",\"color\":\"blue\",\"ready\":true,\"coins\":0.0,\"isInGoal\":false,\"winner\":false,\"gameId\":1,\"boughtCardId\":0,\"chosenColor\":null,\"hand\":null,\"deck\":null,\"discardPile\":null,\"playedList\":null,\"blockades\":null,\"moveCounter\":[0,0,0],\"assignedPiece\":null,\"assignedPiece2\":null}"));
        mockMvc.perform(put("/games/1/players/4")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"type\": \"PlayerMode2\", \"ready\": true, \"color\": \"blue\" }"))
                .andExpect(status().isOk()).andExpect(content().string("{\"type\":\"PlayerMode2\",\"id\":4,\"type\":\"PlayerMode2\",\"name\":\"Mikinat\",\"color\":\"yellow\",\"ready\":true,\"coins\":0.0,\"isInGoal\":false,\"winner\":false,\"gameId\":1,\"boughtCardId\":0,\"chosenColor\":null,\"hand\":null,\"deck\":null,\"discardPile\":null,\"playedList\":null,\"blockades\":null,\"moveCounter\":[0,0,0],\"assignedPiece\":null,\"assignedPiece2\":null}"));
        mockMvc.perform(put("/games/1/players/5")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"type\": \"PlayerMode2\", \"ready\": true, \"color\": \"blue\" }"))
                .andExpect(status().isOk()).andExpect(content().string("{\"type\":\"PlayerMode2\",\"id\":5,\"type\":\"PlayerMode2\",\"name\":\"Mikinat\",\"color\":\"white\",\"ready\":true,\"coins\":0.0,\"isInGoal\":false,\"winner\":false,\"gameId\":1,\"boughtCardId\":0,\"chosenColor\":null,\"hand\":null,\"deck\":null,\"discardPile\":null,\"playedList\":null,\"blockades\":null,\"moveCounter\":[0,0,0],\"assignedPiece\":null,\"assignedPiece2\":null}"));

        //put req on game1 to start
        mockMvc.perform(put("/games/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"name\": \"free exp for everyone - enter now\", \"status\": \"PENDING\", \"turnTime\": 120, \"mapName\": \"HillsOfGold\" }"))
                .andExpect(status().isOk());

        //Get request for players of a specific game
        gameJson = mockMvc.perform(get("/games/1").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();

        //Get for the started game
        mockMvc.perform(get("/games/1"))
                .andExpect(status().isOk()).andExpect(content().string(gameJson));

        gameJson = mockMvc.perform(get("/games/1").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();

        String newGameJson = gameJson.replace("\"type\":\"PlayerMode2\",","");

        String c1 =gameJson.substring(8,51);

        int i1 = gameJson.indexOf("\"assignedMap\":");
        int i2 = gameJson.indexOf("\"players");

        String c2 =gameJson.substring(i1,i2);

        String endTurn = gameJson.replace(c1,"").replace(c2,"");

        //put req to end turn
        mockMvc.perform(put("/games/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(endTurn))
                .andExpect(status().isOk());

        gameJson = mockMvc.perform(get("/games/1").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();

/*System.out.println("-------------------------------------buy card---------------------------");

        // buycard ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        String p1Json = mockMvc.perform(get("/games/1/players/2").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
        System.out.println(p1Json);

        int h1 = p1Json.indexOf("boughtCardId\":")+14;
        String help1 = p1Json.substring(0,h1);

        System.out.println(help1);

        int end = p1Json.length();
        int h2 = h1+1;
        int h21 = p1Json.indexOf("\"hand\":[")+8;
        String help2 = p1Json.substring(h2,h21);

        System.out.println("help2"+help2);


        int h3 = p1Json.indexOf("],\"deck\"");
        int h31 = p1Json.indexOf("\"playedList\":[")+14;
        String help3 = p1Json.substring(h3,h31);

        System.out.println("help3"+help3);


        int endhand = h3;
        String hand = p1Json.substring(h21,endhand);

        System.out.println(hand);

        int h4 = h31;
        String help4 = p1Json.substring(h31,end);

        String newPlayer = help1+1+help2+help3+hand+help4;

        System.out.println("new player");
        System.out.println(newPlayer);
        gameJson = mockMvc.perform(get("/games/1").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();

        mockMvc.perform(put("/games/1/players/2/cards")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newPlayer));
                //.andExpect(status().isOk());


        String p1Json2 = mockMvc.perform(get("/games/1/players/2").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
        System.out.println(p1Json2);*/



        //Play cards--------------------------------------------------------------------------------------------------------------------------------------------------------

        String testGame = mockMvc.perform(get("/games/1").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
        System.out.println("testGame");
        System.out.println(testGame);

        //get for test game status--------------------------------------------------------------------------------------------------------------
        mockMvc.perform(get("/games/1/testSetup"))
                .andExpect(status().isOk());

        gameJson = mockMvc.perform(get("/games/1").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
        System.out.println("-------------------test game----"+gameJson);
        String p2 = mockMvc.perform(get("/games/1/players/2").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
        System.out.println(p2);

        // play Pioneer
        mockMvc.perform(put("/games/1/players/2/cards/87")
                .contentType(MediaType.APPLICATION_JSON)
                .content(p2));
               // .andExpect(status().isOk());
        p2 = mockMvc.perform(get("/games/1/players/2").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
        System.out.println(p2);
        // move piece
        p2 = mockMvc.perform(get("/games/1/players/2").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
        String movedPlayer = p2.replace("\"position\":53","\"position\":54");
        mockMvc.perform(put("/games/1/players/2")
                .contentType(MediaType.APPLICATION_JSON)
                .content(movedPlayer));
        //.andExpect(status().isOk());
        p2 = mockMvc.perform(get("/games/1/players/2").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
        // play Journalist
        p2= mockMvc.perform(get("/games/1/players/2").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
        mockMvc.perform(put("/games/1/players/2/cards/88")
                .contentType(MediaType.APPLICATION_JSON)
                .content(p2));
        //.andExpect(status().isOk());
        System.out.println(mockMvc.perform(get("/games/1/players/2").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString());
        // move piece
        p2 = mockMvc.perform(get("/games/1/players/2").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
        movedPlayer = p2.replace("\"position\":54","\"position\":55");
        mockMvc.perform(put("/games/1/players/2")
                .contentType(MediaType.APPLICATION_JSON)
                .content(movedPlayer));
        //.andExpect(status().isOk());
        p2 = mockMvc.perform(get("/games/1/players/2").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
        // play Capitain
        p2= mockMvc.perform(get("/games/1/players/2").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
        mockMvc.perform(put("/games/1/players/2/cards/89")
                .contentType(MediaType.APPLICATION_JSON)
                .content(p2));
        //.andExpect(status().isOk());
        System.out.println(mockMvc.perform(get("/games/1/players/2").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString());
        // move piece
        p2 = mockMvc.perform(get("/games/1/players/2").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
        movedPlayer = p2.replace("\"position\":55","\"position\":62");
        mockMvc.perform(put("/games/1/players/2")
                .contentType(MediaType.APPLICATION_JSON)
                .content(movedPlayer));
        //.andExpect(status().isOk());
        p2 = mockMvc.perform(get("/games/1/players/2").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
        System.out.println("movedPlayer----"+p2);




        //reset game
        mockMvc.perform(get("/games/1/testSetup"))
                .andExpect(status().isOk());
        System.out.println("test game setup----------------------------------------------------------");

/*        // play multicolor
            //set color to green
        int place = p2.indexOf("\"chosenColor\":null,");

        String p22 = p2.replace("\"chosenColor\":null,","\"chosenColor\":\"blue\",");

        System.out.println(p2);
        System.out.println(p22);

        mockMvc.perform(put("/games/1/players/2/cards/90")
                .contentType(MediaType.APPLICATION_JSON)
                .content(p22))
                .andExpect(status().isOk());*/


        //Get request for one player
        p2 = mockMvc.perform(get("/games/1/players/2").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
        System.out.println(p2);




        //create Game with a leader
        String gameAsJson2 = mockMvc.perform(post("/games")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"players\": [ { \"name\": \"Michinat\", \"type\": \"PlayerMode2\" } ] }"))
                .andExpect(status().isCreated()).andReturn().getResponse().getContentAsString();
        System.out.println("created game with leader");

        mockMvc.perform(post("/games/6/players")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"name\": \"Mikinat\" , \"type\": \"PlayerMode2\"}"))
                .andExpect(status().isCreated());
        System.out.println("added a second player");

        mockMvc.perform((get("/games/6")));

        //put on player with id 3-5 to set himself ready
        mockMvc.perform(put("/games/6/players/3")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"type\": \"PlayerMode2\", \"ready\": true, \"color\": \"blue\" }"));

        //put req on game1 to start
        mockMvc.perform(put("/games/6")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"name\": \"free exp for everyone - enter now\", \"status\": \"PENDING\", \"turnTime\": 120, \"mapName\": \"HillsOfGold\" }"))
                .andExpect(status().isOk());


        String ff =  mockMvc.perform(get("/games/6").contentType(MediaType.APPLICATION_JSON)).andReturn().getResponse().getContentAsString();
        //put req on game1 to start
        mockMvc.perform(put("/games/6/fastForward")
                .contentType(MediaType.APPLICATION_JSON)
                .content(ff));


    }




/*    @Test
    public void buyCard() throws Exception{


    }

    @Test
    public void playExpeditionCard() throws Exception{

    }*/
}
package ch.uzh.ifi.seal.soprafs18.web.rest;

import ch.uzh.ifi.seal.soprafs18.entity.Map;
import ch.uzh.ifi.seal.soprafs18.entity.Tile;
import ch.uzh.ifi.seal.soprafs18.repository.MapRepository;
import ch.uzh.ifi.seal.soprafs18.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class MapResource extends GenericResource{

    private final String CONTEXT = "/Map";

    @Autowired
    private MapRepository mapRepo;

    @Autowired
    private MapService mapService;


    //Create a Map
    @RequestMapping(value = CONTEXT, method = RequestMethod.POST)
    @ResponseStatus (HttpStatus.OK)
    public Map createMap(){
        logger.debug("Creating DemoMap");
        return mapService.createMap();
    }


/*
    // Retrieve the Map in form of an ArrayList of Tiles
    @RequestMapping(value = CONTEXT + "/{mapId}", method = RequestMethod.GET)
    @ResponseStatus (HttpStatus.OK)
    public ArrayList<Tile> getMap(@PathVariable Long mapId){
        logger.debug("Map as List of Tiles");
        return mapService.getMap(mapId);
    }
*/

}

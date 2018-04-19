package ch.uzh.ifi.seal.soprafs18.service;


import ch.uzh.ifi.seal.soprafs18.entity.DemoMap;
import ch.uzh.ifi.seal.soprafs18.entity.Map;
import ch.uzh.ifi.seal.soprafs18.entity.Tile;
import ch.uzh.ifi.seal.soprafs18.repository.MapRepository;
import ch.uzh.ifi.seal.soprafs18.web.rest.MapResource;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("mapService")
public class MapService {

    private final MapRepository mapRepository;
    private final String CONTEXT = "/map"; // TODO is it necesary ??
    Logger logger = LoggerFactory.getLogger(MapResource.class);

    // Constructor
    public MapService(MapRepository mapReository){
        this.mapRepository = mapReository;
    }

    //Creating Map
    public Map createMap(){
        Map result = new DemoMap();
        return result;
    }

  /*  //Returning Map
    public ArrayList<Tile> getMap(Long mapID){
        ArrayList<Tile> result = mapRepository.findById(mapID);
        return result;
    }*/

}

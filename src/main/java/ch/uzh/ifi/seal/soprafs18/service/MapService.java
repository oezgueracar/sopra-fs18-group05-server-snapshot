package ch.uzh.ifi.seal.soprafs18.service;


import ch.uzh.ifi.seal.soprafs18.entity.DemoMap;
import ch.uzh.ifi.seal.soprafs18.entity.Map;
import ch.uzh.ifi.seal.soprafs18.entity.Tile;
import ch.uzh.ifi.seal.soprafs18.repository.MapRepository;
import ch.uzh.ifi.seal.soprafs18.web.rest.MapResource;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class MapService {

    private final MapRepository mapRepository;
    Logger logger = LoggerFactory.getLogger(MapResource.class);

    // Constructor
    @Autowired
    public MapService(MapRepository mapRepository){
        this.mapRepository = mapRepository;
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

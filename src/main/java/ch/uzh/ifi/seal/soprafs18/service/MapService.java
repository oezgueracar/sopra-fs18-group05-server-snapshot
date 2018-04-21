package ch.uzh.ifi.seal.soprafs18.service;

import ch.uzh.ifi.seal.soprafs18.entity.HillsOfGoldMap;
import ch.uzh.ifi.seal.soprafs18.entity.Map;
import ch.uzh.ifi.seal.soprafs18.repository.MapRepository;
import ch.uzh.ifi.seal.soprafs18.web.rest.MapResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
    public Map createMap(HillsOfGoldMap map){
        return mapRepository.save(map);
    }

    //Returning Map
    public Map getMap(Long mapID){
        Optional<Map> map = mapRepository.findById(mapID);
        return map.orElse(null);
    }

}

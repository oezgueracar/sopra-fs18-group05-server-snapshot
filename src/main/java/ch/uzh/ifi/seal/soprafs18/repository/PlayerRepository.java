package ch.uzh.ifi.seal.soprafs18.repository;

import ch.uzh.ifi.seal.soprafs18.entity.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("playerRepository")
public interface PlayerRepository extends CrudRepository<Player, Long> {
	Player findByName(String name);
	Player findByPlayerName(String playerName);
	Player findByToken(String token);
}

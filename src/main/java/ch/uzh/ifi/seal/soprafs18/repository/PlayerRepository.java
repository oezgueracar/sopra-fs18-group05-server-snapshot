package ch.uzh.ifi.seal.soprafs18.repository;

import ch.uzh.ifi.seal.soprafs18.entity.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository("playerRepository")
public interface PlayerRepository extends CrudRepository<Player, Long> {
	Optional<Player> findByName(String name);
	Optional<Player> findByToken(String token);
}

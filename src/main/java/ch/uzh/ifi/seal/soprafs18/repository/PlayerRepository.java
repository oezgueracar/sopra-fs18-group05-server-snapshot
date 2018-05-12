package ch.uzh.ifi.seal.soprafs18.repository;

import ch.uzh.ifi.seal.soprafs18.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository("playerRepository")
public interface PlayerRepository extends JpaRepository<Player, Long> {
	Optional<Player> findByName(String playerName);
}

package kodak.cinemaapp.repositories;

import kodak.cinemaapp.entities.Showing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowingRepository extends JpaRepository<Showing, Integer> {
}

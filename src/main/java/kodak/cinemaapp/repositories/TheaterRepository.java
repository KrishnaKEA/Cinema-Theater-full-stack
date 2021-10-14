package kodak.cinemaapp.repositories;

import kodak.cinemaapp.entities.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {
}

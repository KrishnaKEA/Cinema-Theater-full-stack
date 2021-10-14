package kodak.cinemaapp.repositories;

import kodak.cinemaapp.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}

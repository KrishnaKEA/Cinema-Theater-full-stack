package kodak.cinemaapp.repositories;

import kodak.cinemaapp.entities.Showing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowingRepository extends JpaRepository<Showing, Integer> {
    List<Showing> findShowingsByMovieTitle(String movie);
    List<Showing> findShowingsByMovieAgeGroup(String ageGroup);
    List<Showing> findShowingsBySlotEquals(String slot);
}

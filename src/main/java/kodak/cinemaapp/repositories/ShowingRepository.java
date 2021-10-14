package kodak.cinemaapp.repositories;

import kodak.cinemaapp.entities.Showing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowingRepository extends JpaRepository<Showing, Integer> {
    List<Showing> findShowingsByMovieTitle(String movie);
    List<Showing> findShowingsByMovieAgeGroup(String ageGroup);
    List<Showing> findShowingsBySlotEquals(String slot);
}

package kodak.cinemaapp.repositories;

import kodak.cinemaapp.entities.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Integer> {
    List<Theater> findTheaterByName(String name);
    List<Theater> findTheaterByLocation(String location);
    List<Theater> findTheaterByNameAndLocation(String name, String location);
    List<Theater> findTheaterByNrOfHalls(int nrOfHalls);
    List<Theater> findTheaterByNameAndLocationAndNrOfHalls(String name, String location, int nrOfHalls);
}

package kodak.cinemaapp.repo;

import kodak.cinemaapp.entities.MovieTheater;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieTheaterRepository extends CrudRepository<MovieTheater,Integer> {
}

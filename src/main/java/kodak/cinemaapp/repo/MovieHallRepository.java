package kodak.cinemaapp.repo;

import kodak.cinemaapp.entities.MovieHall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MovieHallRepository extends CrudRepository<MovieHall,Integer> {

}

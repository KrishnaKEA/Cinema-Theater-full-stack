package kodak.cinemaapp.repo;

import kodak.cinemaapp.entities.MovieHall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieHallRepository extends CrudRepository<MovieHall,Integer> {

     public MovieHall findMovieHallById(int id);
     MovieHall findMovieHallByHallName(char hallName);
}

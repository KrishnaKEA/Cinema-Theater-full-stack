package kodak.cinemaapp.repo;

import kodak.cinemaapp.entities.MovieHall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
<<<<<<< HEAD
@Repository
public interface MovieHallRepository extends CrudRepository<MovieHall,Integer> {

=======

import java.util.List;

@Repository
public interface MovieHallRepository extends CrudRepository<MovieHall,Integer> {

     public MovieHall findMovieHallById(int id);
     MovieHall findMovieHallByHallName(char hallName);
>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed
}

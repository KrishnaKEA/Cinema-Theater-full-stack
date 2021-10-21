package kodak.cinemaapp.repositories;

import kodak.cinemaapp.entities.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepository extends CrudRepository<Movie,Integer> {


}
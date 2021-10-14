package kodak.cinemaapp.repositories;

import kodak.cinemaapp.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findMoviesByTitle(String title);
    List<Movie> findMoviesByAgeGroup(String ageGroup);
    List<Movie> findMoviesByCast(String cast);
    List<Movie> findMoviesByDescription(String description);
//    List<Movie> findMoviesByTitleAndCast(String title, String cast);
//    List<Movie> findMoviesByCastAndDescription(String cast, String description);
//    List<Movie> findMoviesByTitleAndAgeGroup(String title, String ageGroup);
//    List<Movie> findMoviesByTitleAndDescription(String title, String description);
//    List<Movie> findMoviesByCastAndAgeGroup(String cast, String ageGroup);
//    List<Movie> findMoviesByDescriptionAndAgeGroup(String description, String ageGroup);
//    List<Movie> findMoviesByTitleAndAgeGroupAndCast(String title, String ageGroup, String cast);
//    List<Movie> findMoviesByTitleAndAgeGroupAndDescription(String title, String ageGroup, String description);
//    List<Movie> findMoviesByTitleAndCastAndDescription(String title, String cast, String description);
//    List<Movie> findMoviesByAgeGroupAndCastAndDescription(String ageGroup, String cast, String description);
//    List<Movie> findMoviesByTitleAndAgeGroupAndCastandDescription(String title, String ageGroup, String cast, String description);

}

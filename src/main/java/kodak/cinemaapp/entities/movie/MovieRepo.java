package kodak.cinemaapp.entities.movie;

import kodak.cinemaapp.DTOs.MovieDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepo extends JpaRepository<Movie, Long> {
    
    Iterable<Movie> findMovieByStoryAndActor(String story, String actor);

    Iterable<Movie> findMovieByStory(String story);
}

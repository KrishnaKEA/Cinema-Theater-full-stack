package kodak.cinemaapp.entities.movie;

import kodak.cinemaapp.DTOs.MovieDTO;
import kodak.cinemaapp.exception.MovieNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepo movieRepo;

    public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    public List<MovieDTO> getMovies(String story, String actor) {
        if (story != null && actor != null) {
            return MovieDTO.movieToMovieDTO(movieRepo.findMovieByStoryAndActor(story, actor));
        }
        if (story != null) {
            return MovieDTO.movieToMovieDTO(movieRepo.findMovieByStory(story));
        }
        return MovieDTO.movieToMovieDTO(movieRepo.findAll());
    }

    public MovieDTO addMovie(MovieDTO newMovie) throws MovieNotFoundException {
        Movie movieToShow = MovieDTO.movieDtoToMovie(newMovie);
        return new MovieDTO(movieRepo.save(movieToShow));
    }



    public MovieDTO getMovie(Long id) {
        Movie movie = movieRepo.findById(id).orElseThrow();
        return new MovieDTO(movie);
    }

    public MovieDTO editMovie(MovieDTO movieToEdit, Long id) {
        Movie movie = movieRepo.findById(id).orElseThrow();

        movie.setStory(movieToEdit.getStory());
        movie.setActor(movieToEdit.getActor());
        movie.setRating(movieToEdit.getRating());

        return new MovieDTO(movieRepo.save(movie));
    }

    public void deleteMovie(Long id) {
        movieRepo.deleteById(id);
    }

}



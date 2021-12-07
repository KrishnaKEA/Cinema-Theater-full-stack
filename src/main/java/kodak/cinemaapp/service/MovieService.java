package kodak.cinemaapp.service;

import kodak.cinemaapp.dtos.MovieDTO;
import kodak.cinemaapp.entities.Movie;
import kodak.cinemaapp.repo.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepo;

    public MovieService(MovieRepository movieRepo) {
        this.movieRepo = movieRepo;
    }


    public Movie saveMovie(Movie movie){ return movieRepo.save(movie); }

    public List<MovieDTO> getMovies(){
        Iterable<Movie> movies = movieRepo.findAll();
        return MovieDTO.movieToMovieDTO(movies);
    }

    public List<MovieDTO> getMovieById(int movieId){
        return MovieDTO.movieToMovieDTO(movieRepo.findMovieById(movieId));
    }

}
package kodak.cinemaapp.service;

import kodak.cinemaapp.DTO.MovieDTO;
import kodak.cinemaapp.entities.Movie;
import kodak.cinemaapp.repo.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public List<MovieDTO> getAllMovies(){
        return MovieDTO.movieDTOSFromMovie(movieRepository.findAll());
    }
     public MovieDTO getMovie(int id){
        Movie movie = movieRepository.findById(id);
        return new MovieDTO(movie);
     }
           public MovieDTO getMovie(String title){
              Movie movie1 = (Movie) movieRepository.findMovieByTitle(title);
              return new MovieDTO(movie1);
           }

    public MovieDTO addMovie(MovieDTO movieToAdd){
          Movie movieToadd = MovieDTO.movieFromMovieDTO(movieToAdd);
          return new MovieDTO(movieRepository.save(movieToadd)) ;
    }

    public MovieDTO editMovie(MovieDTO movieToEdit,int id){
        Movie movieOriginal = movieRepository.findById(id);
        movieOriginal.setTitle(movieToEdit.getTitle());
        movieOriginal.setAgeGroup(movieToEdit.getAgeGroup());
        movieOriginal.setActor(movieToEdit.getActor());
        movieOriginal.setDescription(movieToEdit.getDescription());
        movieOriginal.setRating(movieToEdit.getRating());
        return new MovieDTO(movieRepository.save(movieOriginal));
    }
       public void deleteMovie(int id) {
        movieRepository.deleteById(id);
       }
}

package kodak.cinemaapp.service;

<<<<<<< HEAD
import kodak.cinemaapp.DTO.MovieDTO;
import kodak.cinemaapp.entities.Movie;
import kodak.cinemaapp.repo.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
=======
import kodak.cinemaapp.dtos.MovieDTO;
import kodak.cinemaapp.entities.Movie;
import kodak.cinemaapp.repo.MovieRepository;
>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
<<<<<<< HEAD
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
=======

    private final MovieRepository movieRepo;

    public MovieService(MovieRepository movieRepo) {
        this.movieRepo = movieRepo;
    }

    public List<MovieDTO> getMovies(){
        Iterable<Movie> members = movieRepo.findAll();
        return MovieDTO.movieToMovieDTO(members);
    }

}
>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed

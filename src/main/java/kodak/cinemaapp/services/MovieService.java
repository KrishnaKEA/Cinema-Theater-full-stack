package kodak.cinemaapp.services;

import kodak.cinemaapp.dtos.MovieDTO;
import kodak.cinemaapp.dtos.TheaterDTO;
import kodak.cinemaapp.entities.Movie;
import kodak.cinemaapp.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDTO> getMovies(String title, String ageGroup, String cast, String description){
        if(title!=null && ageGroup!=null && cast!=null && description!=null){
            return MovieDTO.movieDTOSfromMovie(movieRepository.findMoviesBytitleandage;
        }if(!=null){
            return DTO.DTOSfrom(Repository.find);
        }
        if(!=null){
            return DTO.DTOSfrom(Repository.find);
        } if (){
            return DTO.DTOSfrom(Repository.find);
        }
        return DTO.DTOSfrom(Repository.findAll());
    }

    public MovieDTO getMovie(int id){
        Movie movie = movieRepository.findById(id).orElseThrow();
        return new MovieDTO(movie);
    }

    public MovieDTO addMovie(MovieDTO newMovie){
        Movie movieToAdd = MovieDTO.movieFromMovieDTO(newMovie);
        return new MovieDTO(movieRepository.save(movieToAdd));
    }

    public MovieDTO editMovie(MovieDTO movieToEdit, int id){
        Movie movieOrg = movieRepository.findById(id).orElseThrow();
        movieOrg.setTitle(movieToEdit.getTitle());
        movieOrg.setAgeGroup(movieToEdit.getAgeGroup());
        movieOrg.setCast(movieToEdit.getCast());
        movieOrg.setDescription(movieToEdit.getDescription());
        return new MovieDTO(movieRepository.save(movieOrg));
    }

    public void deleteMovie(int id){
        movieRepository.deleteById(id);
    }
}

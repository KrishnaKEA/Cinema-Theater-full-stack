package kodak.cinemaapp.service;

import kodak.cinemaapp.entities.MovieHall;
import kodak.cinemaapp.repo.MovieHallRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieHallService {

    MovieHallRepository movieHallRepository;

    public MovieHallService(MovieHallRepository movieHallRepository){
        this.movieHallRepository = movieHallRepository;
    }

    public MovieHall findMovieHallByName(char hallName){
        return movieHallRepository.findMovieHallByHallName(hallName);
    }

}

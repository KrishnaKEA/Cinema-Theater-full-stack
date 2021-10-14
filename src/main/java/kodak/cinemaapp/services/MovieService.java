package kodak.cinemaapp.services;

import kodak.cinemaapp.repositories.MovieRepository;

public class MovieService {

    MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
}

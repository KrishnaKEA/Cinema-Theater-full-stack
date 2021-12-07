package kodak.cinemaapp.rest;

import kodak.cinemaapp.dtos.MovieDTO;
import kodak.cinemaapp.entities.Movie;
import kodak.cinemaapp.entities.User;
import kodak.cinemaapp.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping
    public List<MovieDTO> getMovies(){
       return service.getMovies();
    }

    @GetMapping("/{movieId}")
    public List<MovieDTO> getMovieById(@PathVariable int movieId){
        return service.getMovieById(movieId);
    }

    @PostMapping("/addmovie")
    public Movie addMovie(@RequestBody Movie movie){
        return service.saveMovie(movie);
    }

}

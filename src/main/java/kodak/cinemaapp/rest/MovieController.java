package kodak.cinemaapp.rest;

<<<<<<< HEAD
import kodak.cinemaapp.DTO.MovieDTO;
import kodak.cinemaapp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
=======
import kodak.cinemaapp.dtos.MovieDTO;
import kodak.cinemaapp.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed

import java.util.List;

@RestController
<<<<<<< HEAD
@RequestMapping("api/movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping
    List<MovieDTO> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    MovieDTO getMovie(@PathVariable("id") int id) {
        return movieService.getMovie(id);
    }

    @PostMapping()
    MovieDTO addMovie(@RequestBody MovieDTO movietoAdd) {
        return movieService.addMovie(movietoAdd);

    }

    @PutMapping("/{id}")
    MovieDTO movieDTO(@RequestBody MovieDTO movieToEdit, @PathVariable int id) {
        return movieService.editMovie(movieToEdit, id);
    }

    @DeleteMapping("/{id}")
    void deletCar(@PathVariable("id") int id) {
        movieService.deleteMovie(id);
    }


=======
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping
    public List<MovieDTO> getMovies(){
       return service.getMovies();
    }

>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed
}

package kodak.cinemaapp.rest;

import kodak.cinemaapp.DTO.MovieDTO;
import kodak.cinemaapp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping
    List<MovieDTO> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    MovieDTO getMovie(@PathVariable int id) {
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
    void deletCar(@PathVariable int id) {
        movieService.deleteMovie(id);
    }


}

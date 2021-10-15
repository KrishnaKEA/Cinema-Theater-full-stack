package kodak.cinemaapp.rest;

import kodak.cinemaapp.dtos.HallDTO;
import kodak.cinemaapp.dtos.MovieDTO;
import kodak.cinemaapp.services.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    List<MovieDTO> getHalls(@RequestParam(required = false) String name,@RequestParam(required = false) String ageGroup,@RequestParam(required = false) String cast,@RequestParam(required = false) String description){
        if (name==null && ageGroup==null && cast==null && description==null){
            throw new IllegalStateException();
        }
        return movieService.getMovies(name, ageGroup, cast, description);
    }

    @GetMapping("/{id}")
    MovieDTO getMovie(@PathVariable int id){
        return movieService.getMovie(id);
    }

    @PostMapping
    MovieDTO addHall(@RequestBody MovieDTO newMovie){
        return movieService.addMovie(newMovie);
    }

    @PutMapping("/{id}")
    MovieDTO editHall(@RequestBody MovieDTO movieToEdit, @PathVariable int id) throws Exception{
        return movieService.editMovie(movieToEdit, id);
    }

    @DeleteMapping("/{id}")
    void deleteMovie(@PathVariable int id){
        movieService.deleteMovie(id);
    }



}

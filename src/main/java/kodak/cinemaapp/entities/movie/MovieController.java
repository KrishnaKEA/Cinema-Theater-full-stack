package kodak.cinemaapp.entities.movie;

import kodak.cinemaapp.DTOs.MovieDTO;
import kodak.cinemaapp.exception.MovieNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping("")
    List<MovieDTO> getMovies(@RequestParam(required = false) String story, @RequestParam(required = false) String actor){
        if(story == null && actor != null){
            //We will eventually handle this better
            throw new IllegalArgumentException("make required when model is supplied");
        }
        return service.getMovies(story, actor);
    }

    @GetMapping("/{id}")
    MovieDTO getMovie(@PathVariable Long id)
    {
        return service.getMovie(id);
    }

    @PostMapping("/new")
    MovieDTO addMovie(@RequestBody MovieDTO newMovie) throws MovieNotFoundException{
        return service.addMovie(newMovie);
    }

//    @PostMapping("/new")
//    List<MovieDTO> addMovies(@RequestBody  List<MovieDTO> newMovies) {
//        return service.addMovies(newMovies);
//    }

    @PutMapping("/update/{id}")
    MovieDTO editMovie(@RequestBody MovieDTO oldMovie,@PathVariable Long id ) throws MovieNotFoundException {
        return service.editMovie(oldMovie,id);
    }

    @DeleteMapping("/delete/{id}")
    void deleteMovie(@PathVariable Long id){
        service.deleteMovie(id);
    }
}

package kodak.cinemaapp.rest;

import kodak.cinemaapp.entities.MovieHall;
import kodak.cinemaapp.service.MovieHallService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/hall")
public class HallController {

    MovieHallService movieHallService;

    public HallController(MovieHallService movieHallService){
        this.movieHallService = movieHallService;
    }

    @GetMapping("/{hallName}")
    public MovieHall findHallByName(@PathVariable char hallName){
        return movieHallService.findMovieHallByName(hallName);
    }

}

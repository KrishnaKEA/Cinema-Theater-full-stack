package kodak.cinemaapp.rest;

import kodak.cinemaapp.services.MovieService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/movies")
public class MovieController {

    MovieService movieService;

}

package kodak.cinemaapp.rest;

import kodak.cinemaapp.services.TheaterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/theaters")
public class TheaterController {

    TheaterService theaterService;

}

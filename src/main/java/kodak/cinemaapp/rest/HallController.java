package kodak.cinemaapp.rest;

import kodak.cinemaapp.services.HallService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/halls")
public class HallController {

    HallService hallService;

}

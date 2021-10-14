package kodak.cinemaapp.rest;

import kodak.cinemaapp.services.ScheduleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/schedule")
public class ScheduleController {

    ScheduleService scheduleService;

}

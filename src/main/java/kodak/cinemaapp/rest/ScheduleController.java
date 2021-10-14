package kodak.cinemaapp.rest;

import kodak.cinemaapp.dtos.MovieDTO;
import kodak.cinemaapp.dtos.ScheduleDTO;
import kodak.cinemaapp.entities.Schedule;
import kodak.cinemaapp.service.MovieService;
import kodak.cinemaapp.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    @Autowired
    ScheduleService service;

    @GetMapping
    public List<ScheduleDTO> getSchedules(){
        return service.getAllSchedule();
    }

    /*@GetMapping("/{date}")
    public List<Schedule> getSchedulesOnDate(@PathVariable LocalDate date){
        return service.getScheduleOnDate(date);
    }*/


}

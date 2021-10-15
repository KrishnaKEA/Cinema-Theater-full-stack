package kodak.cinemaapp.rest;

import kodak.cinemaapp.dtos.ScheduleDTO;
import kodak.cinemaapp.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
        return service.getAllSchedules();
    }


    //Schedule for a specific date
    @GetMapping("/{date}")
    public List<ScheduleDTO> getSchedulesByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){

        return service.getAllSchedulesByDate(date);
    }

    //Schedule for today (checks current date)
    @GetMapping("/today")
    public List<ScheduleDTO> getSchedulesForToday(){
        return service.getAllSchedulesForToday();
    }

    //Schedule for next 7 days with start date "today"
    @GetMapping("/week")
    public List<ScheduleDTO> getSchedulesForAWeek(){
        return service.getAllSchedulesForAWeek();
    }

    //Any start day / + number of days
    @GetMapping("/{startDate}/{days}")
    public List<ScheduleDTO> getSchedulesV2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate, @PathVariable Integer days){
        return service.getAllSchedulesByAnyInterval(startDate, days);
    }




}

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

    @GetMapping("/{date}")
    public List<ScheduleDTO> getSchedulesByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){

        return service.getAllSchedulesByDate(date);
    }
    @GetMapping("/today")
    public List<ScheduleDTO> getSchedulesForToday(){
        return service.getAllSchedulesForToday();
    }

    @GetMapping("/week")
    public List<ScheduleDTO> getSchedulesForAWeek(){
        return service.getAllSchedulesForAWeek();
    }

    @GetMapping("/{startDate}/{days}")
    public List<ScheduleDTO> getSchedulesV2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate, Integer days){

        return service.getAllSchedulesV2(startDate, days);
    }




}

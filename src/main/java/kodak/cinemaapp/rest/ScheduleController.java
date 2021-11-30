package kodak.cinemaapp.rest;

import kodak.cinemaapp.dtos.ScheduleDTO;
import kodak.cinemaapp.entities.Schedule;
import kodak.cinemaapp.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    @Autowired
    ScheduleService service;

    @GetMapping
    public List<ScheduleDTO> getSchedules(){
        return service.getAllSchedules();
    }


    @GetMapping("/findbyid/{scheduleId}")
    public ScheduleDTO getScheduleById(@PathVariable int scheduleId){

        return service.findScheduleById(scheduleId);

        }

    //Schedule for a specific date
    @GetMapping("/{date}")
    public List<ScheduleDTO> getSchedulesByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){

        return service.getAllSchedulesByDate(date);
    }

    //Schedule for a specific date/time slot Name / Hall Name
    @GetMapping("/{date}/{slot}/{hallName}")
    public List<ScheduleDTO> getSchedulesByDateSlotHallName(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, @PathVariable String slot, @PathVariable char hallName){

        return service.getAllSchedulesByDateSlotNameHallName(date,slot,hallName);
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

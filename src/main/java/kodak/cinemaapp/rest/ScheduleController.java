package kodak.cinemaapp.rest;

<<<<<<< HEAD
import kodak.cinemaapp.DTO.ScheduleDTO;
import kodak.cinemaapp.repo.ScheduleRepository;
import kodak.cinemaapp.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    @GetMapping
    List<ScheduleDTO> getSchedules() {
        return scheduleService.getAllSchedule();
    }

    @GetMapping("/{id},/{date}")
    ScheduleDTO getScheduleforHall(@PathVariable("id") int id, @PathVariable("date") LocalDate date) {
        return scheduleService.getScheduleByDateAndHall(id, date);
    }

    @GetMapping("/{hallID}")
    List<ScheduleDTO> getScheduleForHallId(@PathVariable("hallID") int hallId) {
        return scheduleService.showScheduleforHallId(hallId);
    }

    @PostMapping
    ScheduleDTO addSchedule(@RequestBody ScheduleDTO scDto) {
        return scheduleService.addMovie(scDto);
    }

    @PutMapping("/{id}")
    ScheduleDTO editSchedule(@RequestBody ScheduleDTO scdDto, @PathVariable("id") int id) {
        return scheduleService.editSchedule(scdDto, id);
    }

    @DeleteMapping("/{id}")
    void deleteSchedule(@PathVariable("id") int id) {
        scheduleService.deleteSchedule(id);
    }

=======
import kodak.cinemaapp.dtos.ScheduleDTO;
import kodak.cinemaapp.entities.Schedule;
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


    @GetMapping("/findbyid/{scheduleId}")
    public Schedule getScheduleById(@PathVariable int scheduleId){
        System.out.println("text" +service.findScheduleById(scheduleId).getMovieHall().getId());
        return service.findScheduleById(scheduleId);

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




>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed
}

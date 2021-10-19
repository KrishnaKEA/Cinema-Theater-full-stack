package kodak.cinemaapp.rest;

import kodak.cinemaapp.dtos.HallDTO;
import kodak.cinemaapp.dtos.ScheduleDTO;
import kodak.cinemaapp.entities.Hall;
import kodak.cinemaapp.services.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/schedules")
public class ScheduleController {

    ScheduleService scheduleService;

    @GetMapping
    List<ScheduleDTO> getSchedules(@RequestParam(required = false) LocalDate date, @RequestParam(required = false)Hall hall){
        if (date==null && hall==null){
            throw new IllegalStateException();
        }
        return scheduleService.getSchedules(date, hall);
    }

    @GetMapping("/{id}")
    ScheduleDTO getSchedule(@PathVariable int id){
        return scheduleService.getSchedule(id);
    }

    @PostMapping
    ScheduleDTO addSchedule(@RequestBody ScheduleDTO newSchedule){
        return scheduleService.addSchedule(newSchedule);
    }

    @PutMapping("/{id}")
    ScheduleDTO editSchedule(@RequestBody ScheduleDTO scheduleToEdit, @PathVariable int id) throws Exception{
        return scheduleService.editSchedule(scheduleToEdit, id);
    }

    @DeleteMapping("/{id}")
    void deleteSchedule(@PathVariable int id){
        scheduleService.deleteSchedule(id);
    }



}

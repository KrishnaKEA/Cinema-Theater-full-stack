package kodak.cinemaapp.rest;

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

}

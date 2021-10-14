package kodak.cinemaapp.service;

import kodak.cinemaapp.dtos.ScheduleDTO;
import kodak.cinemaapp.entities.Schedule;
import kodak.cinemaapp.repo.MovieRepository;
import kodak.cinemaapp.repo.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepo) {
        this.scheduleRepository = scheduleRepo;
    }


    public List<ScheduleDTO> getAllSchedules() {
        return ScheduleDTO.scheduleDTOSFromSchedule(scheduleRepository.findAll());
    }

    public List<ScheduleDTO> getAllSchedulesByDate(LocalDate date) {
        return ScheduleDTO.scheduleDTOSFromSchedule(scheduleRepository.findScheduleByDate(date));
    }

    public List<ScheduleDTO> getAllSchedulesForToday() {
        return ScheduleDTO.scheduleDTOSFromSchedule(scheduleRepository.findScheduleByDate(LocalDate.now()));
    }

    public List<ScheduleDTO> getAllSchedulesForAWeek() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(7);

        return ScheduleDTO.scheduleDTOSFromSchedule(scheduleRepository.findScheduleByDateBetween(startDate, endDate));
    }



    /*public List<Schedule> getSchedules() {
        List<Schedule> schedules = new ArrayList<>();
        scheduleRepo.findAll().forEach(schedule1 -> schedules.add(schedule1));
        return schedules;
    }*/



}

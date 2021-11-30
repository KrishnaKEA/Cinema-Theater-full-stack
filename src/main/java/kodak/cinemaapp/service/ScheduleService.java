package kodak.cinemaapp.service;

import kodak.cinemaapp.dtos.ScheduleDTO;
import kodak.cinemaapp.entities.Schedule;
import kodak.cinemaapp.repo.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public ScheduleDTO findScheduleById(int scheduleId){
        return scheduleRepository.findScheduleById(scheduleId);
    }


    public List<ScheduleDTO> getAllSchedulesByDate(LocalDate date) {
        return ScheduleDTO.scheduleDTOSFromSchedule(scheduleRepository.findScheduleByDate(date));
    }

    public List<ScheduleDTO> getAllSchedulesByDateSlotNameHallName(LocalDate date, String slot, char hallName) {
        return ScheduleDTO.scheduleDTOSFromSchedule(scheduleRepository.findScheduleByDateAndAndSlot_NameAndMovieHall_HallName(date,slot,hallName));
    }



    public List<ScheduleDTO> getAllSchedulesForToday() {
        return ScheduleDTO.scheduleDTOSFromSchedule(scheduleRepository.findScheduleByDate(LocalDate.now()));
    }

    public List<ScheduleDTO> getAllSchedulesForAWeek() {
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(7);

        return ScheduleDTO.scheduleDTOSFromSchedule(scheduleRepository.findScheduleByDateBetween(startDate, endDate));
    }

    public List<ScheduleDTO> getAllSchedulesByAnyInterval(LocalDate startDate, Integer days) {
        LocalDate endDate = startDate.plusDays(days);

        return ScheduleDTO.scheduleDTOSFromSchedule(scheduleRepository.findScheduleByDateBetween(startDate, endDate));
    }




    /*public List<Schedule> getSchedules() {
        List<Schedule> schedules = new ArrayList<>();
        scheduleRepo.findAll().forEach(schedule1 -> schedules.add(schedule1));
        return schedules;
    }*/



}

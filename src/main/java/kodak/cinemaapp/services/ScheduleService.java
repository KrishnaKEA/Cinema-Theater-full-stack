package kodak.cinemaapp.services;

import kodak.cinemaapp.dtos.ScheduleDTO;
import kodak.cinemaapp.dtos.TheaterDTO;
import kodak.cinemaapp.entities.Schedule;
import kodak.cinemaapp.repositories.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ScheduleService {

    ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<ScheduleDTO> getSchedules(LocalDate date, String hall){
        if(date!=null){
            return ScheduleDTO.scheduleDTOSfromSchedule(scheduleRepository.findScheduleByDate(date));
        }if (hall!=null){
            return ScheduleDTO.scheduleDTOSfromSchedule(scheduleRepository.findScheduleByHall(hall));
        }
        return ScheduleDTO.scheduleDTOSfromSchedule(scheduleRepository.findAll());
    }

    public ScheduleDTO getSchedule(int id){
        Schedule schedule = scheduleRepository.findById(id).orElseThrow();
        return new ScheduleDTO(schedule);
    }

    public ScheduleDTO addSchedule(ScheduleDTO newSchedule){
        Schedule scheduleToAdd = ScheduleDTO.scheduleFromScheduleDTO(newSchedule);
        return new ScheduleDTO(scheduleRepository.save(scheduleToAdd));
    }

    public ScheduleDTO editSchedule(ScheduleDTO scheduleToEdit, int id){
        Schedule scheduleOrg = scheduleRepository.findById(id).orElseThrow();
        scheduleOrg.setDate(scheduleToEdit.getDate());
        return new ScheduleDTO(scheduleRepository.save(scheduleOrg));
    }

    public void deleteSchedule(int id){
        scheduleRepository.deleteById(id);
    }
}

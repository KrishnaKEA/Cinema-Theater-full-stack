package kodak.cinemaapp.service;

import kodak.cinemaapp.DTO.MovieDTO;
import kodak.cinemaapp.DTO.ScheduleDTO;
import kodak.cinemaapp.entities.Movie;
import kodak.cinemaapp.entities.Schedule;
import kodak.cinemaapp.repo.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    public List<ScheduleDTO> getAllSchedule() {
        return ScheduleDTO.scheduleDTOSFromSchedule(scheduleRepository.findAll());
    }

    public ScheduleDTO getSchedule(int id) {
        Schedule sc = scheduleRepository.findById(id).orElseThrow();
        return new ScheduleDTO(sc);
    }

    public ScheduleDTO getScheduleByDateAndHall(int id, LocalDate date) {
        Schedule scDH = scheduleRepository.findByHallIdAndDate(id, date);
        return new ScheduleDTO(scDH);
    }

    public List<ScheduleDTO> showScheduleforHallId(int hallId) {
        return ScheduleDTO.scheduleDTOSFromSchedule(scheduleRepository.findAllByHallId(hallId));
    }

    public ScheduleDTO addMovie(ScheduleDTO scheduletoadd) {
        Schedule addingSchedule = ScheduleDTO.scheduleFromScheduleDTO(scheduletoadd);
        return new ScheduleDTO(scheduleRepository.save(addingSchedule));
    }

    public ScheduleDTO editSchedule(ScheduleDTO scheduletoEdit, int id) {
        Schedule scheduleOri = scheduleRepository.findById(id).orElseThrow();
        scheduleOri.setMovieId(scheduletoEdit.getMovieId());
        scheduleOri.setHallId(scheduletoEdit.getHallId());
        scheduleOri.setSlotId(scheduletoEdit.getSlotId());
        scheduleOri.setDate(scheduletoEdit.getDate());
        return new ScheduleDTO(scheduleRepository.save(scheduleOri));
    }

    public void deleteSchedule(int id) {
        scheduleRepository.findById(id);
    }
}

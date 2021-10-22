package kodak.cinemaapp.service;

<<<<<<< HEAD
import kodak.cinemaapp.DTO.MovieDTO;
import kodak.cinemaapp.DTO.ScheduleDTO;
import kodak.cinemaapp.entities.Movie;
import kodak.cinemaapp.entities.Schedule;
import kodak.cinemaapp.repo.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
=======
import kodak.cinemaapp.dtos.ScheduleDTO;
import kodak.cinemaapp.entities.Schedule;
import kodak.cinemaapp.repo.ScheduleRepository;
>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ScheduleService {
<<<<<<< HEAD
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
        scheduleOri.setMovie_id(scheduletoEdit.getMovieId());
        scheduleOri.setHallId(scheduletoEdit.getHallId());
        scheduleOri.setSlot_id(scheduletoEdit.getSlotId());
        scheduleOri.setDate(scheduletoEdit.getDate());
        return new ScheduleDTO(scheduleRepository.save(scheduleOri));
    }

    public void deleteSchedule(int id) {
        scheduleRepository.findById(id);
    }
=======

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepo) {
        this.scheduleRepository = scheduleRepo;
    }


    public List<ScheduleDTO> getAllSchedules() {
        return ScheduleDTO.scheduleDTOSFromSchedule(scheduleRepository.findAll());
    }

    public Schedule findScheduleById(int scheduleId){
        return scheduleRepository.findScheduleById(scheduleId);
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

    public List<ScheduleDTO> getAllSchedulesByAnyInterval(LocalDate startDate, Integer days) {
        LocalDate endDate = startDate.plusDays(days);

        return ScheduleDTO.scheduleDTOSFromSchedule(scheduleRepository.findScheduleByDateBetween(startDate, endDate));
    }




    /*public List<Schedule> getSchedules() {
        List<Schedule> schedules = new ArrayList<>();
        scheduleRepo.findAll().forEach(schedule1 -> schedules.add(schedule1));
        return schedules;
    }*/



>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed
}

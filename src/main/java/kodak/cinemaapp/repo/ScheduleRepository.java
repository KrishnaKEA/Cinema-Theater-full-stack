package kodak.cinemaapp.repo;

import kodak.cinemaapp.dtos.ScheduleDTO;
import kodak.cinemaapp.entities.Movie;
import kodak.cinemaapp.entities.MovieHall;
import kodak.cinemaapp.entities.Schedule;
import kodak.cinemaapp.entities.Slot;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleRepository extends CrudRepository<Schedule,Integer> {
    List<Schedule> findScheduleByDate(LocalDate date);
    List<Schedule> findScheduleByDateAndAndSlot_NameAndMovieHall_HallName(LocalDate date, String slot, char hallName);
    List<Schedule> findScheduleByDateBetween(LocalDate startDate, LocalDate endDate);
    List<Schedule> findScheduleById(int id);
    Schedule findScheduleByDateAndMovie_TitleAndMovieHall_HallNameAndSlot_Name(LocalDate date, String movie, char hallName, String slot);
    Schedule findScheduleByMovieAndMovieHallAndSlot(Movie movie, MovieHall hall, Slot slot);

}

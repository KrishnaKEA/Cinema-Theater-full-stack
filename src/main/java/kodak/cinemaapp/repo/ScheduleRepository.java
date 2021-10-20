package kodak.cinemaapp.repo;

import kodak.cinemaapp.entities.Movie;
import kodak.cinemaapp.entities.MovieHall;
import kodak.cinemaapp.entities.Schedule;
import kodak.cinemaapp.entities.Slot;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleRepository extends CrudRepository<Schedule,Integer> {
    List<Schedule> findScheduleByDate(LocalDate date);
    List<Schedule> findScheduleByDateBetween(LocalDate startDate, LocalDate endDate);
    Schedule findScheduleById(int id);
    Schedule findScheduleByMovie_TitleAndMovieHall_HallNameAndSlot_Name(String movie, char hallName, String slot);
    Schedule findScheduleByMovieAndMovieHallAndSlot(Movie movie, MovieHall hall, Slot slot);
}

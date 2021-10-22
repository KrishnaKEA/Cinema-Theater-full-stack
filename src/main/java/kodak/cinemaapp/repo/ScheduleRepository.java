package kodak.cinemaapp.repo;

<<<<<<< HEAD
import kodak.cinemaapp.entities.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
=======
import kodak.cinemaapp.entities.Movie;
import kodak.cinemaapp.entities.MovieHall;
import kodak.cinemaapp.entities.Schedule;
import kodak.cinemaapp.entities.Slot;
import org.springframework.data.repository.CrudRepository;
>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed

import java.time.LocalDate;
import java.util.List;

<<<<<<< HEAD
@Repository
public interface ScheduleRepository extends CrudRepository<Schedule,Integer> {
public Schedule findByHallIdAndDate(int id, LocalDate date);
public List<Schedule> findAllByHallId(int hallId);
=======
public interface ScheduleRepository extends CrudRepository<Schedule,Integer> {
    List<Schedule> findScheduleByDate(LocalDate date);
    List<Schedule> findScheduleByDateBetween(LocalDate startDate, LocalDate endDate);
    Schedule findScheduleById(int id);
    Schedule findScheduleByDateAndMovie_TitleAndMovieHall_HallNameAndSlot_Name(LocalDate date, String movie, char hallName, String slot);
    Schedule findScheduleByMovieAndMovieHallAndSlot(Movie movie, MovieHall hall, Slot slot);

>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed
}

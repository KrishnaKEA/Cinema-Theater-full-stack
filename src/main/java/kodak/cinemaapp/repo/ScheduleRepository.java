package kodak.cinemaapp.repo;

import kodak.cinemaapp.entities.Movie;
import kodak.cinemaapp.entities.Schedule;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleRepository extends CrudRepository<Schedule,Integer> {
    List<Schedule> findScheduleByDate(LocalDate date);
    List<Schedule> findScheduleByDateBetween(LocalDate startDate, LocalDate endDate);

}

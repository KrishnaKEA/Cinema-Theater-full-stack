package kodak.cinemaapp.repo;

import kodak.cinemaapp.entities.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule,Integer> {
public Schedule findByHallIdAndDate(int id, LocalDate date);
public List<Schedule> findAllByHallId(int hallId);
}

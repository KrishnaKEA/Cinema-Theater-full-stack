package kodak.cinemaapp.repositories;

import kodak.cinemaapp.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    List<Schedule> findScheduleByDate(LocalDate date);
    List<Schedule> findScheduleByHall(String hall);
}

package kodak.cinemaapp.repositories;

import kodak.cinemaapp.entities.Hall;
import kodak.cinemaapp.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    List<Schedule> findScheduleByDate(LocalDate date);
    List<Schedule> findScheduleByHallId(int id);
}

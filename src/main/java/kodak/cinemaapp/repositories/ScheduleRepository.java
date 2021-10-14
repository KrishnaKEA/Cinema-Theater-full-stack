package kodak.cinemaapp.repositories;

import kodak.cinemaapp.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
}

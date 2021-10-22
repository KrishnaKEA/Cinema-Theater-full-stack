package kodak.cinemaapp.repository;


import kodak.cinemaapp.entities.schedule.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepo extends JpaRepository<Schedule, Long> {

}

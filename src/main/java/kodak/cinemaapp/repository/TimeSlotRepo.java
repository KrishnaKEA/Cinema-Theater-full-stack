package kodak.cinemaapp.repository;


import kodak.cinemaapp.entities.timeslot.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSlotRepo extends JpaRepository<TimeSlot, Long> {

}

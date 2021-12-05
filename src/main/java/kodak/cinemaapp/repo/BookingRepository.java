package kodak.cinemaapp.repo;

import kodak.cinemaapp.entities.BookedSeat;
import kodak.cinemaapp.entities.Booking;
import kodak.cinemaapp.entities.Schedule;
import kodak.cinemaapp.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<Booking,Integer> {
    Booking findBookingByScheduleAndUser(Schedule schedule, User user);
    Booking findBookingById(int id);
}

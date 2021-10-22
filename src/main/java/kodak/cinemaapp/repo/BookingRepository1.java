package kodak.cinemaapp.repo;

//import kodak.cinemaapp.entities.Booking;
import kodak.cinemaapp.entities.Booking1;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository1 extends CrudRepository<Booking1,Integer> {
    List<Booking1> findBooking1sByHallId(int hallid);
    List<Booking1> findBooking1sByDate(LocalDate date);
    List<Booking1> findBooking1sByMovieId(int movieId);
    List<Booking1> findBooking1sBySlotId(int slotId);
    List<Booking1> findBooking1sByHallIdAndMovieId(int hallid,int movieId);

}

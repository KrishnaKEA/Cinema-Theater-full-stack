package kodak.cinemaapp.repo;


import kodak.cinemaapp.entities.BookedSeat;
import kodak.cinemaapp.entities.Booking;
import kodak.cinemaapp.entities.Seat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookedSeatRepository extends CrudRepository<BookedSeat,Integer> {
    BookedSeat findBookedSeatBySeat_Id(int id);
    List<BookedSeat> findBookedSeatByBookingAndSeat(Booking booking, Seat seat);
}

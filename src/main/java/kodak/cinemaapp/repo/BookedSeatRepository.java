package kodak.cinemaapp.repo;


import kodak.cinemaapp.entities.BookedSeat;
import kodak.cinemaapp.entities.Booking;
import kodak.cinemaapp.entities.Seat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookedSeatRepository extends CrudRepository<BookedSeat,Integer> {
    BookedSeat findBookedSeatBySeat_IdAndDateAndTimeSlot(int id, LocalDate date,String timeSlot);
    BookedSeat findBookedSeatBySeat_Id(int id);
    List<BookedSeat> findBookedSeatByBookingAndSeat(Booking booking, Seat seat);
    List<BookedSeat> findAllByDate(LocalDate date);
    List<BookedSeat> findAllByDateAndTimeSlot(LocalDate date,String timeSlot);
    BookedSeat findBookedSeatByBookingId(int id);
}

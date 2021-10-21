package kodak.cinemaapp.DTO;

import kodak.cinemaapp.entities.*;
import kodak.cinemaapp.repo.BookingRepository;
import kodak.cinemaapp.repo.BookingRepository1;
import kodak.cinemaapp.repo.SeatRepository;
import kodak.cinemaapp.service.BookingService1;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingDTO1 {
    @Autowired
 static SeatRepository seatRepository;
    private int bookingId;
    private int userId;
    private int hallId;
    private LocalDate date;
    private int  slotId;
    private int movieId;
    private int seatId;

    public BookingDTO1(int userId, int hallId, LocalDate date, int slotId, int movieId, int seatId) {
        this.userId = userId;
        this.hallId = hallId;
        this.date = date;
        this.slotId = slotId;
        this.movieId = movieId;
        this.seatId = seatId;
    }

    public BookingDTO1(Booking1 booking1) {
        this.bookingId = booking1.getBookingId();
        this.userId = booking1.getUserId();
        this.hallId = booking1.getHallId();
        this.date = booking1.getDate();
        this.slotId = booking1.getSlotId();
        this.movieId = booking1.getMovieId();
        this.seatId = booking1.getSeatId();

    }

    public static List<BookingDTO1> bookingDTOS1FromBooking(Iterable<Booking1> bookings1) {
        List<BookingDTO1> newBookings = new ArrayList<>();
        for (Booking1 booking1 : bookings1) {
            BookingDTO1 bD = new BookingDTO1(booking1);
            newBookings.add(bD);
        }
        return newBookings;
    }



    public static Booking1 booking1FromBookingDTO1(BookingDTO1 bookingDTO1){

        return new Booking1(bookingDTO1.getUserId(),bookingDTO1.getHallId(),bookingDTO1.getDate(),bookingDTO1.getSlotId(),bookingDTO1.getMovieId(),bookingDTO1.getSeatId());}

    @Override
    public String toString() {
        return "HallID:- "+hallId+" Date:- "+date+" SlotId:- "+slotId +" MovieId:-"+movieId+ " Seat Number:- "+ seatId;
    }
}

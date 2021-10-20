package kodak.cinemaapp.DTO;

import kodak.cinemaapp.entities.Booking;
import kodak.cinemaapp.entities.Booking1;
import kodak.cinemaapp.entities.Schedule;
import kodak.cinemaapp.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingDTO1 {
    private int bookingId;
    private int userId;
    private int hallId;
    private LocalDate date;
    private int  slotId;
    private int movieId;
    int seatNumber;

    public BookingDTO1(int userId, int hallId, LocalDate date, int slotId, int movieId, int seatNumber) {
        this.userId = userId;
        this.hallId = hallId;
        this.date = date;
        this.slotId = slotId;
        this.movieId = movieId;
        this.seatNumber = seatNumber;
    }

    public BookingDTO1(Booking1 booking1) {
        this.bookingId = booking1.getBookingId();
        this.userId = booking1.getUserId();
        this.hallId = booking1.getHallId();
        this.date = booking1.getDate();
        this.slotId = booking1.getSlotId();
        this.movieId = booking1.getMovieId();
        this.seatNumber = booking1.getSeatNumber();

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
        return new Booking1(bookingDTO1.getUserId(),bookingDTO1.getHallId(),bookingDTO1.getDate(),bookingDTO1.getSlotId(),bookingDTO1.getMovieId(),bookingDTO1.getSeatNumber());}

    @Override
    public String toString() {
        return ""+hallId+ date +slotId +movieId + seatNumber;
    }
}

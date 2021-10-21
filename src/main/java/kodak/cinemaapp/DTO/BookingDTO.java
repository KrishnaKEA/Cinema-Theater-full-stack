package kodak.cinemaapp.DTO;

import kodak.cinemaapp.entities.Booking;
import kodak.cinemaapp.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingDTO {
    private int bookingId;
    private User user;
    private int seatNumber;

    public BookingDTO(User user) {
        this.user = user;
    }
    // schedule?

    public BookingDTO(Booking booking) {
        this.bookingId = booking.getBookingId();
        this.user = booking.getUser();
    }

    public static List<BookingDTO> bookingDTOSFromBooking(Iterable<Booking> bookings) {
        List<BookingDTO> newBookings = new ArrayList<>();
        for (Booking booking : bookings) {
            BookingDTO bD = new BookingDTO(booking);
            newBookings.add(bD);
        }
        return newBookings;
    }


}
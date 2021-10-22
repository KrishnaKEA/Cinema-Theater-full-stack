

package kodak.cinemaapp.DTO;

import kodak.cinemaapp.entities.Booking;
import kodak.cinemaapp.entities.Schedule;
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
    private Schedule schedule;
    private int seatNumber;

    public BookingDTO(User user, Schedule schedule) {
        this.user = user;
        this.schedule = schedule;
    }

    public BookingDTO(Booking booking) {
        this.bookingId = booking.getBookingId();
        this.user = booking.getUser();
        this.schedule = booking.getSchedule();
    }

    public static List<BookingDTO> bookingDTOSFromBooking(Iterable<Booking> bookings) {
        List<BookingDTO> newBookings = new ArrayList<>();
        for (Booking booking : bookings) {
            BookingDTO bD = new BookingDTO(booking);
            newBookings.add(bD);
        }
        return newBookings;
    }
    public static Booking bookingFromBookingDTO(BookingDTO bookingDTO){
        return new Booking(bookingDTO.getBookingId(),bookingDTO.getUser(),bookingDTO.getSchedule());}

}

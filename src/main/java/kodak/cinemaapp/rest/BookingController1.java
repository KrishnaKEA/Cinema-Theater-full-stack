package kodak.cinemaapp.rest;

import kodak.cinemaapp.DTO.BookingDTO1;
import kodak.cinemaapp.exception.BadRequest;
import kodak.cinemaapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/bookings1")
public class BookingController1 {
    @Autowired
    BookingService1 bookingService1;
    @Autowired
    MovieHallService movieHallService;
    @Autowired
    MovieService movieService;
    @Autowired
    SlotService slotService;
    @Autowired
    UserService userService;
    List<String> bookedSeats = new ArrayList<>();

    @GetMapping
    public List<BookingDTO1> getAllBookings() {
        return bookingService1.getAllBooking();
    }

    @GetMapping("/{id}")
    public BookingDTO1 getBookingfromid(@PathVariable("id") int id) {
        return bookingService1.getBooking(id);
    }

    @GetMapping("/bookedSeats")
    public List<String> getBookedSeats() {
        return bookedSeats;
    }

    @GetMapping("/hallId/{id}")
    public List<BookingDTO1> getBookingByHallId(@PathVariable("id") int id) {
        return bookingService1.getBookingByHallId(id);
    }

    @GetMapping("/hallid/movieId/{hallid}/{movieid}")
    public List<BookingDTO1> getBookingByHallIdAndMovieId(@PathVariable("hallid") int hallid, @PathVariable("movieid") int movieid) {
        return bookingService1.getBookingByHallIdAndMovieId(hallid, movieid);
    }


    @PostMapping
    public BookingDTO1 addBooking(@RequestBody BookingDTO1 bookingDTO1) {

        if (bookingService1.isvacant(bookingDTO1.toString())) {
            String bookingMessage = bookingDTO1.toString();
            bookedSeats.add(bookingMessage);
            return bookingService1.addBoking1(bookingDTO1);

        } else {
            throw new BadRequest("badrequest");
        }

    }

    @PutMapping("/editbooking/{id}")
    BookingDTO1 editBooking(@RequestBody BookingDTO1 bookingDTO1, @PathVariable("id") int id) {
        return bookingService1.editBooking(bookingDTO1, id);
    }

    @DeleteMapping("/cancelbooking/{id}")
    public void CancelBooking(@PathVariable("id") int id) {
        for (int i = 0; i < getAllBookings().size(); i++) {
            if (getAllBookings().get(i).getBookingId() == bookingService1.getBooking(id).getBookingId()) {
                bookingService1.deleteBooking(id);
            }
        }
    }


}

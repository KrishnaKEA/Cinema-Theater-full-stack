package kodak.cinemaapp.rest;

import kodak.cinemaapp.DTO.*;
import kodak.cinemaapp.entities.*;
import kodak.cinemaapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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


    @GetMapping
    public List<BookingDTO1> getAllBookings() {
        return bookingService1.getAllBooking();
    }

    @GetMapping("/{id}")
    public BookingDTO1 getBookingfromid(@PathVariable("id") int id) {
        return bookingService1.getBooking(id);
    }


    @PostMapping
    public BookingDTO1 addBooking(@RequestBody BookingDTO1 bookingDTO1) {
        BookingDTO1 bd1 = new BookingDTO1();
        String uniqueKey = bookingDTO1.toString();
        if (bookingService1.isvacant(uniqueKey)){
            bd1 = bookingService1.addBoking1(bookingDTO1);
            return bd1;
        }else {
           throw new RuntimeException("Seat Taken") ;
        }

    }


}

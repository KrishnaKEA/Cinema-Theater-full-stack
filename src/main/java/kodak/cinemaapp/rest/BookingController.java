package kodak.cinemaapp.rest;

import kodak.cinemaapp.entities.*;
import kodak.cinemaapp.service.BookedSeatService;
import kodak.cinemaapp.service.BookingService;
import kodak.cinemaapp.service.SeatService;
import kodak.cinemaapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    BookingService bookingService;
    UserService userService;
    BookedSeatService bookedSeatService;
    SeatService seatService;

    public BookingController(BookingService bookingService, UserService userService, BookedSeatService bookedSeatService, SeatService seatService) {
        this.bookingService = bookingService;
        this.userService = userService;
        this.bookedSeatService = bookedSeatService;
        this.seatService = seatService;
    }

    @GetMapping("/{movieName}/{hallName}/{slotName}/{userId}/{seatNr}")
    public List<BookedSeat> createBooking(@PathVariable String movieName, @PathVariable char hallName, @PathVariable String slotName,
                                          @PathVariable int userId, @PathVariable int seatNr ) {

        Schedule schedule = bookingService.findScheduleByMovieMovieHallSlot(movieName, hallName, slotName); // later add elsethrow if not found
        System.out.println(schedule.getId());

        User user = userService.findUserById(userId);
        Seat seat = seatService.findSeatBySeatNumberAndHallName(seatNr, hallName);


        // No booking for particular schedule and user && Seat is free for particular Hall that host the show(schedule)
        if (!bookingService.bookingAlreadyExists(schedule, user) && bookedSeatService.isSeatFree(seatNr, hallName)) {

            Booking booking = bookingService.saveBooking(new Booking(user, schedule));
            BookedSeat bookedSeat = bookedSeatService.saveBookedSeat(new BookedSeat(seat, booking));
            System.out.println("New booking created");


        }
        // User already has a booking for this schedule && Seat is free OR booked
        else if (bookingService.bookingAlreadyExists(schedule, user) && !bookedSeatService.isSeatFree(seatNr, hallName) || bookedSeatService.isSeatFree(seatNr, hallName)) {
            System.out.println("This User: " + user.getFName() + " already have a booking for this Schedule ");
        }
        //No booking but Seat is not free
        else if (!bookingService.bookingAlreadyExists(schedule, user) && !bookedSeatService.isSeatFree(seatNr, hallName)) {
            System.out.println("This Seat: " + seatNr + " in Hall: " + hallName + " is already booked");
        }




        return bookedSeatService.findBookedSeatByBookingAndSeat(bookingService.findBookingByScheduleAndUser(schedule,user)
            ,seatService.findSeatBySeatNumberAndHallName(seatNr,hallName));


    }



}



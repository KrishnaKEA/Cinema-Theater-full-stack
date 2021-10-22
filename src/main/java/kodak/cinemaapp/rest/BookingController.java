package kodak.cinemaapp.rest;

import com.fasterxml.jackson.databind.util.ArrayIterator;
import kodak.cinemaapp.dtos.BookedSeatDTO;
import kodak.cinemaapp.entities.*;
import kodak.cinemaapp.service.BookedSeatService;
import kodak.cinemaapp.service.BookingService;
import kodak.cinemaapp.service.SeatService;
import kodak.cinemaapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

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

    @GetMapping("/{date}/{movieName}/{hallName}/{timeSlot}/{userId}/{seatNr}")
    public List<BookedSeatDTO> createBooking(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date , @PathVariable String movieName, @PathVariable char hallName, @PathVariable String timeSlot,
                                          @PathVariable int userId, @PathVariable int seatNr ) {

        Schedule schedule = bookingService.findScheduleByDateMovieMovieHallSlot(date,movieName, hallName, timeSlot); // later add elsethrow if not found

        User user = userService.findUserById(userId);
        Seat seat = seatService.findSeatBySeatNumberAndHallName(seatNr, hallName);


        // No booking for particular schedule and user && Seat is free for particular Hall/date/slot that host the show(schedule)
        if (!bookingService.bookingAlreadyExists(schedule, user) && bookedSeatService.isSeatFree(seatNr, hallName,schedule.getDate(),schedule.getSlot().getName()) ) {

            Booking booking = bookingService.saveBooking(new Booking(user, schedule));
            bookedSeatService.saveBookedSeat(new BookedSeat(schedule.getDate(),schedule.getSlot().getName(), seat, booking));
            System.out.println("New booking created");

        }

        // User already has a booking for this schedule && Seat is free OR booked
        else if (bookingService.bookingAlreadyExists(schedule, user) && !bookedSeatService.isSeatFree(seatNr, hallName,schedule.getDate(),schedule.getSlot().getName()) || bookedSeatService.isSeatFree(seatNr, hallName,schedule.getDate(),schedule.getSlot().getName())) {
            System.out.println("This User: " + user.getFName() + " already have a booking for this Schedule ");
        }
        //No booking but Seat is not free
        else if (!bookingService.bookingAlreadyExists(schedule, user) && !bookedSeatService.isSeatFree(seatNr, hallName,schedule.getDate(),schedule.getSlot().getName())) {
            System.out.println("This Seat: " + seatNr + " in Hall: " + hallName + " is already booked");
        }




        return bookedSeatService.findBookedSeatByBookingAndSeat(bookingService.findBookingByScheduleAndUser(schedule,user)
            ,seatService.findSeatBySeatNumberAndHallName(seatNr,hallName));


    }

    @GetMapping("/bookedseats")
    public Iterable<BookedSeatDTO> findAllBookedSeats(){
        return bookedSeatService.getAllBookedSeats();
    }

    @GetMapping("/bookedseats/{date}")
    public Iterable<BookedSeatDTO> findAllBookedSeatsByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){

        return bookedSeatService.getAllBookedSeatsByDate(date);

    }

    @GetMapping("/bookedseats/{date}/{timeSlot}")
    public Iterable<BookedSeatDTO> findAllBookedSeatsByDateAndTime(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable String timeSlot){

        return bookedSeatService.getAllBookedSeatsByDateAndTime(date,timeSlot);

    }

    @GetMapping("/freeseats/{date}/{hallName}/{timeSlot}")
    public Iterable<Seat> findAllSeats_Free(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,@PathVariable char hallName,@PathVariable String timeSlot){

       List<Seat> onlyFreeSeats = new ArrayList<>();

        Iterable<Seat> allSeats = seatService.getAllSeatsByHallName(hallName);
        for(Seat s: allSeats){
            if(bookedSeatService.findBookedSeatBySeat_IdAndDateAndSlot(s.getId(),date,timeSlot) == null)
                onlyFreeSeats.add(s);

        }

        return onlyFreeSeats;
    }


}



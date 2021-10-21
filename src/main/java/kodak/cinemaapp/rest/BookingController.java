package kodak.cinemaapp.rest;

import kodak.cinemaapp.DTO.*;
import kodak.cinemaapp.entities.*;
import kodak.cinemaapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
   @Autowired
    BookingService bookingService;
   @Autowired
   MovieHallService movieHallService;
   @Autowired
    MovieService movieService;
   @Autowired
    SlotService slotService;
   @Autowired
    UserService userService;





    @GetMapping
   public List<BookingDTO> getAllBookings(){
       return bookingService.getAllBooking();
   }
   @GetMapping("/{id}")
    public BookingDTO getBookingfromid(@PathVariable("id") int id){
        return bookingService.getBooking(id);
   }


/*

   @PostMapping("/{id}/{date}/{hallId}/{movieId}/{slotId}/{seat}")
    public BookingDTO addBooking(@PathVariable("id") int id, @PathVariable("date") LocalDate date,@PathVariable("hallId") int hallId,@PathVariable("movieId") int movieId,@PathVariable("slotId") int slotId,@PathVariable("seat") int seat){
       Booking b = new Booking();

        if(bookingService.isvacant(id,date,hallId,movieId,slotId,seat)){
            User u = UserDTO.userFromUserDTO(userService.getUser(id));
            Movie m = MovieDTO.movieFromMovieDTO(movieService.getMovie(movieId));
            //MovieHall mh = MovieHallDTO.movieHallFromMovieHallDTO(movieHallService.getMoviehallDto(id));
            Slot s = SlotDTO.slotFromSlotDTO(slotService.getSlot(id));
            Schedule schedule = new Schedule(date,mh,m,s);
            b.setSchedule(schedule);
            b.setUser(u);
            b.setSeatNumber(seat);
        }
       return new BookingDTO(b);
   }
*/

}

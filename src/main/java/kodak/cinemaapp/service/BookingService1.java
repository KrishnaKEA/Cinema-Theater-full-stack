package kodak.cinemaapp.service;

import kodak.cinemaapp.DTO.BookingDTO1;
import kodak.cinemaapp.entities.Booking;
import kodak.cinemaapp.entities.Booking1;
import kodak.cinemaapp.repo.BookingRepository1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService1 {
    @Autowired
    BookingRepository1 bookingRepository1;
    @Autowired
    MovieHallService movieHallService;

    public List<BookingDTO1> getAllBooking(){
        return BookingDTO1.bookingDTOS1FromBooking(bookingRepository1.findAll());
    }
    public BookingDTO1 getBooking(int id){
        Booking1 booking1 = bookingRepository1.findById(id).orElseThrow();
        return new BookingDTO1(booking1);
    }
    public BookingDTO1 addBoking1(BookingDTO1 bookingToAdd){
        Booking1 booTobeAdded = BookingDTO1.booking1FromBookingDTO1(bookingToAdd);
        return new BookingDTO1 (bookingRepository1.save(booTobeAdded));
    }
    public BookingDTO1 editBooking(BookingDTO1 bookintToEdit,int id){
        Booking1 bookingOriginal1 = bookingRepository1.findById(id).orElseThrow();
        bookingOriginal1.setBookingId(bookintToEdit.getBookingId());
        bookingOriginal1.setUserId(bookintToEdit.getUserId());
        bookingOriginal1.setDate(bookintToEdit.getDate());
        bookingOriginal1.setHallId(bookintToEdit.getHallId());
        bookingOriginal1.setMovieId(bookintToEdit.getMovieId());
        bookingOriginal1.setSlotId(bookintToEdit.getSlotId());
        bookingOriginal1.setSeatNumber(bookintToEdit.getSeatNumber());
        return new BookingDTO1(bookingRepository1.save(bookingOriginal1));
    }
  public boolean isvacant(String uniqueKey){
        boolean isavailable = true;
        List<BookingDTO1> allBooking = getAllBooking();
        for(int i= 0;i<allBooking.size();i++){
            String unique = allBooking.get(i).toString();

            if (unique.equals(uniqueKey)){

                isavailable = false;
            }
        }
      return isavailable;


  }

}

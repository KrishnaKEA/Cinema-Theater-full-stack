package kodak.cinemaapp.service;

import kodak.cinemaapp.DTO.BookingDTO1;
import kodak.cinemaapp.entities.Booking;
import kodak.cinemaapp.entities.Booking1;
import kodak.cinemaapp.repo.BookingRepository1;
import kodak.cinemaapp.repo.SeatRepository;
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
    @Autowired
    SeatRepository seatRepository;

    public List<BookingDTO1> getAllBooking(){
        return BookingDTO1.bookingDTOS1FromBooking(bookingRepository1.findAll());
    }
    public BookingDTO1 getBooking(int id){
        Booking1 booking1 = bookingRepository1.findById(id).orElseThrow();
        return new BookingDTO1(booking1);
    }
    public BookingDTO1 addBoking1(BookingDTO1 bookingToAdd) {
        Booking1 booTobeAdded = BookingDTO1.booking1FromBookingDTO1(bookingToAdd);
        return new BookingDTO1(bookingRepository1.save(booTobeAdded));
    }
    public List<BookingDTO1> getBookingByHallId(int id){
        return BookingDTO1.bookingDTOS1FromBooking(bookingRepository1.findBooking1sByHallId(id));
    }
    public List<BookingDTO1> getBookingByHallIdAndMovieId(int hallid,int movieId){
        return BookingDTO1.bookingDTOS1FromBooking(bookingRepository1.findBooking1sByHallIdAndMovieId(hallid,movieId));
    }



    public BookingDTO1 editBooking(BookingDTO1 bookintToEdit,int id){
        Booking1 bookingOriginal1 = bookingRepository1.findById(id).orElseThrow();
        bookingOriginal1.setBookingId(bookintToEdit.getBookingId());
        bookingOriginal1.setUserId(bookintToEdit.getUserId());
        bookingOriginal1.setDate(bookintToEdit.getDate());
        bookingOriginal1.setHallId(bookintToEdit.getHallId());
        bookingOriginal1.setMovieId(bookintToEdit.getMovieId());
        bookingOriginal1.setSlotId(bookintToEdit.getSlotId());
       bookingOriginal1.setSeatId(bookintToEdit.getSeatId());
        return new BookingDTO1(bookingRepository1.save(bookingOriginal1));
    }
  public boolean isvacant(String uniqueKey) {
      List<BookingDTO1> allBooking = getAllBooking();
      boolean isavailable = true;
      for (int i = 0; i < allBooking.size(); i++) {

          String unique = allBooking.get(i).toString();


          if (unique.equals(uniqueKey)) {

              isavailable = false;
          }
      }

          return isavailable;
      }}





 /*

        for(int i= 0;i<allBooking.size();i++){
            System.out.println(bookingDTO1.getSeatId()+"----"+allBooking.get(i).getSeatId());
           if(allBooking.get(i).getMovieId()==bookingDTO1.getMovieId()&&allBooking.get(i).getHallId()==bookingDTO1.getHallId()&&allBooking.get(i).getSlotId()==bookingDTO1.getSlotId()&&allBooking.get(i).getDate()==bookingDTO1.getDate()&&allBooking.get(i).getSeatId()==bookingDTO1.getSeatId()){
               isavailable = true;
           }else{
               isavailable = false;
           }
        }



 /*

            String unique = allBooking.get(i).toString();

            if (unique.equals(uniqueKey)){

                isavailable = false;
            }
        }
      return isavailable;

*/
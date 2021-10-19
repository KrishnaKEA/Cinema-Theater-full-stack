package kodak.cinemaapp.service;

import kodak.cinemaapp.DTO.BookingDTO;
import kodak.cinemaapp.DTO.MovieDTO;
import kodak.cinemaapp.entities.Booking;
import kodak.cinemaapp.entities.Movie;
import kodak.cinemaapp.repo.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    MovieHallService movieHallService;

    public List<BookingDTO> getAllBooking(){
        return BookingDTO.bookingDTOSFromBooking(bookingRepository.findAll());
    }
    public BookingDTO getBooking(int id){
        Booking booking = bookingRepository.findById(id).orElseThrow();
        return new BookingDTO(booking);
    }
    public BookingDTO addBooking(BookingDTO bookingToAdd){
        Booking booTobeAdded = BookingDTO.bookingFromBookingDTO(bookingToAdd);
        return new BookingDTO (bookingRepository.save(booTobeAdded));
    }
    public BookingDTO editBooking(BookingDTO bookintToEdit,int id){
        Booking BookingOriginal = bookingRepository.findById(id).orElseThrow();
        BookingOriginal.setBookingId(bookintToEdit.getBookingId());
        BookingOriginal.setUser(bookintToEdit.getUser());
        BookingOriginal.setSchedule(bookintToEdit.getSchedule());
        return new BookingDTO(bookingRepository.save(BookingOriginal));
    }
  public boolean isvacant(int id,LocalDate date,int hallid,int movieid,int slotid,int seat){

        boolean isavailable = true;
        List<BookingDTO> allBooking = getAllBooking();
        for(int i= 0;i<=allBooking.size();i++){
            if (allBooking.get(i).getSchedule().getDate() == date && allBooking.get(i).getSchedule().getHallId()==hallid && allBooking.get(i).getSchedule().getMovie().getId()==movieid && allBooking.get(i).getSchedule().getSlot_id()==slotid && movieHallService.bookedseat.contains(seat) ){
                isavailable = false;
            }
        }
      return isavailable;


  }

}

package kodak.cinemaapp.service;

import kodak.cinemaapp.dtos.BookedSeatDTO;
import kodak.cinemaapp.entities.BookedSeat;
import kodak.cinemaapp.entities.Booking;
import kodak.cinemaapp.entities.Schedule;
import kodak.cinemaapp.entities.Seat;
import kodak.cinemaapp.repo.BookedSeatRepository;
import kodak.cinemaapp.repo.BookingRepository;
import kodak.cinemaapp.repo.ScheduleRepository;
import kodak.cinemaapp.repo.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookedSeatService {

    BookedSeatRepository bookedSeatRepository;
    SeatRepository seatRepository;
    ScheduleRepository scheduleRepository;
    BookingRepository bookingRepository;

    public BookedSeatService( BookingRepository bookingRepository, ScheduleRepository scheduleRepository, BookedSeatRepository bookedSeatRepository, SeatRepository seatRepository) {
        this.bookedSeatRepository = bookedSeatRepository;
        this.seatRepository = seatRepository;
        this.scheduleRepository = scheduleRepository;
        this.bookingRepository = bookingRepository;
    }


    public boolean isSeatFree(int seatNr, char hallName, LocalDate date,String timeSlot){

        Seat seat = seatRepository.findSeatBySeatNumberAndMovieHall_HallName(seatNr, hallName);
        bookedSeatRepository.findBookedSeatBySeat_IdAndDateAndTimeSlot(seat.getId(),date,timeSlot);

        if(bookedSeatRepository.findBookedSeatBySeat_IdAndDateAndTimeSlot(seat.getId(),date,timeSlot)==null){
            return true;
        }
        return false;
    }



    //DTO
    public Iterable<BookedSeatDTO> getAllBookedSeats(){
        return BookedSeatDTO.bookedSeatDTOSFromBookedSeat(bookedSeatRepository.findAll()) ;
    }

    //Normal entity
   /* public Iterable<BookedSeat> getAllBookedSeats() {
        return bookedSeatRepository.findAll();
    }*/


    public List<BookedSeatDTO> findBookedSeatByBookingAndSeat(Booking booking,Seat seat){
        return BookedSeatDTO.bookedSeatDTOSFromBookedSeat(bookedSeatRepository.findBookedSeatByBookingAndSeat(booking,seat));
    }

    public BookedSeat saveBookedSeat(BookedSeat bookedSeat){
        return bookedSeatRepository.save(bookedSeat);
    }

    // check this later
    public BookedSeat findBookedSeatBySeat_IdAndDateAndSlot(int id,LocalDate date,String timeSlot){
        return bookedSeatRepository.findBookedSeatBySeat_IdAndDateAndTimeSlot(id, date,timeSlot);
    }


    public Iterable<BookedSeatDTO> getAllBookedSeatsByDate(LocalDate date){
        return BookedSeatDTO.bookedSeatDTOSFromBookedSeat(bookedSeatRepository.findAllByDate(date));
    }
    public Iterable<BookedSeatDTO> getAllBookedSeatsByDateAndTime(LocalDate date,String timeSlot){
        return BookedSeatDTO.bookedSeatDTOSFromBookedSeat(bookedSeatRepository.findAllByDateAndTimeSlot(date,timeSlot));
    }
}

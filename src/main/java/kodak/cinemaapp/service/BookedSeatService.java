package kodak.cinemaapp.service;

import kodak.cinemaapp.entities.BookedSeat;
import kodak.cinemaapp.entities.Booking;
import kodak.cinemaapp.entities.Seat;
import kodak.cinemaapp.repo.BookedSeatRepository;
import kodak.cinemaapp.repo.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookedSeatService {

    BookedSeatRepository bookedSeatRepository;
    SeatRepository seatRepository;

    public BookedSeatService(BookedSeatRepository bookedSeatRepository, SeatRepository seatRepository) {
        this.bookedSeatRepository = bookedSeatRepository;
        this.seatRepository = seatRepository;
    }


    public boolean isSeatFree(int seatNr, char hallName){

        Seat seat = seatRepository.findSeatBySeatNumberAndMovieHall_HallName(seatNr, hallName);
        bookedSeatRepository.findBookedSeatBySeat_Id(seat.getId());

        if(bookedSeatRepository.findBookedSeatBySeat_Id(seat.getId())==null){
            return true;
        }
        return false;
    }


    public List<BookedSeat> findBookedSeatByBookingAndSeat(Booking booking,Seat seat){
        return bookedSeatRepository.findBookedSeatByBookingAndSeat(booking,seat);
    }

    public BookedSeat saveBookedSeat(BookedSeat bookedSeat){
        return bookedSeatRepository.save(bookedSeat);
    }
}

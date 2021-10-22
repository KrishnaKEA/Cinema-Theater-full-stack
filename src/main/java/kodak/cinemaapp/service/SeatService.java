package kodak.cinemaapp.service;

import kodak.cinemaapp.entities.MovieHall;
import kodak.cinemaapp.entities.Seat;
import kodak.cinemaapp.repo.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;


    public void createSeats(MovieHall movieHall){
        for(int i=1;i<=movieHall.getSeatCount();i++){
            seatRepository.save(new Seat(i,movieHall));
        }
    }


    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public Iterable<Seat> getAllSeatsByHallName(char hallName) {
        return seatRepository.findAllByMovieHall_HallName(hallName);
    }

    public Seat findSeatBySeatNumberAndHallName(int seatNr, char hallName){
        return seatRepository.findSeatBySeatNumberAndMovieHall_HallName(seatNr, hallName);
    }
}

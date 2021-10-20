package kodak.cinemaapp.service;

import kodak.cinemaapp.entities.Seat;
import kodak.cinemaapp.repo.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public Iterable<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public Seat findSeatBySeatNumberAndHallName(int seatNr, char hallName){
        return seatRepository.findSeatBySeatNumberAndMovieHall_HallName(seatNr, hallName);
    }
}

package kodak.cinemaapp.repo;


import kodak.cinemaapp.entities.MovieHall;
import kodak.cinemaapp.entities.Seat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends CrudRepository<Seat,Integer> {
    List<Seat> findSeatsByMovieHallId(int id);
    Seat findSeatBySeatNumberAndMovieHall_HallName(int seatNr, char hallName);
    List <Seat> findAllByMovieHall_HallName(char hallName);


}

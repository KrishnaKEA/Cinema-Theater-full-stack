package kodak.cinemaapp.repo;

<<<<<<< HEAD
import kodak.cinemaapp.entities.Seat;
import org.springframework.data.repository.CrudRepository;

public interface SeatRepository extends CrudRepository<Seat,Integer> {
=======

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


>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed
}

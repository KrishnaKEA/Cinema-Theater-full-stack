package kodak.cinemaapp.repo;

import kodak.cinemaapp.entities.Seat;
import org.springframework.data.repository.CrudRepository;

public interface SeatRepository extends CrudRepository<Seat,Integer> {
}

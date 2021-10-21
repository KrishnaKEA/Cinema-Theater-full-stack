package kodak.cinemaapp.repositories;

import kodak.cinemaapp.entities.Booking;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Booking,Integer> {
}
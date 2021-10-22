package kodak.cinemaapp.repository;


import kodak.cinemaapp.entities.hall.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallRepo extends JpaRepository<Hall, Long> {
}

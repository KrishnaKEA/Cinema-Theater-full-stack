package kodak.cinemaapp.repositories;

import kodak.cinemaapp.entities.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HallRepository extends JpaRepository<Hall, Integer> {
    List<Hall> findHallByName(String name);
    List<Hall> findAll();

}

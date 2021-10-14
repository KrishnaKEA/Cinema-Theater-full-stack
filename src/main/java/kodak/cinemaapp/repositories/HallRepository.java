package kodak.cinemaapp.repositories;

import kodak.cinemaapp.entities.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HallRepository extends JpaRepository<Hall, Integer> {
    List<Hall> findHallByName(String name);
    List<Hall> findAll();
    List<Hall> findHallsBySeatsX(int seatsX);
    List<Hall> findHallsBySeatsY(int seatsY);
    List<Hall> findHallByNameAndSeatsX(String name, int seatsX);
    List<Hall> findHallByNameAndSeatsY(String name, int seatsY);
    List<Hall> findHallByNameAndSeatsXAndSeatsY(String name, int seatsX, int seatsY);


}

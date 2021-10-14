package kodak.cinemaapp.repositories;

import kodak.cinemaapp.entities.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HallRepository extends JpaRepository<Hall, Integer> {
    List<Hall> findHallByName(String name);
    List<Hall> findAll();
    List<Hall> findHallsBySeatsX(int seatsX);
    List<Hall> findHallsBySeatsY(int seatsY);
    List<Hall> findHallByNameAndSeatsXAndSeatsY(String name, int seatsX, int seatsY);


}

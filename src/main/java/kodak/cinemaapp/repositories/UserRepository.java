package kodak.cinemaapp.repositories;

import kodak.cinemaapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findUsersByName(String name);
    List<User> findUsersByAge(int age);
    List<User> findUsersByEmail(String email);
}

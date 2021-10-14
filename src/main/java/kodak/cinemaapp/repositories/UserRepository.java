package kodak.cinemaapp.repositories;

import kodak.cinemaapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findUsersByName(String name);
    List<User> findUsersByAge(int age);
    List<User> findUsersByEmail(String email);
}

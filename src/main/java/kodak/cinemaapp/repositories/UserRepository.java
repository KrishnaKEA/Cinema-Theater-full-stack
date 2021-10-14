package kodak.cinemaapp.repositories;

import kodak.cinemaapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

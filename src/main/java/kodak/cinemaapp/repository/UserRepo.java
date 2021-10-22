package kodak.cinemaapp.repository;


import kodak.cinemaapp.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}

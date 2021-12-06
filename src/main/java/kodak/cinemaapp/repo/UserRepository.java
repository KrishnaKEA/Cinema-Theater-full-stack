package kodak.cinemaapp.repo;

import kodak.cinemaapp.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    User findUserById(int id);
    User save(User user);
    User findUserByEmail(String email);

}



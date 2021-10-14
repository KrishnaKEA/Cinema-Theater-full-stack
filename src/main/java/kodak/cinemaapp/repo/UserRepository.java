package kodak.cinemaapp.repo;

import kodak.cinemaapp.DTO.UserDTO;
import kodak.cinemaapp.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    User findAllById(int id);
}

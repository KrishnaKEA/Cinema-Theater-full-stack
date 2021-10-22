package kodak.cinemaapp.repo;

<<<<<<< HEAD
import kodak.cinemaapp.DTO.UserDTO;
=======
>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed
import kodak.cinemaapp.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    User findAllById(int id);
=======
@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    User findUserById(int id);
>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed
}

package kodak.cinemaapp.service;

import kodak.cinemaapp.dtos.MovieDTO;
import kodak.cinemaapp.entities.Movie;
import kodak.cinemaapp.entities.User;
import kodak.cinemaapp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(int userId){
        return userRepository.findUserById(userId);
    }


    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }

}

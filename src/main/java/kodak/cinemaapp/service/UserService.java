package kodak.cinemaapp.service;

import kodak.cinemaapp.DTO.UserDTO;
import kodak.cinemaapp.entities.User;
import kodak.cinemaapp.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserDTO> getAllUser() {
        return UserDTO.userDTOSFromUser(userRepository.findAll());
    }

    public UserDTO getUser(int id) {
        User user1 = (User) userRepository.findById(id).orElseThrow();
        return new UserDTO(user1);
    }

    public List<UserDTO> getUserByAgegroup(String agegroup) {
        List<User> userList = (List<User>) userRepository.findAll();
        List<UserDTO> result = new ArrayList<>();
        List<User> newUserKids = new ArrayList<>();
        List<User> newUserTeen = new ArrayList<>();
        List<User> newUserAdult = new ArrayList<>();
        for (User usera : userList) {
            LocalDate userBirthdate = usera.getBirthDate();
            LocalDate today = LocalDate.now();
            Period period = Period.between(userBirthdate, LocalDate.now());
            int userAgeInYear = period.getYears();
            if (userAgeInYear <= 12) {
                newUserKids.add(usera);
            }
            if (userAgeInYear > 12 && userAgeInYear < 18) {
                newUserTeen.add(usera);
            }
            if (userAgeInYear > 18) {
                newUserAdult.add(usera);
            }


        }
        if (agegroup.equals("kids")) {
            result = UserDTO.userDTOSFromUser(newUserKids);
        }
        if (agegroup.equals("teen")) {
            result = UserDTO.userDTOSFromUser(newUserTeen);
        }
        if (agegroup.equals("adult")) {
            result = UserDTO.userDTOSFromUser(newUserAdult);
        }
        return result;
    }

    public UserDTO addUser(UserDTO userToAdd) {
        User usertoBeAdded = UserDTO.userFromUserDTO(userToAdd);
        return new UserDTO(userRepository.save(usertoBeAdded));
    }

    public UserDTO editUser(UserDTO userToEdit, int id) {
        User userOriginal = userRepository.findById(id).orElseThrow();
        userOriginal.setFName(userToEdit.getFName());
        userOriginal.setLName(userToEdit.getLName());
        userOriginal.setEmail(userToEdit.getEmail());
        userOriginal.setPhoneNumber(userToEdit.getPhoneNumber());
        userOriginal.setBirthDate(userToEdit.getBirthDate());
        return new UserDTO((userRepository.save(userOriginal)));

    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}

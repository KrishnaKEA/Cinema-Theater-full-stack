package kodak.cinemaapp.services;

import kodak.cinemaapp.dtos.UserDTO;
import kodak.cinemaapp.entities.User;
import kodak.cinemaapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getUsers(String name, String email, int age){
        if(name!=null){
            return UserDTO.userDTOSfromUser(userRepository.findUsersByName(name));
        }
        if(age!=0){
            return UserDTO.userDTOSfromUser(userRepository.findUsersByAge(age));
        } if (email!=null){
            return UserDTO.userDTOSfromUser(userRepository.findUsersByEmail(email));
        }
        return UserDTO.userDTOSfromUser(userRepository.findAll());
    }

    public UserDTO getUser(int id){
        User user = userRepository.findById(id).orElseThrow();
        return new UserDTO(user);
    }

    public UserDTO addUser(UserDTO newUser){
        User userToAdd = UserDTO.userFromUserDTO(newUser);
        return new UserDTO(userRepository.save(userToAdd));
    }

    public UserDTO editUser(UserDTO userEdit, int id){
        User userOrg = userRepository.findById(id).orElseThrow();
        userOrg.setName(userEdit.getName());
        userOrg.setEmail(userEdit.getEmail());
        userOrg.setAge(userEdit.getAge());
        return new UserDTO(userRepository.save(userOrg));
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }

}

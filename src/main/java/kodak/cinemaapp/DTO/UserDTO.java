package kodak.cinemaapp.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import kodak.cinemaapp.entities.Movie;
import kodak.cinemaapp.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    int id;
    String fName;
    String lName;
    String email;
    Long phoneNumber;
    LocalDate birthDate;

    public UserDTO(int id,String fName, String lName, String email, Long phoneNumber, LocalDate birthDate) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }
    public UserDTO(User user){
        this.fName = user.getFName();
        this.lName = user.getLName();
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
        this.birthDate = user.getBirthDate();
        this.id = user.getId();
    }
    public static List<UserDTO> userDTOSFromUser(Iterable<User> users){
        List<UserDTO> uDTOs = new ArrayList<>();
        for(User user: users){
            UserDTO userD = new UserDTO(user);
            uDTOs.add(userD);
        }
        return uDTOs;
    }
    public static User userFromUserDTO(UserDTO userDTO){
        return new User(userDTO.getFName(),userDTO.getLName(),userDTO.getEmail(),userDTO.getPhoneNumber(),userDTO.getBirthDate());
    }
}

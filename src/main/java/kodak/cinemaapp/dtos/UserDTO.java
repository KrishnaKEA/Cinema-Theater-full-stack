package kodak.cinemaapp.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import kodak.cinemaapp.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@NoArgsConstructor
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    int id;
    String name;
    String email;
    int age;

    public UserDTO(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public UserDTO(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.age = user.getAge();
        this.id = user.getId();
    }

    public static List<UserDTO> userDTOSfromUser(Iterable<User> users){
        List<UserDTO> dtos = StreamSupport.stream(users.spliterator(), false)
                .map(user -> new UserDTO(user))
                .collect(Collectors.toList());
        return dtos;
    }

    public static User userFromUserDTO(UserDTO user){
        return new User(user.getName(), user.getEmail(), user.getAge());
    }
}

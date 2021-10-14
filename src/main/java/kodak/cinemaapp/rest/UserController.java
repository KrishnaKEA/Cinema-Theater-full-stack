package kodak.cinemaapp.rest;

import kodak.cinemaapp.dtos.SlotDTO;
import kodak.cinemaapp.dtos.UserDTO;
import kodak.cinemaapp.entities.Slot;
import kodak.cinemaapp.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    UserService userService;

    @GetMapping
    List<UserDTO> getUsers(@RequestParam(required = false) String name, @RequestParam(required = false) String email,@RequestParam(required = false) int age){
        if (name==null && email==null && age == 0){
            throw new IllegalStateException();
        }
        return userService.getUsers(name, email, age);
    }

    @GetMapping("/{id}")
    UserDTO getUser(@PathVariable int id){
        return userService.getUser(id);
    }

    @PostMapping
    UserDTO addUser(@RequestBody UserDTO newUser){
        return userService.addUser(newUser);
    }

    @PutMapping("/{id}")
    UserDTO editUser(@RequestBody UserDTO userToEdit, @PathVariable int id) throws Exception{
        return userService.editUser(userToEdit, id);
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

}

package kodak.cinemaapp.rest;

import kodak.cinemaapp.entities.User;
import kodak.cinemaapp.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/all")
    public Iterable<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{email}")
    public User findUserByEmail(@PathVariable String email){
        return userService.findUserByEmail(email);
    }

    @PostMapping("/adduser")
    public User addUser(@RequestBody User user){
        return userService.saveUser(user);
    }






}

package kodak.cinemaapp.rest;

import kodak.cinemaapp.DTO.UserDTO;
import kodak.cinemaapp.entities.User;
import kodak.cinemaapp.repo.UserRepository;
import kodak.cinemaapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping( "/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public List<UserDTO> getAllUsers(){
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable("id") int id){
       return userService.getUser(id);
    }
    @GetMapping("search/{ageGroup}")
    public List<UserDTO>getUserByAgeGroup(@PathVariable("ageGroup") String ageGroup){
       return userService.getUserByAgegroup(ageGroup);
    }
    @PostMapping
    public UserDTO addUser(@RequestBody UserDTO ud){
        return userService.addUser(ud);
    }
    @PutMapping("/{id}")
    public UserDTO editUser(@RequestBody UserDTO udEdit,@PathVariable("id") int id){
        return userService.editUser(udEdit,id);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
    }

}

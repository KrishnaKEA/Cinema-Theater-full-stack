package kodak.cinemaapp.rest;

import kodak.cinemaapp.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class UserController {

    UserService userService;

}

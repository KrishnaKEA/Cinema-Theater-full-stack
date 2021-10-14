package kodak.cinemaapp.services;

import kodak.cinemaapp.repositories.UserRepository;

public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}

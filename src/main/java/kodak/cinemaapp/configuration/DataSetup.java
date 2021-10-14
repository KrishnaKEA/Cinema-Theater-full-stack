package kodak.cinemaapp.configuration;

import kodak.cinemaapp.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSetup implements CommandLineRunner {

    HallRepository hallRepository;
    MovieRepository movieRepository;
    ScheduleRepository scheduleRepository;
    SlotRepository slotRepository;
    TheaterRepository theaterRepository;
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

    }
}

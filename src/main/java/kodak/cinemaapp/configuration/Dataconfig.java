package kodak.cinemaapp.configuration;

import kodak.cinemaapp.entities.*;
import kodak.cinemaapp.repo.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.util.Date;

@Configuration
public class Dataconfig implements CommandLineRunner {
    UserRepository userRepository;
    MovieRepository movieRepository;
    MovieTheaterRepository movieTheaterRepository;
    SlotRepository slotRepository;
    MovieHallRepository movieHallRepository;
    ScheduleRepository scheduleRepository;

    public Dataconfig(UserRepository userRepository, MovieRepository movieRepository, MovieTheaterRepository movieTheaterRepository, SlotRepository slotRepository, MovieHallRepository movieHallRepository, ScheduleRepository scheduleRepository) {
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
        this.movieTheaterRepository = movieTheaterRepository;
        this.slotRepository = slotRepository;
        this.movieHallRepository = movieHallRepository;
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Movie movie1 = movieRepository.save(new Movie("Tom and jerry", "Kids", "tom and jerry", "Funny commedy between cat and mouse", "N/A"));
        Movie movie2 = movieRepository.save(new Movie("Titanic", "Adult", "Jack", "Romantic Movie", "N/A"));


        User user1 =  userRepository.save(new User("Krishna","Khanal","k@gamil.com",71443434, LocalDate.parse("2010-10-10")));
        User user2 =  userRepository.save(new User("John","Hagen","j@gamil.com",434343333, LocalDate.parse("1981-09-09")));


        MovieHall movieHall1 = movieHallRepository.save(new MovieHall('A',144,"Morning"));
        MovieHall movieHall2 = movieHallRepository.save(new MovieHall('B',144,"Evening"));
        MovieHall movieHall3 = movieHallRepository.save(new MovieHall('A',144,"Afternoon"));



        MovieTheater movieTheater1 = movieTheaterRepository.save(new MovieTheater("Star Kino","Big Herlev",3));
        MovieTheater movieTheater2 = movieTheaterRepository.save(new MovieTheater("Quantum Cinema","Fisketorvet",2));


        Slot slot1 = slotRepository.save(new Slot("Morning"));
        Slot slot2 = slotRepository.save(new Slot("Afternoon"));
        Slot slot3 = slotRepository.save(new Slot("Evening"));



        Schedule schedule1 = scheduleRepository.save(new Schedule(movie1.getId(),movieHall1.getId(),slot1.getId(),LocalDate.parse("2021-10-12")));
        Schedule schedule2 = scheduleRepository.save(new Schedule(movie2.getId(),movieHall1.getId(),slot2.getId(),LocalDate.parse("2021-10-12")));

    }
}

package kodak.cinemaapp.configuration;

import kodak.cinemaapp.entities.*;
import kodak.cinemaapp.repo.*;
import kodak.cinemaapp.service.MovieHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.util.Date;

@Configuration
public class Dataconfig implements CommandLineRunner {

    MovieRepository movieRepository;
    MovieHallRepository movieHallRepository;
    MovieTheaterRepository movieTheaterRepository;
    ScheduleRepository scheduleRepository;
    SlotRepository slotRepository;
    UserRepository userRepository;
    BookingRepository bookingRepository;
    @Autowired
MovieHallService movieHallService;

    public Dataconfig(MovieRepository movieRepository, MovieHallRepository movieHallRepository, MovieTheaterRepository movieTheaterRepository, ScheduleRepository scheduleRepository, SlotRepository slotRepository,UserRepository userRepository,BookingRepository bookingRepository) {
        this.movieRepository = movieRepository;
        this.movieHallRepository = movieHallRepository;
        this.movieTheaterRepository = movieTheaterRepository;
        this.scheduleRepository = scheduleRepository;
        this.slotRepository = slotRepository;
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        MovieTheater movieTheater = movieTheaterRepository.save(new MovieTheater("Cinema CPH","Copenhagen", 3));
        MovieHall h1 = movieHallRepository.save(new MovieHall('A', 25, "morning" ));
        movieHallService.populatateSeat(h1.getSeat());
        MovieHall h2 = movieHallRepository.save(new MovieHall('B', 36,"Afternoon"));
        MovieHall h3 = movieHallRepository.save(new MovieHall('C', 25, "Evening" ));

        Slot s1 = slotRepository.save(new Slot("Morning"));
        Slot s2 = slotRepository.save(new Slot("Afternoon"));
        Slot s3 = slotRepository.save(new Slot("Evening"));


        Movie m1 = movieRepository.save(new Movie("Title1","teens","Actor1, Actor2","description1","N/A"));
        Movie m2 = movieRepository.save(new Movie("Title2","kids","Actor1, Actor2","description2","N/A"));
        Movie m3 = movieRepository.save(new Movie("Title3","kids","Actor1, Actor2","description3","N/A"));
        Movie m4 = movieRepository.save(new Movie("Title4","adults","Actor1, Actor2","description4","N/A"));
        Movie m5 = movieRepository.save(new Movie("Title5","adults","Actor1, Actor2","description5","N/A"));
        Movie m6 = movieRepository.save(new Movie("Title6","teens","Actor1, Actor2","description6","N/A"));
        Movie m7 = movieRepository.save(new Movie("Title7","kids","Actor1, Actor2","description7","N/A"));
        Movie m8 = movieRepository.save(new Movie("Title8","kids","Actor1, Actor2","description8","N/A"));
        Movie m9 = movieRepository.save(new Movie("Title9","adults","Actor1, Actor2","description9","N/A"));

        User u1 = userRepository.save(new User("Krishna","Khanal","k@gmail.com",71379246,LocalDate.of(1985,12,9)));
        User u2 = userRepository.save(new User("John","Rasmusen","j@gmail.com",71879246,LocalDate.of(1983,5,6)));
        User u3 = userRepository.save(new User("James","Dahl","jd@gmail.com",403434326,LocalDate.of(2000,7,24)));



        Schedule sc1 = scheduleRepository.save(new Schedule(LocalDate.now(),h3,m6,s3));
        Schedule sc2 = scheduleRepository.save(new Schedule(LocalDate.of(2021,10,22),h2,m9,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,10,23),h3,m7,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,11,1),h1,m1,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,11,1),h1,m2,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,11,1),h1,m3,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,11,1),h2,m4,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,11,1),h2,m5,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,11,1),h2,m6,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,11,1),h3,m7,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,11,1),h3,m8,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,11,1),h3,m9,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,11,2),h1,m2,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,11,2),h2,m9,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,11,3),h3,m4,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,11,4),h1,m2,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,11,5),h2,m7,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,11,6),h3,m1,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,11,7),h1,m2,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,11,8),h1,m6,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,11,9),h3,m9,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,11,10),h2,m8,s2));


        bookingRepository.save(new Booking(u1,sc1,sc1.getMovieHall().getSeat()));
        bookingRepository.save(new Booking(u1,sc2,sc2.getMovieHall().getSeat()));
        bookingRepository.save(new Booking(u2,sc2,sc2.getMovieHall().getSeat()));



    }
}

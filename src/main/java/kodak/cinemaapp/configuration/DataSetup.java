package kodak.cinemaapp.configuration;

import kodak.cinemaapp.entities.*;
import kodak.cinemaapp.repo.*;
import kodak.cinemaapp.service.SeatService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Configuration
public class DataSetup implements CommandLineRunner {

    MovieRepository movieRepository;
    MovieHallRepository movieHallRepository;
    MovieTheaterRepository movieTheaterRepository;
    ScheduleRepository scheduleRepository;
    SlotRepository slotRepository;
    UserRepository userRepository;
    BookingRepository bookingRepository;
    SeatRepository seatRepository;
    BookedSeatRepository bookedSeatRepository;


    SeatService seatService;


    public DataSetup(SeatService seatService, BookedSeatRepository bookedSeatRepository, BookingRepository bookingRepository, SeatRepository seatRepository, MovieRepository movieRepository, MovieHallRepository movieHallRepository, MovieTheaterRepository movieTheaterRepository, ScheduleRepository scheduleRepository, SlotRepository slotRepository, UserRepository userRepository) {
        this.seatRepository = seatRepository;
        this.bookingRepository = bookingRepository;
        this.movieRepository = movieRepository;
        this.movieHallRepository = movieHallRepository;
        this.movieTheaterRepository = movieTheaterRepository;
        this.scheduleRepository = scheduleRepository;
        this.slotRepository = slotRepository;
        this.userRepository = userRepository;
        this.bookedSeatRepository = bookedSeatRepository;
        this.seatService = seatService;
    }



    @Override
    public void run(String... args) throws Exception {
       MovieTheater movieTheater = movieTheaterRepository.save(new MovieTheater("Cinema CPH","Copenhagen", 3));

        User u1 = userRepository.save(new User("Adrian","Enachi","adrian52x@gmail.com", 81949992,LocalDate.of(1998,8,25)));
        User u2 = userRepository.save(new User("Mark","Rgz","gmail.com", 81949992,LocalDate.of(1997,5,12)));



        MovieHall h1 = movieHallRepository.save(new MovieHall('A' ,10, movieTheater ));
        MovieHall h2 = movieHallRepository.save(new MovieHall('B',5, movieTheater ));
        MovieHall h3 = movieHallRepository.save(new MovieHall('C',3, movieTheater ));

        seatService.createSeats(h1);
        seatService.createSeats(h2);
        seatService.createSeats(h3);

        /*Seat seat1 = seatRepository.save(new Seat(22,h1));
        Seat seat2 = seatRepository.save(new Seat(33,h1));
        Seat seat3 = seatRepository.save(new Seat(44,h1));

        Seat seat4 = seatRepository.save(new Seat(22,h2));
        Seat seat5 = seatRepository.save(new Seat(33,h2));
        Seat seat6 = seatRepository.save(new Seat(44,h2));

        Seat seat7 = seatRepository.save(new Seat(22,h3));
        Seat seat8 = seatRepository.save(new Seat(33,h3));
        Seat seat9 = seatRepository.save(new Seat(44,h3));*/


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


        //LocalDate NOW
       // scheduleRepository.save(new Schedule(LocalDate.now(),h3,m6,s3));
        //Testing "/schedule/week" api
        scheduleRepository.save(new Schedule(LocalDate.of(2021,11,29),h2,m9,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,11,30),h1,m7,s3));


        // MAX 9 schedules per DAY ( 1day x 3slots x 3movieHalls = 9 )
        // 8 for this day
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,4),h1,m1,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,4),h1,m1,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,4),h1,m1,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,4),h2,m3,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,4),h2,m5,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,4),h2,m4,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,4),h3,m1,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,4),h3,m8,s2));

        // 8 for this day
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,5),h1,m9,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,5),h1,m1,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,5),h1,m1,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,5),h2,m1,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,5),h2,m2,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,5),h2,m4,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,5),h3,m7,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,5),h3,m8,s2));


        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,6),h1,m9,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,6),h1,m1,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,6),h1,m1,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,6),h2,m1,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,6),h2,m2,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,6),h2,m4,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,6),h3,m7,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,6),h3,m8,s2));


        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,7),h1,m9,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,7),h1,m1,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,7),h1,m1,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,7),h2,m1,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,7),h2,m2,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,7),h2,m4,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,7),h3,m7,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,7),h3,m8,s2));

        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,8),h1,m9,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,8),h1,m1,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,8),h1,m1,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,8),h2,m1,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,8),h2,m2,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,8),h2,m4,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,8),h3,m7,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,8),h3,m8,s2));

        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,9),h1,m9,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,9),h1,m1,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,9),h1,m1,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,9),h2,m1,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,9),h2,m2,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,9),h2,m4,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,9),h3,m7,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,9),h3,m8,s2));


        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,10),h1,m9,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,10),h1,m1,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,10),h1,m1,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,10),h2,m1,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,10),h2,m2,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,10),h2,m4,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,10),h3,m7,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,10),h3,m8,s2));


        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,11),h1,m9,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,11),h1,m1,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,11),h1,m1,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,11),h2,m1,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,11),h2,m2,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,11),h2,m4,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,11),h3,m7,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,11),h3,m8,s2));



    }
}

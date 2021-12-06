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
       MovieTheater movieTheater = movieTheaterRepository.save(new MovieTheater("Cinema-X","Holbæk", 3));

        User u1 = userRepository.save(new User("Adrian","Enachi","adrian52x@gmail.com", 81949992,LocalDate.of(1998,8,25)));
        User u2 = userRepository.save(new User("Mark","Rgz","gmail.com", 81949992,LocalDate.of(1997,5,12)));



        MovieHall h1 = movieHallRepository.save(new MovieHall('A' ,16, movieTheater ));
        MovieHall h2 = movieHallRepository.save(new MovieHall('B',16, movieTheater ));
        MovieHall h3 = movieHallRepository.save(new MovieHall('C',16, movieTheater ));

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

        String m1Desc = "Plagued by strange memories, Neo's life takes an unexpected turn when he finds himself back inside the Matrix.";
        String m2Desc = "The Eternals, a race of immortal beings with superhuman powers who have secretly lived on Earth for thousands of years, reunite to battle the evil Deviants.";
        String m3Desc = " Hugo er tolv år, og han tror stadig på nisser. Hans skolekammerater synes, han er barnlig, og han vælger derfor at bryde med sin bedste ven: nissen Pixy.";
        String m4Desc = "When Patrizia Reggiani, an outsider from humble beginnings, marries into the Gucci family, her unbridled ambition begins to unravel the family legacy and triggers a reckless spiral of betrayal...";
        String m5Desc = "James Bond is enjoying a tranquil life in Jamaica after leaving active service. However, his peace is short-lived as his old CIA friend, Felix Leiter, shows up and asks for help.";
        String m6Desc = "Harry Potter, an eleven-year-old orphan, discovers that he is a wizard and is invited to study at Hogwarts. Even as he escapes a dreary life and enters a world of magic, he finds trouble awaiting him.";
        String m7Desc = "When a single mother and her two children move to a new town, they soon discover they have a connection to the original Ghostbusters and the secret legacy their grandfather left behind.";
        String m8Desc = "Follow Alex and the Checkered Ninja who embark on a frantic hunt for the villain Phillip Eppermint, who has evaded a prison sentence in Thailand.";
        String m9Desc = "Eddie Brock is still struggling to coexist with the shape-shifting extraterrestrial Venom. When deranged serial killer Cletus Kasady also becomes host to an alien symbiote...";



        Movie m1 = movieRepository.save(new Movie("MATRIX","teens","Actor1, Actor2",m1Desc,"9/10"));
        Movie m2 = movieRepository.save(new Movie("ETERNALS","teens","Actor1, Actor2",m2Desc,"8/10"));
        Movie m3 = movieRepository.save(new Movie("FAMILIEN JUL OG NISSEHOTELLET","kids","Actor1, Actor2",m3Desc,"8/10"));
        Movie m4 = movieRepository.save(new Movie("HOUSE of GUCCI","adults","Actor1, Actor2",m4Desc,"7/10"));
        Movie m5 = movieRepository.save(new Movie("NO TIME TO DIE","adults","Actor1, Actor2",m5Desc,"10/10"));
        Movie m6 = movieRepository.save(new Movie("HARRY POTTER","teens","Actor1, Actor2",m6Desc,"7/10"));
        Movie m7 = movieRepository.save(new Movie("GHOSTBUSTERS","kids","Actor1, Actor2",m7Desc,"6/10"));
        Movie m8 = movieRepository.save(new Movie("TERNET NINJA 2","kids","Actor1, Actor2",m8Desc,"7/10"));
        Movie m9 = movieRepository.save(new Movie("VENOM","adults","Actor1, Actor2",m9Desc,"8/10"));


        //LocalDate NOW
        // scheduleRepository.save(new Schedule(LocalDate.now(),h3,m6,s3));



        // MAX 9 schedules per DAY ( 1day x 3slots x 3movieHalls = 9 )
        // 9 for this day
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,4),h1,m1,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,4),h1,m6,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,4),h1,m7,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,4),h2,m3,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,4),h2,m5,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,4),h2,m4,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,4),h3,m2,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,4),h3,m8,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,4),h3,m9,s3));


        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,5),h1,m1,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,5),h1,m6,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,5),h1,m7,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,5),h2,m3,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,5),h2,m5,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,5),h2,m4,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,5),h3,m2,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,5),h3,m8,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,5),h3,m9,s3));


        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,6),h1,m1,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,6),h1,m6,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,6),h1,m7,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,6),h2,m3,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,6),h2,m5,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,6),h2,m4,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,6),h3,m2,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,6),h3,m8,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,6),h3,m9,s3));


        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,7),h1,m1,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,7),h1,m6,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,7),h1,m7,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,7),h2,m3,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,7),h2,m5,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,7),h2,m4,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,7),h3,m2,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,7),h3,m8,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,7),h3,m9,s3));


        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,8),h1,m1,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,8),h1,m6,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,8),h1,m7,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,8),h2,m3,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,8),h2,m5,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,8),h2,m4,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,8),h3,m2,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,8),h3,m8,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,8),h3,m9,s3));


        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,9),h1,m1,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,9),h1,m6,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,9),h1,m7,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,9),h2,m3,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,9),h2,m5,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,9),h2,m4,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,9),h3,m2,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,9),h3,m8,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,9),h3,m9,s3));


        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,10),h1,m1,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,10),h1,m6,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,10),h1,m7,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,10),h2,m3,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,10),h2,m5,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,10),h2,m4,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,10),h3,m2,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,10),h3,m8,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,10),h3,m9,s3));


        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,11),h1,m1,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,11),h1,m6,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,11),h1,m7,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,11),h2,m3,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,11),h2,m5,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,11),h2,m4,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,11),h3,m2,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,11),h3,m8,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,11),h3,m9,s3));

        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,12),h1,m1,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,12),h1,m6,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,12),h1,m7,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,12),h2,m3,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,12),h2,m5,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,12),h2,m4,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,12),h3,m2,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,12),h3,m8,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,12),h3,m9,s3));

        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,13),h1,m1,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,13),h1,m6,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,13),h1,m7,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,13),h2,m3,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,13),h2,m5,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,13),h2,m4,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,13),h3,m2,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,13),h3,m8,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,13),h3,m9,s3));

        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,14),h1,m1,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,14),h1,m6,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,14),h1,m7,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,14),h2,m3,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,14),h2,m5,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,14),h2,m4,s3));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,14),h3,m2,s1));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,14),h3,m8,s2));
        scheduleRepository.save(new Schedule(LocalDate.of(2021,12,14),h3,m9,s3));



    }
}

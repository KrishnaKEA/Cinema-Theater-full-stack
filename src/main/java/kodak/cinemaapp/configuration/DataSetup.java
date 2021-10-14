package kodak.cinemaapp.configuration;

import kodak.cinemaapp.entities.*;
import kodak.cinemaapp.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Configuration
public class DataSetup implements CommandLineRunner {

    HallRepository hallRepository;
    MovieRepository movieRepository;
    ScheduleRepository scheduleRepository;
    ShowingRepository showingRepository;
    SlotRepository slotRepository;
    TheaterRepository theaterRepository;
    UserRepository userRepository;

    public DataSetup(HallRepository hallRepository, MovieRepository movieRepository, ScheduleRepository scheduleRepository, ShowingRepository showingRepository, SlotRepository slotRepository, TheaterRepository theaterRepository, UserRepository userRepository) {
        this.hallRepository = hallRepository;
        this.movieRepository = movieRepository;
        this.scheduleRepository = scheduleRepository;
        this.showingRepository = showingRepository;
        this.slotRepository = slotRepository;
        this.theaterRepository = theaterRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        hallRepository.save(new Hall("A", 26, 26));
        hallRepository.save(new Hall("B", 12, 14));
        hallRepository.save(new Hall("C", 18, 22));
        hallRepository.save(new Hall("D", 17, 13));
        hallRepository.save(new Hall("E", 5, 5));

        movieRepository.save(new Movie("No Time to Die", "Teen", "Daniel Craig, Ana De Armas, Chris Evans", "Daniel Craigs' final outing as James Bond", true));
        movieRepository.save(new Movie("Movie 2", "Adult", "Someone you know, someone you used to know", "Description of a film you're looking at", true));
        movieRepository.save(new Movie("Peppa Pig's excellent adventure","Children","Peppa Pig","Peppa Pig goes on a genocidal rampage", false));
        movieRepository.save(new Movie("Movie 4", "Adult", "Baby Shark", "Baby Shark grows up and becomes a drug lord", true));
        movieRepository.save(new Movie("Slow and the Accepting", "Adult", "Vin Diesel, Dwayne Johnson", "Vin and Dwayne finally settle down after their life of crime, racing and space hijacks and have a baby together", true));

        scheduleRepository.save(new Schedule(LocalDate.parse("2021-11-01"), hallRepository.getById(0).getId(), slotRepository.findAll()));
        scheduleRepository.save(new Schedule(LocalDate.parse("2021-11-02"), hallRepository.getById(1).getId(), slotRepository.findAll()));
        scheduleRepository.save(new Schedule(LocalDate.parse("2021-11-03"), hallRepository.getById(2).getId(), slotRepository.findAll()));
        scheduleRepository.save(new Schedule(LocalDate.parse("2021-11-04"), hallRepository.getById(3).getId(), slotRepository.findAll()));
        scheduleRepository.save(new Schedule(LocalDate.parse("2021-11-05"), hallRepository.getById(4).getId(), slotRepository.findAll()));

        slotRepository.save(new Slot(Slot.SlotTime.MORNING));
        slotRepository.save(new Slot(Slot.SlotTime.AFTERNOON));
        slotRepository.save(new Slot(Slot.SlotTime.EVENING));

        showingRepository.save(new Showing(movieRepository.getById(0), hallRepository.getById(0), slotRepository.getById(0)));
        showingRepository.save(new Showing(movieRepository.getById(1), hallRepository.getById(1), slotRepository.getById(0)));
        showingRepository.save(new Showing(movieRepository.getById(0), hallRepository.getById(2), slotRepository.getById(1)));
        showingRepository.save(new Showing(movieRepository.getById(2), hallRepository.getById(3), slotRepository.getById(1)));
        showingRepository.save(new Showing(movieRepository.getById(3), hallRepository.getById(4), slotRepository.getById(2)));

        theaterRepository.save(new Theater("Guldbergsgade Theater", "Copenhagen", 5, hallRepository.findAll()));

        userRepository.save(new User("Karolina Urnieziute", "Karo@gmail.com", 25));
        userRepository.save(new User("Adrian Enachi", "Adrian@Gmail.com", 17));
        userRepository.save(new User("Krishna Khanal", "Krishna@Gmail.com", 40));
        userRepository.save(new User("Omar Farah", "Omar@Hotmail.co.uk", 32));
        userRepository.save(new User("Dominic Smith", "Domdom@yahoo.co.uk", 25));
        userRepository.save(new User("Oskar Tuska", "Oskar@hotmail.com", 62));
        userRepository.save(new User("Aiste Kiausaite", "Aiste@askjeeves.co.uk", 15));
        userRepository.save(new User("Justas Zdanavicius", "JustaBoy@gmail.com", 5));
        userRepository.save(new User("Alex Condon", "Alexei@outback.com", 20));
        userRepository.save(new User("Ana Karina Caro Hoyos", "Ana@SofiaVergara.com", 26));

    }
}

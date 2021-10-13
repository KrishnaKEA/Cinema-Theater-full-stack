package kodak.cinemaapp;

import kodak.cinemaapp.entities.hall.Hall;
import kodak.cinemaapp.entities.hall.HallRepo;
import kodak.cinemaapp.entities.movie.Movie;
import kodak.cinemaapp.entities.movie.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CinemaAppApplication implements CommandLineRunner {

    @Autowired
    MovieRepo movieRepo;
    @Autowired
    HallRepo hallRepo;

    public static void main(String[] args) {
        SpringApplication.run(CinemaAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Hall hall1 = new Hall("Panorama Hall");
        Hall hall2 = new Hall("Luxurious Hall");

        hallRepo.save(hall1);
        hallRepo.save(hall2);

        Movie movie1 =  new Movie("Fate of the furious","With Dom and Letty married, Brian and Mia retired and the rest of the crew exonerated, the globe-trotting team has found some semblance of a normal life", "High","Vin Diesel and Tyrese Gibson",hall1);
        Movie movie2 = new Movie("Titanic","James Cameron is 'Titanic' is an epic, action-packed romance set against the ill-fated maiden voyage of the R.M.S. Titanic; the pride and joy of the White Star Line and, at the time, the largest moving object ever built.", "High", " Leonardo DiCaprio and Kate Winslet", hall2);
        Movie movie3 = new Movie("Mission Impossible"," It is a multimedia franchise based on a fictional secret espionage agency known as the Impossible Missions Force (IMF). The 1966 TV series ran for 7 seasons and was revived in 1988 for two seasons. It inspired a series...", "High","Tom Cruise and Ethan Hunt", hall1);

        movieRepo.save(movie1);
        movieRepo.save(movie2);
        movieRepo.save(movie3);
    }
}



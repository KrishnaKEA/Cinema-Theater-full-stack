package kodak.cinemaapp.repository;

import kodak.cinemaapp.entities.Hall;
import kodak.cinemaapp.entities.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@DataJpaTest
//    public class MovieRepoTest {
//
//    @Autowired
//    private HallRepo hallRepo;
//    @Autowired
//    private  MovieRepo movieRepo;
//
//    @BeforeEach
//    public void  setupMovies(){
//
//        Hall hall1 = new Hall("Panorama Hall");
//        Hall hall2 = new Hall("Luxurious Hall");
//
//        hallRepo.save(hall1);
//        hallRepo.save(hall2);
//
//        movieRepo.save(new Movie("World War Two", "About the second war...", "Medium", "Random actor name", true, "2021-10-10", 2));
//        movieRepo.save(new Movie("World War One", "About the first war...", "Low", "Random actor", false, "2021-10-15", 1));
//        movieRepo.save(new Movie("Rush Hour", "reckless and loudmouthed L.A.P.D. detective to rescue the Chinese Consul's kidnapped daughter...", "Medium", "Jackie Chan and Chris Tucker", true, "2021-10-16", 2));
//        movieRepo.save(new Movie("Mission Impossible", "Ethan and his team take on their most impossible mission yet when they have to eradicate an international rogue organization as highly skilled...", "Medium", "Tom Cruise", true, "2021-10-14", 1));
//
//    }
//
//    @Test
//    void findMovieByTitle(){
//        int missionMovieFound = movieRepo.findByTitleContaining("Mission").size();
//        assertEquals(1, missionMovieFound);
//    }
//
//        //    @Test
//        //    void findCarByBrand() {
//        //        long volvosFound = carRepository.findCarByBrand("Volvo").size();
//        //        assertEquals(3,volvosFound);
//        //    }
//
//}

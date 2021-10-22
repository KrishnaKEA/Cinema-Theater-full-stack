package kodak.cinemaapp.repository;


import kodak.cinemaapp.entities.movieTheater.MovieTheater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieTheaterRepo extends JpaRepository<MovieTheater, Long> {
}

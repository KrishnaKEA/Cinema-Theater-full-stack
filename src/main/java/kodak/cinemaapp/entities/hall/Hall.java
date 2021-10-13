package kodak.cinemaapp.entities.hall;


import kodak.cinemaapp.entities.movie.Movie;
import kodak.cinemaapp.entities.movieTheater.MovieTheater;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@Entity
@Table(name = "hall")
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

//    //@ElementCollection
//    private Map<String, Integer> seats = new HashMap<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "hall")
    private List<Movie> movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_theater_id")
    private MovieTheater movieTheater;

    public Hall(String name) {
        this.name = name;
    }

    public Hall(String name, List<Movie> movie, MovieTheater movieTheater) {
        this.name = name;
//        this.seats = seats;
        this.movie = movie;
        this.movieTheater = movieTheater;
    }
}

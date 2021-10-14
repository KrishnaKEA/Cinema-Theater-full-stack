package kodak.cinemaapp.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private LocalDate date;

    public Schedule(LocalDate date, MovieHall movieHall, Movie movie, Slot slot) {
        this.date = date;
        this.movieHall = movieHall;
        this.movie = movie;
        this.slot = slot;
    }

    // Schedule* ---> 1 Hall
    @ManyToOne
    private MovieHall movieHall;

    // Schedule* ---> 1 Movie
    @ManyToOne
    Movie movie;

    // Schedule* ---> 1 Slot
    @ManyToOne
    Slot slot;
}

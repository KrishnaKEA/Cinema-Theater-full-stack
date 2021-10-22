package kodak.cinemaapp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import kodak.cinemaapp.DTO.BookingDTO;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@AllArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 4,insertable = false,updatable = false)

    private int movie_id;
    @Column(length = 4)
    private int hallId;
    @Column(length = 4,insertable = false,updatable = false)
    private int slot_id;
    private LocalDate date;
    @OneToMany(mappedBy = "schedule")
    private List<Seat> Seats = new ArrayList<>();

    public Schedule(int id,int movie_id, int hallIdΩ, int slot_id, LocalDate date) {
        this.id = id;
        this.movie_id= movie_id;
        this.hallId = hallId;
        this.slot_id = slot_id;
        this.date = date;
    }



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

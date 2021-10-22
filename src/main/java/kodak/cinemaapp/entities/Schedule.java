package kodak.cinemaapp.entities;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonFormat;
import kodak.cinemaapp.DTO.BookingDTO;
=======
import com.fasterxml.jackson.annotation.*;
>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@AllArgsConstructor
=======
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "schedule")
>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
<<<<<<< HEAD
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


=======

    @Column(nullable = false)
    private LocalDate date;
>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed

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

<<<<<<< HEAD
=======


    @OneToMany(mappedBy = "schedule",fetch = FetchType.LAZY)
    @JsonIgnore
    List<Booking> bookings = new ArrayList<>();

    /*@OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<BookedSeat> bookedSeats;*/


>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed
}

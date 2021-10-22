package kodak.cinemaapp.entities;

<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
=======
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
<<<<<<< HEAD
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private int seatNumber;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Seat(int seatNumber, MovieHall hall) {
        this.seatNumber = seatNumber;
        this.hall = hall;
    }

    public Seat(MovieHall hall) {
        this.hall = hall;
    }

    @ManyToOne
   MovieHall hall;
    @ManyToOne
    Schedule schedule;
=======
@EqualsAndHashCode
@Entity
@Table(name = "seat")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int seatNumber;

    @ManyToOne
    private MovieHall movieHall;

    @OneToMany(mappedBy = "seat", cascade = CascadeType.MERGE)
    @JsonBackReference
    private Set<BookedSeat> bookedSeats;

    public Seat(int seatNumber, MovieHall movieHall) {
        this.seatNumber = seatNumber;
        this.movieHall = movieHall;
    }



>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed

}

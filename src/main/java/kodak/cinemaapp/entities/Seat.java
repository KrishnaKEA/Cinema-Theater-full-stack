package kodak.cinemaapp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @OneToMany(mappedBy = "seat", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<BookedSeat> bookedSeats;

    public Seat(int seatNumber, MovieHall movieHall) {
        this.seatNumber = seatNumber;
        this.movieHall = movieHall;
    }




}

package kodak.cinemaapp.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

}

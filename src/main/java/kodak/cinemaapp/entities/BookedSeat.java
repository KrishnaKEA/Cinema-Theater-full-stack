package kodak.cinemaapp.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class BookedSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne
    @JsonManagedReference
    private Seat seat;

    @ManyToOne
    @JsonManagedReference
    private Booking booking;

    /*@ManyToOne
    @JsonManagedReference
    private Schedule schedule;*/

    public BookedSeat(Seat seat, Booking booking) {
        this.seat = seat;
        this.booking = booking;
    }


}

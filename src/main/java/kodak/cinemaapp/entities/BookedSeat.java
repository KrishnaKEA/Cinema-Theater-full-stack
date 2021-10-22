package kodak.cinemaapp.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class BookedSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private LocalDate date;

    private String timeSlot;

    @ManyToOne
    @JsonManagedReference
    private Seat seat;

    @ManyToOne
    @JsonManagedReference
    private Booking booking;

    /*@ManyToOne
    @JsonManagedReference
    private Schedule schedule;*/

    public BookedSeat(LocalDate date, String timeSlot, Seat seat, Booking booking) {
        this.date = date;
        this.timeSlot = timeSlot;
        this.seat = seat;
        this.booking = booking;

    }


}

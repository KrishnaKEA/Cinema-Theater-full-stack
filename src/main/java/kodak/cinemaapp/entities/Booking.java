package kodak.cinemaapp.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    @ManyToOne
    private User user;
    @ManyToOne
    private Schedule schedule;
    int seatNumber;


    public Booking(int bookingId, User user, Schedule schedule) {
        this.bookingId = bookingId;
        this.user = user;
        this.schedule = schedule;
    }
    public Booking(User user,Schedule schedule,int seatNumber){
        this.user = user;
        this.schedule = schedule;
        this.seatNumber = seatNumber;
    }

}

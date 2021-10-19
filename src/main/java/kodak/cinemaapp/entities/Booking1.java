package kodak.cinemaapp.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity

public class Booking1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    private int userId;
    private int hallId;
    private LocalDate date;
    private int  slotId;
    private int movieId;
    int seatNumber;

    public Booking1(int userId, int hallId, LocalDate date, int slotId, int movieId, int seatNumber) {
        this.userId = userId;
        this.hallId = hallId;
        this.date = date;
        this.slotId = slotId;
        this.movieId = movieId;
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return hallId +""+date +slotId +movieId +seatNumber;
    }
}

package kodak.cinemaapp.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 4)
    private int movieId;
    @Column(length = 4)
    private int hallId;
    @Column(length = 4)
    private int slotId;
    private LocalDate date;

    public Schedule(int movieId, int hallId, int slotId, LocalDate date) {
        this.movieId = movieId;
        this.hallId = hallId;
        this.slotId = slotId;
        this.date = date;
    }
}

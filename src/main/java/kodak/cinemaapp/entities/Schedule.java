package kodak.cinemaapp.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Schedule {
    @Id
    private int id;
    @Column(length = 4,nullable = false)
    private int movieId;
    @Column(length = 4,nullable = false)
    private int hallId;
    @Column(length = 4,nullable = false)
    private int slotId;
    @Column(nullable = false)
    private LocalDate date;
}

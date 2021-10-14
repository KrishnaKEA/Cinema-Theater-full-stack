package kodak.cinemaapp.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MovieHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private char hallName;
    private int seat;
    private String showSlot;

    public MovieHall(char hallName, int seat, String showSlot) {
        this.hallName = hallName;
        this.seat = seat;
        this.showSlot = showSlot;
    }
}

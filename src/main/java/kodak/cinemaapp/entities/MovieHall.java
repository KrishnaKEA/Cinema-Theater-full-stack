package kodak.cinemaapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(mappedBy = "movieHall",fetch = FetchType.LAZY)
    @JsonIgnore
    List<Schedule> schedules = new ArrayList<>();
}

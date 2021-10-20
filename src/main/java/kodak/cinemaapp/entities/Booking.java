package kodak.cinemaapp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import kodak.cinemaapp.dtos.ScheduleDTO;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Schedule schedule;


    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<BookedSeat> bookedSeats;


    public Booking(User user, Schedule schedule) {
        this.user = user;
        this.schedule = schedule;
    }
}

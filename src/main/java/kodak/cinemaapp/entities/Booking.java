<<<<<<< HEAD


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

=======
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


    @OneToMany(mappedBy = "booking", cascade = CascadeType.MERGE)
    @JsonBackReference
    private Set<BookedSeat> bookedSeats;


    public Booking(User user, Schedule schedule) {
        this.user = user;
        this.schedule = schedule;
    }
>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed
}

package kodak.cinemaapp.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Entity
@NoArgsConstructor
@Getter @Setter
@Table (name = "schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name="hall_id")
    int hallId;

    @Column(name = "schedule_date")
    LocalDate date;

    @OneToMany // * -> 1
    List<Slot> slots = new ArrayList<>();

    public Schedule(LocalDate date) {
        this.date = date;
    }

    public Schedule(LocalDate date, int hallId, List<Slot> slots) {
        this.date = date;
        this.hallId = hallId;
        this.slots = slots;
    }
}

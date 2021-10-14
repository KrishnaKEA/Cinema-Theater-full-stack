package kodak.cinemaapp.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String date;

    @ManyToOne // * -> 1
    Hall hall;

    @OneToMany // * -> 1
    List<Slot> slots = new ArrayList<>();

    public Schedule(String date, Hall hall, List<Slot> slots) {
        this.date = date;
        this.hall = hall;
        this.slots = slots;
    }
}

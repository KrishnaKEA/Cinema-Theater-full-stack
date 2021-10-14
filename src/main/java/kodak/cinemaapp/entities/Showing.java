package kodak.cinemaapp.entities;

import javax.persistence.*;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Showing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @OneToOne
    Movie movie;

    @OneToOne
    Hall hall;

    Slot.SlotTime slot;

    public Showing(Movie movie, Slot.SlotTime slot) {
        this.movie = movie;
        this.slot = slot;
    }
}

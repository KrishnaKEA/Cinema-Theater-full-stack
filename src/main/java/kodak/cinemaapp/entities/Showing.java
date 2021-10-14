package kodak.cinemaapp.entities;

import javax.persistence.*;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter @Setter
@Table (name = "showings")
public class Showing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    Movie movie;

    @ManyToOne
    Hall hall;

    @ManyToOne
    Slot slot;

    public Showing(Movie movie, Hall hall, Slot slot) {
        this.movie = movie;
        this.hall = hall;
        this.slot = slot;
    }
}
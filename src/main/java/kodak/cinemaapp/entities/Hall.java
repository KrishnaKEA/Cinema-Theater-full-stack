package kodak.cinemaapp.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String name;

    @Column
    int seatsX;

    @Column
    int seatsY;

    @Column
    int totalSeats = seatsX * seatsY;

    @OneToMany(mappedBy = "hall")
    List<Movie> movies = new ArrayList<>();

    @ManyToOne
    Theater theater;

    public Hall(String name, int seatsX, int seatsY, int totalSeats) {
        this.name = name;
        this.seatsX = seatsX;
        this.seatsY = seatsY;
        this.totalSeats = totalSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hall hall = (Hall) o;
        return id == hall.id && seatsX == hall.seatsX && seatsY == hall.seatsY && totalSeats == hall.totalSeats && Objects.equals(name, hall.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, seatsX, seatsY, totalSeats);
    }
}

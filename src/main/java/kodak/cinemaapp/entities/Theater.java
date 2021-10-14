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
@Table (name = "theaters")
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String name;

    @Column
    String location;

    @Column(name = "nr_of_halls")
    int nrOfHalls;

    @OneToMany(mappedBy = "theater")
    List<Hall> halls = new ArrayList<>();

    public Theater(String name, String location, int nrOfHalls) {
        this.name = name;
        this.location = location;
        this.nrOfHalls = nrOfHalls;
    }

    public Theater(String name, String location, int nrOfHalls, List<Hall> halls) {
        this.name = name;
        this.location = location;
        this.nrOfHalls = nrOfHalls;
        this.halls = halls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Theater theater = (Theater) o;
        return id == theater.id && nrOfHalls == theater.nrOfHalls && Objects.equals(name, theater.name) && Objects.equals(location, theater.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, nrOfHalls);
    }
}

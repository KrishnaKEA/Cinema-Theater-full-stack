package kodak.cinemaapp.entities.movieTheater;

import kodak.cinemaapp.entities.hall.Hall;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name = "movie_theater")
public class MovieTheater {

    @Id
    private Long id;
    private String name;
    private String location;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Hall> halls = new ArrayList<>();

    public MovieTheater(Long id, String name, String location, List<Hall> halls) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.halls = halls;
    }
}

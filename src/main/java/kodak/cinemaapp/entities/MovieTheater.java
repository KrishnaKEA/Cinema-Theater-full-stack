package kodak.cinemaapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "movie_theater")
public class MovieTheater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String location;
    private int noOfHalls;

    public MovieTheater(String name, String location, int noOfHalls) {
        this.name = name;
        this.location = location;
        this.noOfHalls = noOfHalls;
    }
    @OneToMany(mappedBy = "movieTheater",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JsonIgnore
    List<MovieHall> movieHalls = new ArrayList<>();


}

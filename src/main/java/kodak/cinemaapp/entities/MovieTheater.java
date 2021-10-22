package kodak.cinemaapp.entities;

<<<<<<< HEAD
=======
import com.fasterxml.jackson.annotation.JsonIgnore;
>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

<<<<<<< HEAD
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
=======
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed

@NoArgsConstructor
@Entity
@Getter
@Setter
<<<<<<< HEAD
=======
@Table(name = "movie_theater")
>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed
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
<<<<<<< HEAD
=======
    @OneToMany(mappedBy = "movieTheater",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JsonIgnore
    List<MovieHall> movieHalls = new ArrayList<>();


>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed
}

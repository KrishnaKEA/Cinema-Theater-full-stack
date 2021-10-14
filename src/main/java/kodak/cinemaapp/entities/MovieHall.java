package kodak.cinemaapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class MovieHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private char hallName;
    private int seatsX;
    private int seatsY;

    public MovieHall(char hallName, int seatsX, int seatsY, MovieTheater movieTheater) {
        this.hallName = hallName;
        this.seatsX = seatsX;
        this.seatsY = seatsY;
        this.movieTheater = movieTheater;
    }

    @OneToMany(mappedBy = "movieHall",fetch = FetchType.LAZY)
    @JsonIgnore
    List<Schedule> schedules = new ArrayList<>();

    // Hall* ---> 1 MovieTheater
    @ManyToOne
    MovieTheater movieTheater;

}

package kodak.cinemaapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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
    private int seatCount;



    public MovieHall(char hallName, int seatCount, MovieTheater movieTheater) {
        this.hallName = hallName;
        this.seatCount = seatCount;
        this.movieTheater = movieTheater;
    }

    @OneToMany(mappedBy = "movieHall",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Schedule> seats;

    @OneToMany(mappedBy = "movieHall",fetch = FetchType.LAZY)
    @JsonIgnore
    List<Schedule> schedules = new ArrayList<>();

    // Hall* ---> 1 MovieTheater
    @ManyToOne
    MovieTheater movieTheater;


}

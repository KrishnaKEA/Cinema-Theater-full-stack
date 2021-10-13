package kodak.cinemaapp.entities.schedule;

import kodak.cinemaapp.entities.hall.Hall;
import kodak.cinemaapp.entities.movie.Movie;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

//@Data @NoArgsConstructor
//@Entity
//public class Schedule {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    private Date chosenDate;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "schedule_id")
//    private Movie movie;
//
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "schedule")
//    private Hall hall;
//
//    public Schedule(Date chosenDate, Movie movie, Hall hall) {
//        this.chosenDate = chosenDate;
//        this.movie = movie;
//        this.hall = hall;
//    }
//}

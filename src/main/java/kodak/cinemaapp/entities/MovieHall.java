package kodak.cinemaapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
<<<<<<< HEAD
import kodak.cinemaapp.repo.SeatRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
=======
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
>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed
public class MovieHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private char hallName;
<<<<<<< HEAD
    @OneToMany(mappedBy = "hall",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    List<Seat> seatList = new ArrayList<>();
    private String showSlot;


    public MovieHall(char hallName, List<Seat> seatList, String showSlot) {
        this.hallName = hallName;
        this.seatList = seatList;
        this.showSlot = showSlot;
    }


    public void addSeat(Seat seat){
        seatList.add(seat);
        seat.setHall(this);
    }
public List<Seat> populateSeats(int num){

        for(int i = 0; i< num; i++){
           seatList.add(new Seat());
        }

        return seatList;
}
public List<Seat>getMySeatList(){

    for(int i =0; i<seatList.size();i++){
        seatList.get(i).setHall(this);
    }
        return seatList;
}
=======
    private int seatCount;



    public MovieHall(char hallName, int seatCount, MovieTheater movieTheater) {
        this.hallName = hallName;
        this.seatCount = seatCount;
        this.movieTheater = movieTheater;
    }

    @OneToMany(mappedBy = "movieHall",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Schedule> seats;
>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed

    @OneToMany(mappedBy = "movieHall",fetch = FetchType.LAZY)
    @JsonIgnore
    List<Schedule> schedules = new ArrayList<>();

<<<<<<< HEAD
=======
    // Hall* ---> 1 MovieTheater
    @ManyToOne
    MovieTheater movieTheater;


>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed
}

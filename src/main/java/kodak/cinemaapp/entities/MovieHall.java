package kodak.cinemaapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class MovieHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private char hallName;
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

    @OneToMany(mappedBy = "movieHall",fetch = FetchType.LAZY)
    @JsonIgnore
    List<Schedule> schedules = new ArrayList<>();

}

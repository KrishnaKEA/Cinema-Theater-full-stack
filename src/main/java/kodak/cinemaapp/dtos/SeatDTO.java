package kodak.cinemaapp.dtos;


import kodak.cinemaapp.entities.BookedSeat;
import kodak.cinemaapp.entities.Seat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class SeatDTO {

    private int id;
    private int seatNumber;
    //private char hallName;


    public SeatDTO(Seat seat){
        this.id = seat.getId();
        this.seatNumber = seat.getSeatNumber();
        //this.hallName = seat.getMovieHall().getHallName();
    }


    public static List<SeatDTO> SeatDTOSFromSeat(Iterable<Seat> Seats){
        List<SeatDTO> SeatDTOS = new ArrayList<>();
        for(Seat s : Seats){
            SeatDTO SeatDTO = new SeatDTO(s);
            SeatDTOS.add(SeatDTO);
        }
        return SeatDTOS;
    }

}

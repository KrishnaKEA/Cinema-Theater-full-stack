package kodak.cinemaapp.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import kodak.cinemaapp.entities.Hall;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@NoArgsConstructor
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HallDTO {

    int id;
    String name;
    int seatsX;
    int seatsY;
    int totalSeats = seatsX*seatsY;

    public HallDTO(int seatsX, int seatsY, int totalSeats) {
        this.seatsX = seatsX;
        this.seatsY = seatsY;
        this.totalSeats = totalSeats;
    }

    public HallDTO(Hall hall) {
        this.name = hall.getName();
        this.seatsX = hall.getSeatsX();
        this.seatsY = hall.getSeatsY();
        this.totalSeats = hall.getTotalSeats();
        this.id = hall.getId();
    }

    public static List<HallDTO> hallDTOSfromHall(Iterable<Hall> halls){
        List<HallDTO> dtos = StreamSupport.stream(halls.spliterator(), false)
                .map(hall -> new HallDTO(hall))
                .collect(Collectors.toList());
        return dtos;
    }

    public static Hall hallFromHallDTO(HallDTO hall){
        return new Hall(hall.getName(), hall.getSeatsX(), hall.getSeatsY(), hall.getTotalSeats());
    }

}

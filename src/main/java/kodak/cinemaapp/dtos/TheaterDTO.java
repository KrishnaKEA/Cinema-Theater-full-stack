package kodak.cinemaapp.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import kodak.cinemaapp.entities.Theater;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@NoArgsConstructor
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TheaterDTO {

    int id;
    String name;
    String location;
    int nrOfHalls;

    public TheaterDTO(String name, String location, int nrOfHalls) {
        this.name = name;
        this.location = location;
        this.nrOfHalls = nrOfHalls;
    }

    public TheaterDTO(Theater theater){
        this.name = theater.getName();
        this.location = theater.getLocation();
        this.nrOfHalls = theater.getNrOfHalls();
        this.id = theater.getId();
    }

    public static List<TheaterDTO> theaterDTOSfromTheater(Iterable<Theater> theaters){
        List<TheaterDTO> dtos = StreamSupport.stream(theaters.spliterator(), false)
                .map(theater -> new TheaterDTO(theater))
                .collect(Collectors.toList());
        return dtos;
    }

    public static Theater theaterFromTheaterDTO(TheaterDTO theater) {
        return new Theater(theater.getName(), theater.getLocation(), theater.getNrOfHalls());
    }
}

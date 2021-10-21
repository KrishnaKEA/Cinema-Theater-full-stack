package kodak.cinemaapp.DTO;

import kodak.cinemaapp.entities.Movie;
import kodak.cinemaapp.entities.MovieHall;
import kodak.cinemaapp.entities.Seat;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class MovieHallDTO {
    private int id;
    private char hallName;
    private List<Seat> seatList;
    private String showSlot;

    public MovieHallDTO(char hallName, List<Seat> seatList, String showSlot) {
        this.hallName = hallName;
        this.seatList = seatList;
        this.showSlot = showSlot;
    }
    public MovieHallDTO(MovieHall movieHall){
        this.id = movieHall.getId();
        this.hallName = movieHall.getHallName();
        this.seatList = movieHall.getSeatList();
        this.showSlot = movieHall.getShowSlot();
    }
    public static List<MovieHallDTO> movieHallDTOSFromMovie(Iterable<MovieHall> movieHalls){
        List<MovieHallDTO> mhDTOs = new ArrayList<>();
        for(MovieHall moviehall: movieHalls){
            MovieHallDTO moviehD = new MovieHallDTO(moviehall);
            mhDTOs.add(moviehD);
        }
        return mhDTOs;
    }

    public static MovieHall movieHallFromMovieHallDTO(MovieHallDTO movieHallDTO){
        return new MovieHall(movieHallDTO.getHallName(),movieHallDTO.getSeatList(),movieHallDTO.getShowSlot());
    }


}

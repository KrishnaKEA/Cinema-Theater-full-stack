package kodak.cinemaapp.DTO;

import kodak.cinemaapp.entities.Movie;
import kodak.cinemaapp.entities.MovieHall;
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
    private int seat;
    private String showSlot;

    public MovieHallDTO(char hallName, int seat, String showSlot) {
        this.hallName = hallName;
        this.seat = seat;
        this.showSlot = showSlot;
    }
    public MovieHallDTO(MovieHall movieHall){
        this.id = movieHall.getId();
        this.hallName = movieHall.getHallName();
        this.seat = movieHall.getSeat();
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
        return new MovieHall(movieHallDTO.getHallName(),movieHallDTO.getSeat(),movieHallDTO.getShowSlot());
    }
}

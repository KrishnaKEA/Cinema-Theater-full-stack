package kodak.cinemaapp.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import kodak.cinemaapp.entities.Hall;
import kodak.cinemaapp.entities.Movie;
import kodak.cinemaapp.entities.Showing;
import kodak.cinemaapp.entities.Slot;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@NoArgsConstructor
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShowingDTO {

    int id;
    Movie movie;
    Slot slot;
    Hall hall;

    public ShowingDTO(Movie movie, Slot slot, Hall hall) {
        this.movie = movie;
        this.slot = slot;
        this.hall = hall;
    }

    public ShowingDTO(Showing showing) {
        this.movie = showing.getMovie();
        this.slot = showing.getSlot();
        this.hall = showing.getHall();
        this.id = showing.getId();
    }

    public static List<ShowingDTO> showingDTOSfromShowing(Iterable<Showing> showings) {
        List<ShowingDTO> dtos = StreamSupport.stream(showings.spliterator(), false)
                .map(showing -> new ShowingDTO(showing))
                .collect(Collectors.toList());
        return dtos;
    }

    public static Showing showingFromShowingDTO(ShowingDTO showing) {
        return new Showing(showing.getMovie(),showing.getHall(), showing.getSlot());
    }

}

package kodak.cinemaapp.DTOs;

import com.fasterxml.jackson.annotation.JsonInclude;
import kodak.cinemaapp.entities.movie.Movie;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data @NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieDTO {

    private Long id;
    private String story;
    private String rating;
    private String actor;

    // Use this for incoming JSON
    public MovieDTO(String story, String rating, String actor) {
        this.story = story;
        this.rating = rating;
        this.actor = actor;
    }

    public MovieDTO(Movie movie){
        this.story = movie.getStory();
        this.actor = movie.getActor();
        this.rating = movie.getRating();
        this.id = movie.getId();
    }

    public static List<MovieDTO> movieToMovieDTO(Iterable<Movie> movies){
        List<MovieDTO> movieDTOS = new ArrayList<>();
        for (Movie movie : movies){
            MovieDTO mvDTO = new MovieDTO(movie);
            movieDTOS.add(mvDTO);
        }
        return movieDTOS;
    }

    public static Movie movieDtoToMovie(MovieDTO movieDTO){
        return new Movie(movieDTO.getStory(), movieDTO.getActor(), movieDTO.getRating());
    }
}

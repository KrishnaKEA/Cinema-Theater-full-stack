package kodak.cinemaapp.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import kodak.cinemaapp.entities.Movie;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data @NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieDTO {

    private int id;
    private String title;
    private String story;
    private String posterLink;


    // Use this for incoming JSON
    public MovieDTO(String title, String story, String posterLink) {
        this.title = title;
        this.story = story;
        this.posterLink = posterLink;

    }

    public MovieDTO(Movie movie){
        this.story = movie.getStory();
        this.title= movie.getTitle();
        this.posterLink = movie.getPosterLink();
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
        return new Movie(movieDTO.getTitle(),movieDTO.getStory(), movieDTO.getPosterLink() );
    }
}

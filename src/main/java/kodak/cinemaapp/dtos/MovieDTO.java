package kodak.cinemaapp.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import kodak.cinemaapp.entities.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@NoArgsConstructor
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieDTO {

    int id;
    String title;
    String ageGroup;
    String cast;
    String description;
    boolean rating;

    public MovieDTO(String title, String ageGroup, String cast, String description, boolean rating) {
        this.title = title;
        this.ageGroup = ageGroup;
        this.cast = cast;
        this.description = description;
        this.rating = rating;
    }

    public MovieDTO(Movie movie){
        this.title = movie.getTitle();
        this.ageGroup = movie.getAgeGroup();
        this.cast = movie.getCast();
        this.description = movie.getDescription();
        this.rating = movie.isRating();
        this.id = movie.getId();
    }

    public static List<MovieDTO> movieDTOSfromMovie(Iterable<Movie> movies){
        List<MovieDTO> dtos = StreamSupport.stream(movies.spliterator(), false)
                .map(movie -> new MovieDTO(movie))
                .collect(Collectors.toList());
        return dtos;
    }

    public static Movie movieFromMovieDTO(MovieDTO movie) {
        return new Movie(movie.getTitle(), movie.getAgeGroup(), movie.getCast(), movie.description, movie.isRating());
    }

}
package kodak.cinemaapp.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import kodak.cinemaapp.entities.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieDTO {
     int id;
     String title;
     String ageGroup;
     String actor;
     String description;
     String rating;

    public MovieDTO(String title, String ageGroup, String actor, String description, String rating) {
        this.title = title;
        this.ageGroup = ageGroup;
        this.actor = actor;
        this.description = description;
        this.rating = rating;
    }
    public MovieDTO(Movie movie){
        this.title = movie.getTitle();
        this.ageGroup = movie.getAgeGroup();
        this.description = movie.getDescription();
        this.rating = movie.getRating();
        this.id = movie.getId();
    }
    public static List<MovieDTO> movieDTOSFromMovie(Iterable<Movie> movies){
        List<MovieDTO> mDTOs = new ArrayList<>();
        for(Movie movie: movies){
            MovieDTO movieD = new MovieDTO(movie);
            mDTOs.add(movieD);
        }
        return mDTOs;
    }
    public static Movie movieFromMovieDTO(MovieDTO movieDTO){
        return new Movie(movieDTO.getTitle(),movieDTO.getAgeGroup(),movieDTO.getActor(),movieDTO.getDescription(),movieDTO.getRating());
    }
}

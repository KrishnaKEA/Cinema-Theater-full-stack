package kodak.cinemaapp.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter @Setter
@Table (name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "movie_title")
    String title;

    @Column(name = "age_group")
    String ageGroup;

    @Column(name = "movie_cast")
    String cast;

    @Column(name = "movie_description")
    String description;

    @Column
    String rating;

    @ManyToOne
    Hall hall;

    @OneToMany(mappedBy = "movie")
    List<Showing> showings = new ArrayList<>();

    public Movie(String title, String ageGroup, String cast, String description, String rating) {
        this.title = title;
        this.ageGroup = ageGroup;
        this.cast = cast;
        this.description = description;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id && rating == movie.rating && Objects.equals(title, movie.title) && Objects.equals(ageGroup, movie.ageGroup) && Objects.equals(cast, movie.cast) && Objects.equals(description, movie.description) && Objects.equals(hall, movie.hall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, ageGroup, cast, description, rating, hall);
    }
}

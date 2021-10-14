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
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String title;

    @Column
    String ageGroup;

    @Column
    String cast;

    @Column
    String description;

    @Column
    boolean rating;

    @ManyToOne
    Hall hall;

    @OneToMany(mappedBy = "movie")
    List<Showing> showings = new ArrayList<>();

    public Movie(String title, String ageGroup, String cast, String description, Boolean rating) {
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

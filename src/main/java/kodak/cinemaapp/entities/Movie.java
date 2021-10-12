package kodak.cinemaapp.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String ageGroup;
    private String actor;
    private String description;
    private boolean rating;

    public Movie(String title, String ageGroup, String actor, String description, boolean rating) {
        this.title = title;
        this.ageGroup = ageGroup;
        this.actor = actor;
        this.description = description;
        this.rating = rating;
    }
}

package kodak.cinemaapp.entities.movie;

import kodak.cinemaapp.entities.hall.Hall;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String story;
    private String rating;
    private String actor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hall_id")
    private Hall hall;

    public Movie(String title, String story, String rating, String actor, Hall hall) {
        this.title = title;
        this.story = story;
        this.rating = rating;
        this.actor = actor;
        this.hall = hall;
    }

    public Movie(String story, String actor, String rating) {
    }


}

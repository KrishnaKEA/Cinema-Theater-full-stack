package kodak.cinemaapp.entities;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
=======
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
<<<<<<< HEAD
@NoArgsConstructor
@Getter
@Setter
=======
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "movies")
>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String ageGroup;
    private String actor;
<<<<<<< HEAD
    private String description;
    private String rating;

    public Movie(String title, String ageGroup, String actor, String description, String rating) {
        this.title = title;
        this.ageGroup = ageGroup;
        this.actor = actor;
        this.description = description;
        this.rating = rating;
    }
    @OneToMany(mappedBy = "movie",cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.EAGER)
    List<User> Users = new ArrayList<>();


    public void addUser(User user){
        Users.add(user);
        user.setMovie(this);

    }
=======
    private String story;
    private String rating;

    public Movie(String title, String ageGroup, String actor, String story, String rating) {
        this.title = title;
        this.ageGroup = ageGroup;
        this.actor = actor;
        this.story = story;
        this.rating = rating;
    }
    public Movie(String title, String story,String rating) {
    }

>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed
    @OneToMany(mappedBy = "movie",fetch = FetchType.LAZY)
    @JsonIgnore
    List<Schedule> schedules = new ArrayList<>();




<<<<<<< HEAD
=======




>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed
}

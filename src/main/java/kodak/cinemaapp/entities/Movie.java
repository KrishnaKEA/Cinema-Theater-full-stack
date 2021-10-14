package kodak.cinemaapp.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private String rating;

    public Movie(String title, String ageGroup, String actor, String description, String rating) {
        this.title = title;
        this.ageGroup = ageGroup;
        this.actor = actor;
        this.description = description;
        this.rating = rating;
    }
    @OneToMany(mappedBy = "movie",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    List<User> Users = new ArrayList<>();


    public void addUser(User user){
        Users.add(user);
        user.setMovie(this);

    }





}

package kodak.cinemaapp.entities.user;

import lombok.Data;
import lombok.NoArgsConstructor;



import javax.persistence.*;

@Data @NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "dob")
    private String dob;
    @Column(name = "email")
    private String email;

    public User(String firstName, String lastName, String dob, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.email = email;
    }
}

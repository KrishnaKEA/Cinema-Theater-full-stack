package kodak.cinemaapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String email;
    @Column(length = 12)
    private int phoneNumber;
    private LocalDate birthDate;


    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    @JsonIgnore
    List<Booking> bookings = new ArrayList<>();


    public User(String fName, String lName, String email, int phoneNumber, LocalDate birthDate) {
        this.firstName = fName;
        this.lastName = lName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }

}

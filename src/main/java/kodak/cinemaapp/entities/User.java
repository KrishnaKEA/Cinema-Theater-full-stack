package kodak.cinemaapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
<<<<<<< HEAD
import lombok.AllArgsConstructor;
=======
>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
<<<<<<< HEAD
@AllArgsConstructor
=======
@Table(name = "user")
>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50,nullable = false)
    private String fName;
    @Column(length = 50,nullable = false)
    private String lName;
    @Column(length = 100,nullable = false)
    private String email;
    @Column(length = 12)
    private long phoneNumber;
    private LocalDate birthDate;

<<<<<<< HEAD
=======

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    @JsonIgnore
    List<Booking> bookings = new ArrayList<>();


>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed
    public User(String fName, String lName, String email, long phoneNumber, LocalDate birthDate) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
<<<<<<< HEAD

    }
    @ManyToOne
    Movie movie;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    @JsonIgnore
    List<Booking> bookingList = new ArrayList<>();
public void addBooking(Booking booking){
    bookingList.add(booking);
    booking.setUser(this);
}

=======
    }
>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed

}

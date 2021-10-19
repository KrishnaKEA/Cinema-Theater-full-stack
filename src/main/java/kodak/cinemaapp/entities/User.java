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
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
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

    public User(String fName, String lName, String email, long phoneNumber, LocalDate birthDate) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;

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


}

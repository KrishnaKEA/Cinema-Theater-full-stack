package kodak.cinemaapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
<<<<<<< HEAD
=======
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
<<<<<<< HEAD

=======
@Table(name = "slot")
>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public Slot(String name) {
        this.name = name;
    }
<<<<<<< HEAD
=======


>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed
    @OneToMany(mappedBy = "slot",fetch = FetchType.LAZY)
    @JsonIgnore
    List<Schedule> schedules = new ArrayList<>();
}

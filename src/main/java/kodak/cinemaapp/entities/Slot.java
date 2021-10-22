package kodak.cinemaapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "slot")
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public Slot(String name) {
        this.name = name;
    }


    @OneToMany(mappedBy = "slot",fetch = FetchType.LAZY)
    @JsonIgnore
    List<Schedule> schedules = new ArrayList<>();
}

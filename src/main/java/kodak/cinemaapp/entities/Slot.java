package kodak.cinemaapp.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode

public class Slot {
    @Id
    private int id;
    private String name;

    public Slot(String name) {
        this.name = name;
    }
}

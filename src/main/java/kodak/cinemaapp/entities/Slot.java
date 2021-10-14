package kodak.cinemaapp.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Slot {

    public enum SlotTime{
        MORNING, AFTERNOON, EVENING
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    SlotTime slot;

    @ManyToOne(cascade = CascadeType.ALL)
    Schedule schedule;

    public Slot(SlotTime slot) {
        this.slot = slot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Slot slot1 = (Slot) o;
        return id == slot1.id && slot == slot1.slot;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, slot);
    }
}

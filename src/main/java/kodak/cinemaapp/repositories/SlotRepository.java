package kodak.cinemaapp.repositories;

import kodak.cinemaapp.entities.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SlotRepository extends JpaRepository<Slot, Integer> {
    List<Slot> findSlotById(int id);
}

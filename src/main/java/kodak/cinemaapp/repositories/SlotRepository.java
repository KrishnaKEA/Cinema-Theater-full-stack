package kodak.cinemaapp.repositories;

import kodak.cinemaapp.entities.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlotRepository extends JpaRepository<Slot, Integer> {
}

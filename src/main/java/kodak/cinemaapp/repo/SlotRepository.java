package kodak.cinemaapp.repo;


import kodak.cinemaapp.entities.Slot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SlotRepository extends CrudRepository<Slot,Integer> {

    Slot findSlotByName(String name);
}

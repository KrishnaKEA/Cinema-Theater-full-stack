package kodak.cinemaapp.repo;

<<<<<<< HEAD
import kodak.cinemaapp.entities.Slot;
import org.springframework.data.repository.CrudRepository;

public interface SlotRepository extends CrudRepository<Slot,Integer> {
=======

import kodak.cinemaapp.entities.Slot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SlotRepository extends CrudRepository<Slot,Integer> {

    Slot findSlotByName(String name);
>>>>>>> 156a0cdd556eb42598e252abe799268ee73e92ed
}

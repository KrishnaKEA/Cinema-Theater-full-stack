package kodak.cinemaapp.service;

import kodak.cinemaapp.DTO.SlotDTO;
import kodak.cinemaapp.entities.Slot;
import kodak.cinemaapp.repo.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SlotService {
    @Autowired
    SlotRepository slotRepository;
    public List<SlotDTO> getAllSlot(){
        return SlotDTO.slotDTOSFromSlot(slotRepository.findAll());
    }
    public SlotDTO getSlot(int id){
        Slot Slot = slotRepository.findById(id).orElseThrow();
        return new SlotDTO(Slot);
    }
    public SlotDTO addBoking(SlotDTO SlotToAdd){
        Slot slotTobeAdded = SlotDTO.slotFromSlotDTO(SlotToAdd);
        return new SlotDTO (slotRepository.save(slotTobeAdded));
    }
    public SlotDTO editSlot(SlotDTO slotToEdit,int id){
        Slot SlotOriginal = slotRepository.findById(id).orElseThrow();
        SlotOriginal.setId(slotToEdit.getId());
        SlotOriginal.setName(slotToEdit.getName());
        return new SlotDTO(slotRepository.save(SlotOriginal));
    }
}

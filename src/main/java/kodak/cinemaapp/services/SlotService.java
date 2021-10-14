package kodak.cinemaapp.services;


import kodak.cinemaapp.dtos.ShowingDTO;
import kodak.cinemaapp.dtos.SlotDTO;
import kodak.cinemaapp.entities.Showing;
import kodak.cinemaapp.entities.Slot;
import kodak.cinemaapp.repositories.SlotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlotService {

    SlotRepository slotRepository;

    public SlotService(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    public List<SlotDTO> getSlots(Slot.SlotTime slot){
        if(slot!=null){
            return SlotDTO.slotDTOSfromSlot(slotRepository.findSlotBySlot(slot));
        }
        return SlotDTO.slotDTOSfromSlot(slotRepository.findAll());
    }

    public SlotDTO getSlot(int id){
        Slot slot = slotRepository.findById(id).orElseThrow();
        return new SlotDTO(slot);
    }

    public SlotDTO addSlot(SlotDTO newSlot){
        Slot slotToAdd = SlotDTO.slotFromSlotDTO(newSlot);
        return new SlotDTO(slotRepository.save(slotToAdd));
    }

    public SlotDTO editSlot(SlotDTO slotToEdit, int id){
        Slot slotOrg = slotRepository.findById(id).orElseThrow();
        slotOrg.setSlot(slotToEdit.getSlot());
        return new SlotDTO(slotRepository.save(slotOrg));
    }

    public void deleteSlot(int id) {
        slotRepository.deleteById(id);
    }

}

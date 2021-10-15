package kodak.cinemaapp.rest;

import kodak.cinemaapp.dtos.HallDTO;
import kodak.cinemaapp.dtos.SlotDTO;
import kodak.cinemaapp.entities.Slot;
import kodak.cinemaapp.services.SlotService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/slots")
public class SlotController {

    SlotService slotService;

    @GetMapping
    List<SlotDTO> getSlots(@RequestParam(required = false) Slot.SlotTime slot){
        if (slot==null){
            throw new IllegalStateException();
        }
        return slotService.getSlots(slot);
    }

    @GetMapping("/{id}")
    SlotDTO getSlot(@PathVariable int id){
        return slotService.getSlot(id);
    }

    @PostMapping
    SlotDTO addSlot(@RequestBody SlotDTO newSlot){
        return slotService.addSlot(newSlot);
    }

    @PutMapping("/{id}")
    SlotDTO editSlot(@RequestBody SlotDTO slotToEdit, @PathVariable int id) throws Exception{
        return slotService.editSlot(slotToEdit, id);
    }

    @DeleteMapping("/{id}")
    void deleteSlot(@PathVariable int id){
        slotService.deleteSlot(id);
    }



}

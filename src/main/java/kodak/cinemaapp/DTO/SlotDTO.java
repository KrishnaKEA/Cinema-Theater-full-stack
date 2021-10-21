package kodak.cinemaapp.DTO;

//import kodak.cinemaapp.entities.Booking;
import kodak.cinemaapp.entities.Slot;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SlotDTO {
    private int id;
    private String name;
    public SlotDTO(String name){
        this.name = name;
    }
    public SlotDTO(Slot slot){
        this.id = slot.getId();
        this.name = slot.getName();
    }
    public static List<SlotDTO> slotDTOSFromSlot(Iterable<Slot> slots) {
        List<SlotDTO> newslots = new ArrayList<>();
        for (Slot s : slots) {
            SlotDTO sD = new SlotDTO(s);
            newslots.add(sD);
        }
        return newslots;
    }
    public static Slot slotFromSlotDTO(SlotDTO slotDTO){
        return new Slot(slotDTO.getName());}

}





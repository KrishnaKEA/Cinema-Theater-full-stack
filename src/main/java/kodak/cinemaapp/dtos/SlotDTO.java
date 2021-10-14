package kodak.cinemaapp.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import kodak.cinemaapp.entities.Slot;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@NoArgsConstructor
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SlotDTO {

    int id;
    Slot.SlotTime slot;

    public SlotDTO(Slot.SlotTime slot) {
        this.slot = slot;
    }

    public SlotDTO(Slot slot){
        this.slot = slot.getSlot();
        this.id = slot.getId();
    }

    public static List<SlotDTO> slotDTOSfromSlot(Iterable<Slot> slots){
        List<SlotDTO> dtos = StreamSupport.stream(slots.spliterator(), false)
                .map(slot -> new SlotDTO(slot))
                .collect(Collectors.toList());
        return dtos;
    }

    public static Slot slotFromSlotDTO(SlotDTO slot){
        return new Slot(slot.getSlot());
    }
}

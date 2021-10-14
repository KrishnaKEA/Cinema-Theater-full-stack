package kodak.cinemaapp.services;


import kodak.cinemaapp.repositories.SlotRepository;
import org.springframework.stereotype.Service;

@Service
public class SlotService {

    SlotRepository slotRepository;

    public SlotService(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

}

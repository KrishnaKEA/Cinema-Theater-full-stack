package kodak.cinemaapp.services;

import kodak.cinemaapp.repositories.SlotRepository;

public class SlotService {

    SlotRepository slotRepository;

    public SlotService(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }
}

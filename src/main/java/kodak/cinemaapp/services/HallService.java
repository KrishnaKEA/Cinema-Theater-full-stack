package kodak.cinemaapp.services;

import kodak.cinemaapp.repositories.HallRepository;

public class HallService {

    HallRepository hallRepository;

    public HallService(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }
}

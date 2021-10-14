package kodak.cinemaapp.services;

import kodak.cinemaapp.repositories.TheaterRepository;

public class TheaterService {

    TheaterRepository theaterRepository;

    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }
}

package kodak.cinemaapp.services;

import kodak.cinemaapp.dtos.ShowingDTO;
import kodak.cinemaapp.entities.Showing;
import kodak.cinemaapp.repositories.ShowingRepository;

import java.util.List;

public class ShowingService {

    ShowingRepository showingRepository;

    public ShowingService(ShowingRepository showingRepository) {
        this.showingRepository = showingRepository;
    }

    public List<ShowingDTO> getShowings(){
        Iterable<Showing> showings = showingRepository.findAll();
        return ShowingDTO.showingDTOSfromShowing(showings);
    }

}
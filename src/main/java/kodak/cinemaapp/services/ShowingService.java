package kodak.cinemaapp.services;

import kodak.cinemaapp.dtos.ShowingDTO;
import kodak.cinemaapp.dtos.TheaterDTO;
import kodak.cinemaapp.entities.Hall;
import kodak.cinemaapp.entities.Movie;
import kodak.cinemaapp.entities.Showing;
import kodak.cinemaapp.entities.Slot;
import kodak.cinemaapp.repositories.ShowingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowingService {

    ShowingRepository showingRepository;

    public ShowingService(ShowingRepository showingRepository) {
        this.showingRepository = showingRepository;
    }

    public List<ShowingDTO> getShowings(String movie, String ageGroup, String slot){
        if(movie!=null){
            return ShowingDTO.showingDTOSfromShowing(showingRepository.findShowingsByMovieTitle(movie));
        }if(hall!=null){
            return ShowingDTO.showingDTOSfromShowing(showingRepository.findShowingsByMovieAgeGroup(ageGroup));
        }
        if(slot!=null){
            return ShowingDTO.showingDTOSfromShowing(showingRepository.findShowingsBySlotEquals(slot));
        }
        return ShowingDTO.showingDTOSfromShowing(showingRepository.findAll());
    }

    public ShowingDTO getshowing(int id){
        Showing showing = showingRepository.findById(id).orElseThrow();
        return new ShowingDTO(showing);
    }

    public ShowingDTO add(ShowingDTO newShowing){
        Showing showingToAdd = ShowingDTO.showingFromShowingDTO(newShowing);
        return new ShowingDTO(showingRepository.save(showingToAdd));
    }

    public ShowingDTO editShowing(ShowingDTO showingToEdit, int id){
        Showing showingOrg = showingRepository.findById(id).orElseThrow();
        showingOrg.setMovie(showingToEdit.getMovie());
        showingOrg.setHall(showingToEdit.getHall());
        showingOrg.setSlot(showingToEdit.getSlot());
        return new ShowingDTO(showingRepository.save(showingOrg));
    }

    public void deleteShowing(int id){
        showingRepository.deleteById(id);
    }

}
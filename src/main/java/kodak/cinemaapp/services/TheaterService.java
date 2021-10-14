package kodak.cinemaapp.services;

import kodak.cinemaapp.dtos.TheaterDTO;
import kodak.cinemaapp.entities.Theater;
import kodak.cinemaapp.repositories.TheaterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterService {

    TheaterRepository theaterRepository;

    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    public List<TheaterDTO> getTheaters(String name, String location, int nrOfHalls){
        if(name!=null && location!=null && nrOfHalls!=0){
            return TheaterDTO.theaterDTOSfromTheater(theaterRepository.findTheaterByNameAndLocationAndNrOfHalls(name, location, nrOfHalls));
        }if(name!=null){
            return TheaterDTO.theaterDTOSfromTheater(theaterRepository.findTheaterByName(name));
        }
        if(location!=null){
            return TheaterDTO.theaterDTOSfromTheater(theaterRepository.findTheaterByLocation(location));
        } if (nrOfHalls!=0){
            return TheaterDTO.theaterDTOSfromTheater(theaterRepository.findTheaterByNrOfHalls(nrOfHalls));
        }
        return TheaterDTO.theaterDTOSfromTheater(theaterRepository.findAll());
    }

    public TheaterDTO getTheater(int id){
        Theater theater = theaterRepository.findById(id).orElseThrow();
        return new TheaterDTO(theater);
    }

    public TheaterDTO addTheater(TheaterDTO newTheater){
        Theater theaterToAdd = TheaterDTO.theaterFromTheaterDTO(newTheater);
        return new TheaterDTO(theaterRepository.save(theaterToAdd));
    }

    public TheaterDTO editTheater(TheaterDTO theaterEdit, int id){
        Theater theaterOrg = theaterRepository.findById(id).orElseThrow();
        theaterOrg.setName(theaterEdit.getName());
        theaterOrg.setLocation(theaterEdit.getLocation());
        theaterOrg.setNrOfHalls(theaterEdit.getNrOfHalls());
        return new TheaterDTO(theaterRepository.save(theaterOrg));
    }

    public void deleteTheater(int id){
        theaterRepository.deleteById(id);
    }

}

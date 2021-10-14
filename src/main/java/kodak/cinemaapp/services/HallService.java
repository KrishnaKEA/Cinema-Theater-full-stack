package kodak.cinemaapp.services;

import kodak.cinemaapp.dtos.HallDTO;

import kodak.cinemaapp.entities.Hall;
import kodak.cinemaapp.repositories.HallRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallService {

    HallRepository hallRepository;

    public HallService(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    public List<HallDTO> getHalls(String name, int seatsX, int seatsY){
        if(name!=null && seatsX!=0 && seatsY!=0){
            return HallDTO.hallDTOSfromHall(hallRepository.findHallByNameAndSeatsXAndSeatsY(name, seatsX, seatsY));
        }if(name!=null){
            return HallDTO.hallDTOSfromHall((hallRepository.findHallByName(name)));
        }if(seatsX!=0){
            return HallDTO.hallDTOSfromHall(hallRepository.findHallsBySeatsX(seatsX));
        }if (seatsY!=0){
            return HallDTO.hallDTOSfromHall(hallRepository.findHallsBySeatsY(seatsY));
        }
        return HallDTO.hallDTOSfromHall(hallRepository.findAll());
    }

    public HallDTO gethall(int id){
        Hall hall = hallRepository.findById(id).orElseThrow();
        return new HallDTO(hall);
    }

    public HallDTO addHall(HallDTO newHall){
        Hall hallToAdd = HallDTO.hallFromHallDTO(newHall);
        return new HallDTO(hallRepository.save(hallToAdd));
    }

    public HallDTO editHall(HallDTO hallToEdit, int id){
        Hall hallOrg = hallRepository.findById(id).orElseThrow();
        hallOrg.setName(hallToEdit.getName());
        hallOrg.setSeatsX(hallToEdit.getSeatsX());
        hallOrg.setSeatsY(hallToEdit.getSeatsY());
        return new HallDTO(hallRepository.save(hallOrg));
    }

    public void deleteHall(int id){
        hallRepository.deleteById(id);
    }
}

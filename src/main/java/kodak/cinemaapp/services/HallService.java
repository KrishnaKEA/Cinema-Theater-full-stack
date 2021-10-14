package kodak.cinemaapp.services;

import kodak.cinemaapp.dtos.TheaterDTO;
import kodak.cinemaapp.repositories.HallRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HallService {

    HallRepository hallRepository;

    public HallService(HallRepository hallRepository) {
        this.hallRepository = hallRepository;
    }

    public List<DTO> get(){
        if(!=null && !=null && !=0){
            return DTO.DTOSfrom(Repository.find);
        }if(!=null){
            return DTO.DTOSfrom(Repository.find);
        }
        if(!=null){
            return DTO.DTOSfrom(Repository.find);
        } if (){
            return DTO.DTOSfrom(Repository.find);
        }
        return DTO.DTOSfrom(Repository.findAll());
    }

    public DTO get(int id){
         = Repository.findById(id).orElseThrow();
        return new DTO();
    }

    public DTO add(TheaterDTO new){
        ToAdd = DTO.FromTheaterDTO(new);
        return new DTO(Repository.save(ToAdd));
    }

    public DTO edit(DTO Edit, int id){
        Org = Repository.findById(id).orElseThrow();
        Org.setName(theaterEdit.getName());
        Org.setLocation(theaterEdit.getLocation());
        Org.setNrOfHalls(theaterEdit.getNrOfHalls());
        return new DTO(Repository.save(Org));
    }

    public void delete(int id){
        Repository.deleteById(id);
    }
}

package kodak.cinemaapp.rest;

import kodak.cinemaapp.dtos.SlotDTO;
import kodak.cinemaapp.dtos.TheaterDTO;
import kodak.cinemaapp.entities.Slot;
import kodak.cinemaapp.services.TheaterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/theaters")
public class TheaterController {

    TheaterService theaterService;

    @GetMapping
    List<TheaterDTO> getTheaters(@RequestParam(required = false) String name, @RequestParam(required = false)String location,@RequestParam(required = false) int nrOfHalls){
        if (name==null && location==null && nrOfHalls==0){
            throw new IllegalStateException();
        }
        return theaterService.getTheaters(name, location, nrOfHalls);
    }

    @GetMapping("/{id}")
    TheaterDTO getSlot(@PathVariable int id){
        return theaterService.getTheater(id);
    }

    @PostMapping
    TheaterDTO addTheater(@RequestBody TheaterDTO newTheater){
        return theaterService.addTheater(newTheater);
    }

    @PutMapping("/{id}")
    TheaterDTO editTheater(@RequestBody TheaterDTO theaterToEdit, @PathVariable int id) throws Exception{
        return theaterService.editTheater(theaterToEdit, id);
    }

    @DeleteMapping("/{id}")
    void deleteTheater(@PathVariable int id){
        theaterService.deleteTheater(id);
    }

}

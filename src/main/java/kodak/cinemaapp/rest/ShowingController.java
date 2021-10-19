package kodak.cinemaapp.rest;

import kodak.cinemaapp.dtos.HallDTO;
import kodak.cinemaapp.dtos.ShowingDTO;
import kodak.cinemaapp.services.ScheduleService;
import kodak.cinemaapp.services.ShowingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/showings")
public class ShowingController {

    ShowingService showingService;

    @GetMapping
    List<ShowingDTO> getShowings(@RequestParam(required = false) String title,@RequestParam(required = false) String ageGroup,@RequestParam(required = false) String slot){
        if (title==null && ageGroup==null && slot==null){
            throw new IllegalStateException();
        }
        return showingService.getShowings(title, ageGroup, slot);
    }

    @GetMapping("/{id}")
    ShowingDTO getHall(@PathVariable int id){
        return showingService.getshowing(id);
    }

    @PostMapping
    ShowingDTO addHall(@RequestBody ShowingDTO newShowing){
        return showingService.addShowing(newShowing);
    }

    @PutMapping("/{id}")
    ShowingDTO editShowing(@RequestBody ShowingDTO showingToEdit, @PathVariable int id) throws Exception{
        return showingService.editShowing(showingToEdit, id);
    }

    @DeleteMapping("/{id}")
    void deleteShowing(@PathVariable int id){
        showingService.deleteShowing(id);
    }



}

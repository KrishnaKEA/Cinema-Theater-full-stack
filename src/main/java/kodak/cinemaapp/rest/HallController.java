package kodak.cinemaapp.rest;

import kodak.cinemaapp.dtos.HallDTO;
import kodak.cinemaapp.services.HallService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/halls")
public class HallController {

    HallService hallService;

    public HallController(HallService hallService) {
        this.hallService = hallService;
    }

    @GetMapping
    List<HallDTO> getHalls(@RequestParam(required = false) String name, int x, int y){
        if (name==null && x == 0 && y == 0){
            throw new IllegalStateException();
        }
        return hallService.getHalls(name, x, y);
    }

    @GetMapping("/{id}")
    HallDTO getHall(@PathVariable int id){
        return hallService.gethall(id);
    }

    @PostMapping
    HallDTO addHall(@RequestBody HallDTO newHall){
        return hallService.addHall(newHall);
    }

    @PutMapping("/{id}")
    HallDTO editHall(@RequestBody HallDTO hallToEdit, @PathVariable int id) throws Exception{
        return hallService.editHall(hallToEdit, id);
    }

    @DeleteMapping("/{id}")
    void deleteHall(@PathVariable int id){
        hallService.deleteHall(id);
    }


}
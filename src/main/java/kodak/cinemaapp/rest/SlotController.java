package kodak.cinemaapp.rest;

import kodak.cinemaapp.services.SlotService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/slots")
public class SlotController {

    SlotService slotService;

}

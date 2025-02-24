package pl.krzysztofadamczak.backend.meeting;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chosenSlots")
@CrossOrigin
public class ChosenSlotsController {

    private final ChosenSlotsService chosenSlotsService;

    ChosenSlotsController(ChosenSlotsService chosenSlotsService) {
        this.chosenSlotsService = chosenSlotsService;
    }

    @GetMapping
    public List<ChosenSlots> getChosenSlots() {
        return chosenSlotsService.findAll();
    }

//    @GetMapping("/{id}/slots")
//    public Meeting getChosedSlots(@PathVariable Long id) {
//        return meetingService.findChosedSlotsByMeetingId(id);
//    }

    @PostMapping
    public Long addMeeting(@RequestBody ChosenSlotsDTO chosenSlots) {
        var createdSlot = chosenSlotsService.create(chosenSlots);
        chosenSlotsService.save(createdSlot);
        return createdSlot.getId();
    }

    @DeleteMapping
    public String deleteChosenSlot(@RequestBody DeleteChosenSlotDTO deleteChosenSlot) {
        return chosenSlotsService.delete(deleteChosenSlot);
    }
}

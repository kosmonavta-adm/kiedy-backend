package pl.krzysztofadamczak.backend.meeting;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meeting")
@CrossOrigin
public class MeetingController {

    private final MeetingService meetingService;

    MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping("/{id}")
    public Meeting getMeetings(@PathVariable Long id) {
        return meetingService.findById(id);
    }

//    @GetMapping("/{id}/slots")
//    public Meeting getChosedSlots(@PathVariable Long id) {
//        return meetingService.findChosedSlotsByMeetingId(id);
//    }

    @PostMapping
    public Long addMeeting(@RequestBody Meeting meeting) {
        var createdMeeting = meetingService.save(meeting);

        return createdMeeting.getId();
    }
}

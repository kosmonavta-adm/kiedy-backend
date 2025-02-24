package pl.krzysztofadamczak.backend.meeting;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingService {
    private final MeetingRepository meetingRepository;

    public MeetingService(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    public Meeting save(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    public Meeting findById(Long id) {
        return meetingRepository.findById(id).orElse(null);
    }

    public List<Meeting> findAll() {
        return meetingRepository.findAll();
    }
}

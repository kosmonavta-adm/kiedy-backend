package pl.krzysztofadamczak.backend.meeting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Long> {
//    Meeting findChosedSlotsByMeeting_IdAndAvailability_Id (Long meetingId);
}

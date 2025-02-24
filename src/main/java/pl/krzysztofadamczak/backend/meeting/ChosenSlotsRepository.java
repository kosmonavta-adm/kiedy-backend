package pl.krzysztofadamczak.backend.meeting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface ChosenSlotsRepository extends JpaRepository<ChosenSlots, Long> {

    @Transactional
    void deleteByTimeAndUserId(Long time, String userId);
}

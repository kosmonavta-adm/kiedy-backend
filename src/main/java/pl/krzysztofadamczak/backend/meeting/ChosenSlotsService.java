package pl.krzysztofadamczak.backend.meeting;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChosenSlotsService {

    private final ChosenSlotsRepository chosenSlotsRepository;
    private final EntityManager entityManager;

    @Autowired
    public ChosenSlotsService(ChosenSlotsRepository chosenSlotsRepository, EntityManager entityManager) {
        this.chosenSlotsRepository = chosenSlotsRepository;
        this.entityManager = entityManager;
    }

    @Transactional
    public ChosenSlots create(ChosenSlotsDTO dto) {
        ChosenSlots slots = new ChosenSlots();
        slots.setTime(dto.getTime());
        slots.setFullName(dto.getFullName());
        slots.setUserId(dto.getUserId());

        Availability availability = entityManager.getReference(Availability.class, dto.getAvailabilityId());
        slots.setAvailability(availability);

        return slots;
    }

    public ChosenSlots findById(Long id) {
        return chosenSlotsRepository.findById(id).orElse(null);
    }

    public ChosenSlots save(ChosenSlots chosenSlot) {
        return chosenSlotsRepository.save(chosenSlot);
    }


//    public ChosenSlots findChosedSlotsByChosenSlotsId(Long meetingId) { return chosenSlotsRepository.findChosedSlotsByChosenSlotsId(meetingId);}

    public String delete(DeleteChosenSlotDTO deleteChosenSlot) {
        System.out.println(deleteChosenSlot.getTime());
        System.out.println(deleteChosenSlot.getUserId());
        chosenSlotsRepository.deleteByTimeAndUserId( deleteChosenSlot.getTime(), deleteChosenSlot.getUserId());
        return null;
    }

    public List<ChosenSlots> findAll() {
        return chosenSlotsRepository.findAll();
    }
}

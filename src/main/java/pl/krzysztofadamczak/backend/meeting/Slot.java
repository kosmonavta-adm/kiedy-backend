package pl.krzysztofadamczak.backend.meeting;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity(name = "slots")
public class Slot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long ending;
    private Long beginning;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonBackReference("availability_slots")
    private Availability availability;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEnding() {
        return ending;
    }

    public void setEnding(Long start) {
        this.ending = start;
    }

    public Long getBeginning() {
        return beginning;
    }

    public void setBeginning(Long beginning) {
        this.beginning = beginning;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }
}

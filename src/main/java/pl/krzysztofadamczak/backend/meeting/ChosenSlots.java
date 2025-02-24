package pl.krzysztofadamczak.backend.meeting;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class ChosenSlots {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long time;
    private String fullName;
    private String userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonBackReference("availability_chosenSlots")
    private Availability availability;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

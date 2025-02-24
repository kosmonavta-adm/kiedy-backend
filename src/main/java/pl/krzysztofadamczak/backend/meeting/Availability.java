package pl.krzysztofadamczak.backend.meeting;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Availability {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonBackReference("meeting_availability")
    private Meeting meeting;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "availability")
    @JsonManagedReference("availability_slots")
    private List<Slot> slots;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "availability")
    @JsonManagedReference("availability_chosenSlots")
    private List<ChosenSlots> chosenSlots;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Meeting getMeeting() {
        return meeting;
    }

    public void setMeeting(Meeting meeting) {
        this.meeting = meeting;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    public List<ChosenSlots> getChosenSlots() {
        return chosenSlots;
    }

    public void setChosenSlots(List<ChosenSlots> chosenSlots) {
        this.chosenSlots = chosenSlots;
    }
}
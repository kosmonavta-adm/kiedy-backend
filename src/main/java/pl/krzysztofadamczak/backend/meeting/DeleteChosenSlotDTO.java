package pl.krzysztofadamczak.backend.meeting;

public class DeleteChosenSlotDTO {
    private String userId;
    private Long time;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}

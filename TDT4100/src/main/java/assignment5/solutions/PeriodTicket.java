package assignment5.solutions;

import java.time.LocalDateTime;

public class PeriodTicket {
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public PeriodTicket(LocalDateTime startTime, LocalDateTime endTime) {
        if (startTime.isAfter(endTime))
            throw new IllegalArgumentException("Start time cannot be after end time.");
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean scan() {
        return LocalDateTime.now().isAfter(startTime) && LocalDateTime.now().isBefore(endTime);
    }
}

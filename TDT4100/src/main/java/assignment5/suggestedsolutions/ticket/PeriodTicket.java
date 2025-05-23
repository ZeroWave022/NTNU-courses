package assignment5.suggestedsolutions.ticket;

import java.time.LocalDateTime;

public class PeriodTicket implements Ticket {

    private final LocalDateTime end;
    private final LocalDateTime start;

    public PeriodTicket(LocalDateTime start, LocalDateTime end) {
        if (start.isAfter(end)) {
            throw new IllegalArgumentException("Start date cannot be after end date");
        }

        this.start = start;
        this.end = end;
    }

    @Override
    public boolean scan() {
        LocalDateTime now = LocalDateTime.now();
        return now.isAfter(this.start) && now.isBefore(this.end);
    }
}

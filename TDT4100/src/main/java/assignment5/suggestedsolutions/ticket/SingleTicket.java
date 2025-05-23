package assignment5.suggestedsolutions.ticket;

public class SingleTicket implements Ticket {

    private boolean scanned = false;

    @Override
    public boolean scan() {
        if (this.scanned) {
            return false;
        }

        this.scanned = true;
        return true;
    }
}

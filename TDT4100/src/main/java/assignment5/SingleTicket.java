package assignment5;

public class SingleTicket implements Ticket {
    private boolean valid = true;

    public boolean scan() {
        if (valid) {
            valid = false;
            return true;
        }
        return false;
    }
}

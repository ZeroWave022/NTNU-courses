package assignment2.suggestedsolutions;

public class UpOrDownCounter {

    private final int direction;
    private final int end;
    private int counter;

    public UpOrDownCounter(int start, int end) {
        if (start == end) {
            throw new IllegalArgumentException("Start and end cannot be the same");
        }

        this.counter = start;
        this.end = end;
        this.direction = Integer.signum(end - start);
    }

    public boolean count() {
        if (this.counter == this.end) {
            return false;
        }

        this.counter += this.direction;
        return this.counter != this.end;
    }

    public int getCounter() {
        return this.counter;
    }

    @Override
    public String toString() {
        return String.format("[UpOrDownCounter counter=%d]", this.counter);
    }
}

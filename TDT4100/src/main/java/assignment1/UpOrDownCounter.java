package assignment1;

public class UpOrDownCounter {
    public int start;
    public int end;
    public int counter;

    UpOrDownCounter(int start, int end) {
        this.start = start;
        this.end = end;
        this.counter = start;
    }

    public int getCounter() {
        return counter;
    }

    public boolean count() {
        if (counter == end)
            return false;

        if (counter < end) {
            this.counter += 1;
        } else {
            this.counter -= 1;
        }

        return counter != end;
    }
}

package assignment1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Digit {
    public int base;
    public int value;
    public final static List<Character> alphabet = IntStream.rangeClosed('A', 'Z').mapToObj(c -> (char) c)
            .collect(Collectors.toList());

    public Digit(int base) {
        this.base = base;
        this.value = 0;
    }

    public boolean increment() {
        if (this.value < this.base - 1) {
            this.value += 1;
            return false;
        }
        this.value = 0;
        return true;
    }

    public String toString() {
        if (value <= 9)
            return String.valueOf(value);
        return alphabet.get(value - 10).toString();
    }

    public int getBase() {
        return base;
    }

    public int getValue() {
        return value;
    }
}

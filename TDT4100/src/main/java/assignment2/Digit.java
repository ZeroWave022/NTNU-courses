package assignment2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// - Hvordan skal private og public brukes for at denne klassen skal være korrekt innkapslet?
// Både base og value settes til private.
// - Hva slags validering bør legges til for å sikre gyldig tilstand?
// Sjekke om base ikke er større enn 9 + 26 = 35, eller mindre enn 0.
// - Hvilke metoder må evt. legges til?
// Legger til `private void validateBase` som utløser et untak om base er feil.
// - Vil du karakterisere denne klassen som data-orientert eller tjeneste-orientert. Begrunn svaret!
// Data-orientert, fordi den holder på et tall og implementerer funksjoner for å modifisere dette tallet.

public class Digit {
    private int base;
    private int value;
    private final static List<Character> alphabet = IntStream.rangeClosed('A', 'Z').mapToObj(c -> (char) c)
            .collect(Collectors.toList());

    public Digit(int base) {
        this.validateBase(base);
        this.base = base;
        this.value = 0;
    }

    private void validateBase(int base) throws IllegalArgumentException {
        if (base < 0 || base >= 35)
            throw new IllegalArgumentException("Base cannot be bigger than 35!");
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

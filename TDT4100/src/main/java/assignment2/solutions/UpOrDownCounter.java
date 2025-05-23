package assignment2.solutions;

// - Hvordan skal private og public brukes for at denne klassen skal være korrekt innkapslet?
// start, end og counter settes til private.
// - Hva slags validering bør legges til for å sikre gyldig tilstand?
// Kun dersom start == end, må vi utløse et unntak.
// Hvis brukeren bruker feil variabeltype, vil ikke Java-koden kompileres uansett.
// - Hvilke metoder må evt. legges til?
// Legger til `validateInput`.
// - Vil du karakterisere denne klassen som data-orientert eller tjeneste-orientert. Begrunn svaret!
// Tjeneste-orientert, fordi vi bruker counteren som et verktøy som kan telle ned eller opp for oss.

public class UpOrDownCounter {
    private int start;
    private int end;
    private int counter;

    public UpOrDownCounter(int start, int end) {
        this.validateInput(start, end);
        this.start = start;
        this.end = end;
        this.counter = start;
    }

    private void validateInput(int start, int end) throws IllegalArgumentException {
        if (start == end)
            throw new IllegalArgumentException("Start cannot be equal to end!");
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

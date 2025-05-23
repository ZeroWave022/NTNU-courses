package assignment2.solutions;

// - Hvordan skal private og public brukes for at denne klassen skal være korrekt innkapslet?
// Både x og y settes til private.
// - Hva slags validering bør legges til for å sikre gyldig tilstand?
// Ingen. Hvis brukeren bruker feil variabeltype, så vil Java-koden uansett ikke kompilere.
// - Hvilke metoder må evt. legges til?
// Ingen.
// - Vil du karakterisere denne klassen som data-orientert eller tjeneste-orientert. Begrunn svaret!
// Data-orientert, fordi klassen holder på en plassering som vi kan modifisere slik vi vil.

public class Location {
    private int x;
    private int y;

    public void up() {
        this.y -= 1;
    }

    public void down() {
        this.y += 1;
    }

    public void left() {
        this.x -= 1;
    }

    public void right() {
        this.x += 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

package assignment2.solutions;

// - Hvordan skal private og public brukes for at denne klassen skal være korrekt innkapslet?
// Både text og insertionIndex settes til private.
// - Hva slags validering bør legges til for å sikre gyldig tilstand?
// Vi må sjekke om insertionIndex settes riktig.
// Hvis den er under 0, eller over lengden til teksten, så er den ugyldig.
// - Hvilke metoder må evt. legges til?
// Ingen, siden testene er veldig korte og enkle.
// - Vil du karakterisere denne klassen som data-orientert eller tjeneste-orientert. Begrunn svaret!
// Tjeneste-orientert, fordi vi har en tekststrenge vi kan aktivt manipulere og få resultatet.

public class LineEditor {
    private String text;
    private int insertionIndex;

    public LineEditor() {
        this.text = "";
        this.insertionIndex = 0;
    }

    public void left() {
        if (this.insertionIndex > 0) {
            this.insertionIndex -= 1;
        }
    }

    public void right() {
        if (this.insertionIndex < this.text.length()) {
            this.insertionIndex += 1;
        }
    }

    public void insertString(String text) {
        this.text = this.text.substring(0, this.insertionIndex) + text + this.text.substring(this.insertionIndex);
        this.insertionIndex += text.length();
    }

    public void deleteLeft() {
        if (this.insertionIndex > 0) {
            this.text = this.text.substring(0, this.insertionIndex - 1) + this.text.substring(this.insertionIndex);
            this.insertionIndex -= 1;
        }
    }

    public void deleteRight() {
        if (this.insertionIndex == this.text.length())
            return;

        this.text = this.text.substring(0, this.insertionIndex) + this.text.substring(this.insertionIndex + 1);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        this.insertionIndex = text.length();
    }

    public int getInsertionIndex() {
        return insertionIndex;
    }

    public void setInsertionIndex(int insertionIndex) throws IllegalArgumentException {
        if (insertionIndex < 0)
            throw new IllegalArgumentException("Cannot set insertionIndex to a lower value than 0!");
        if (insertionIndex > this.text.length())
            throw new IllegalArgumentException("Cannot set insertionIndex to a higher value than the text's length!");
        this.insertionIndex = insertionIndex;
    }

    @Override
    public String toString() {
        if (this.text.length() == 0)
            return "|";
        return this.text.substring(0, this.insertionIndex) + "|" + this.text.substring(this.insertionIndex);
    }
}

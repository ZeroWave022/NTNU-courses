package assignment1;

public class LineEditor {
    public String text;
    public int insertionIndex;

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
    }

    public int getInsertionIndex() {
        return insertionIndex;
    }

    public void setInsertionIndex(int insertionIndex) {
        this.insertionIndex = insertionIndex;
    }

    @Override
    public String toString() {
        if (this.text.length() == 0)
            return "|";
        return this.text.substring(0, this.insertionIndex) + "|" + this.text.substring(this.insertionIndex);
    }

    private void verifyState(String expectedText, int expectedIndex, String expectedToString) {
        System.out.println(String.format("editor.text == \"%s\": %b", expectedText, this.text.equals(expectedText)));
        System.out.println(
                String.format("editor.insertionIndex == %d: %b", this.insertionIndex,
                        this.insertionIndex == expectedIndex));
        System.out.println(
                String.format("editor.toString() == \"%s\": %b", expectedToString,
                        this.toString().equals(expectedToString)));
    }

    public static void main(String[] args) {
        LineEditor editor = new LineEditor();
        System.out.println("*** STATE 0 ***");
        editor.verifyState("", 0, "|");

        editor.setText("Example Text");
        System.out.println("\nExecuted editor.setText(\"Example Text\")\n");

        System.out.println("*** STATE 1 ***");
        editor.verifyState("Example Text", 0, "|Example Text");

        for (int i = 0; i < 8; i++) {
            editor.right();
        }
        System.out.println("\nExecuted LineEditor.left() 8 times.\n");

        System.out.println("*** STATE 2 ***");
        editor.verifyState("Example Text", 8, "Example |Text");

        for (int i = 0; i < 4; i++) {
            editor.deleteRight();
        }
        System.out.println("\nExecuted LineEditor.deleteRight() 4 times.\n");

        System.out.println("*** STATE 3 ***");
        editor.verifyState("Example ", 8, "Example |");

        editor.insertString("Title");
        System.out.println("\nExecuted LineEditor.insertString(\"Title\")\n");

        System.out.println("*** STATE 4 ***");
        editor.verifyState("Example Title", 13, "Example Title|");
    }
}

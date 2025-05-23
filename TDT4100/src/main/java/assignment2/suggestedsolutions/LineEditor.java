package assignment2.suggestedsolutions;

public class LineEditor {

	private int insertionIndex = 0;
	private String text = "";

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		if (text == null) {
			throw new IllegalArgumentException("The text cannot be null");
		}

		this.text = text;
		this.insertionIndex = text.length();
	}

	public int getInsertionIndex() {
		return this.insertionIndex;
	}

	public void setInsertionIndex(int insertionIndex) {
		if (insertionIndex < 0) {
			throw new IllegalArgumentException("The insertion index cannot be negative");
		}
		if (insertionIndex > this.text.length()) {
			throw new IllegalArgumentException(
					"The insertion index cannot be larger than the length of the text");
		}

		this.insertionIndex = insertionIndex;
	}

	public void left() {
		this.insertionIndex = Math.max(this.insertionIndex - 1, 0);
	}

	public void right() {
		this.insertionIndex = Math.min(this.insertionIndex + 1, this.text.length());
	}

	public void insertString(String string) {
		if (string == null) {
			throw new IllegalArgumentException("The string to insert cannot be null");
		}

		this.text = this.text.substring(0, this.insertionIndex) + string
				+ this.text.substring(this.insertionIndex);
		this.insertionIndex += string.length();
	}

	public void deleteLeft() {
		if (this.insertionIndex <= 0) {
			return;
		}

		this.text = this.text.substring(0, this.insertionIndex - 1)
				+ this.text.substring(this.insertionIndex);
		this.insertionIndex--;
	}

	public void deleteRight() {
		if (this.insertionIndex >= this.text.length()) {
			return;
		}

		this.text = this.text.substring(0, this.insertionIndex)
				+ this.text.substring(this.insertionIndex + 1);
	}

	@Override
	public String toString() {
		return String.format("%s|%s", this.text.substring(0, this.insertionIndex),
				this.text.substring(this.insertionIndex));
	}
}

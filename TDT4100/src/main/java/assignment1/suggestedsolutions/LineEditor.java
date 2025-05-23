package assignment1.suggestedsolutions;

// See LineEditorX for extra tasks
public class LineEditor {

	int insertionIndex = 0;
	String text = "";

	String getText() {
		return this.text;
	}

	void setText(String text) {
		this.text = text;
	}

	int getInsertionIndex() {
		return this.insertionIndex;
	}

	void setInsertionIndex(int insertionIndex) {
		this.insertionIndex = insertionIndex;
	}

	void left() {
		if (this.insertionIndex > 0) {
			this.insertionIndex--;
		}
	}

	void right() {
		if (this.insertionIndex < this.text.length()) {
			this.insertionIndex++;
		}
	}

	void insertString(String s) {
		this.text = this.text.substring(0, this.insertionIndex) + s
				+ this.text.substring(this.insertionIndex);
		this.insertionIndex += s.length();
	}

	void deleteLeft() {
		if (this.insertionIndex > 0) {
			this.text = this.text.substring(0, this.insertionIndex - 1)
					+ this.text.substring(this.insertionIndex);
			this.insertionIndex--;
		}
	}

	void deleteRight() {
		if (this.insertionIndex < this.text.length()) {
			this.text = this.text.substring(0, this.insertionIndex)
					+ this.text.substring(this.insertionIndex + 1);
		}
	}

	@Override
	public String toString() {
		return String.format("%s|%s", this.text.substring(0, this.insertionIndex),
				this.text.substring(this.insertionIndex));
	}
}

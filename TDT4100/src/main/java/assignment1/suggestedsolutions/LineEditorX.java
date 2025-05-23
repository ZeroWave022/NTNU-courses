package assignment1.suggestedsolutions;

public class LineEditorX {

	int insertionIndex = 0;
	int selectionEnd = 0;
	String text = "";

	void left(int n, boolean select) {
		if (select) {
			if (this.selectionEnd > n) {
				this.selectionEnd -= n;
			} else {
				this.selectionEnd = 0;
			}
		} else {
			if (this.selectionEnd != this.insertionIndex) {
				this.insertionIndex = Math.min(this.insertionIndex, this.selectionEnd);
			} else if (this.insertionIndex > n) {
				this.insertionIndex -= n;
			} else {
				this.insertionIndex = 0;
			}

			this.selectionEnd = this.insertionIndex;
		}
	}

	void left() {
		this.left(1, false);
	}

	void selectLeft() {
		this.left(1, true);
	}

	void right(int n, boolean select) {
		if (select) {
			if (this.selectionEnd < this.text.length() - n) {
				this.selectionEnd += n;
			} else {
				this.selectionEnd = this.text.length();
			}
		} else {
			if (this.selectionEnd != this.insertionIndex) {
				// clear range
				this.insertionIndex = Math.max(this.insertionIndex, this.selectionEnd);
			} else if (this.insertionIndex < this.text.length() - n) {
				this.insertionIndex += n;
			} else {
				this.insertionIndex = this.text.length();
			}

			this.selectionEnd = this.insertionIndex;
		}
	}

	void right() {
		this.right(1, false);
	}

	void selectRight() {
		this.right(1, true);
	}

	void insertString(String s) {
		int minIndex = Math.min(this.insertionIndex, this.selectionEnd);
		int maxIndex = Math.max(this.insertionIndex, this.selectionEnd);

		this.text = this.text.substring(0, minIndex) + s + this.text.substring(maxIndex);
		this.insertionIndex = minIndex + s.length();
		this.selectionEnd = this.insertionIndex;
	}

	void insert(Object other) {
		this.insertString(other.toString());
	}

	void deleteSelection() {
		int minIndex = Math.min(this.insertionIndex, this.selectionEnd);
		int maxIndex = Math.max(this.insertionIndex, this.selectionEnd);

		this.text = this.text.substring(0, minIndex) + this.text.substring(maxIndex);
		this.insertionIndex = minIndex;
		this.selectionEnd = this.insertionIndex;
	}

	void deleteLeft() {
		if (this.selectionEnd != this.insertionIndex) {
			this.deleteSelection();
		} else if (this.insertionIndex > 0) {
			this.text = this.text.substring(0, this.insertionIndex - 1)
					+ this.text.substring(this.insertionIndex);
			this.insertionIndex--;
			this.selectionEnd = this.insertionIndex;
		}
	}

	void deleteRight() {
		if (this.selectionEnd != this.insertionIndex) {
			this.deleteSelection();
		} else if (this.insertionIndex < this.text.length()) {
			this.text = this.text.substring(0, this.insertionIndex)
					+ this.text.substring(this.insertionIndex + 1);
		}
	}

	@Override
	public String toString() {
		if (this.insertionIndex < this.selectionEnd) {
			return String.format("[LineEditor \"%s<%s>%s\"]",
					this.text.substring(0, this.insertionIndex),
					this.text.substring(this.insertionIndex, this.selectionEnd),
					this.text.substring(this.selectionEnd));
		}
		if (this.insertionIndex > this.selectionEnd) {
			return String.format("[LineEditor \"%s>%s<%s\"]",
					this.text.substring(0, this.selectionEnd),
					this.text.substring(this.selectionEnd, this.insertionIndex),
					this.text.substring(this.insertionIndex));
		}
		return String.format("[LineEditor \"%s|%s\"]", this.text.substring(0, this.insertionIndex),
				this.text.substring(this.insertionIndex));
	}
}

package assignment7.suggestedsolutions.observablelist;

public class ObservableHighscoreList extends ObservableList {

	private final int maxSize;

	public ObservableHighscoreList(int maxSize) {
		this.maxSize = maxSize;
	}

	public boolean acceptsElement(Object element) {
		return element instanceof Integer;
	}

	@Override
	public void addElement(int pos, Object element) {
		if (pos >= this.maxSize) {
			return;
		}

		if (this.size() >= this.maxSize) {
			this.removeElement(this.maxSize - 1);
		}

		super.addElement(pos, element);
	}

	public void addResult(int result) {
		int pos = 0;

		while (pos < this.size() && result >= (int) this.getElement(pos)) {
			pos++;
		}

		this.addElement(pos, result);
	}
}

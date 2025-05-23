package assignment6.suggestedsolutions.highscorelist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class HighscoreList {

	private final int maxSize;
	private final Collection<HighscoreListListener> listListeners = new HashSet<>();
	private final List<Integer> results = new ArrayList<>();

	public HighscoreList(int maxSize) {
		this.maxSize = maxSize;
	}

	public int size() {
		return this.results.size();
	}

	private void addElement(int pos, int element) {
		if (pos >= this.maxSize) {
			return;
		}

		if (this.size() >= this.maxSize) {
			this.results.remove(this.maxSize - 1);
		}

		this.results.add(pos, element);
		this.fireListChanged(pos);
	}

	public int getElement(int i) {
		return this.results.get(i);
	}

	public void addResult(int result) {
		int pos = 0;

		while (pos < this.size() && result >= this.results.get(pos)) {
			pos++;
		}

		this.addElement(pos, result);
	}

	public void addHighscoreListListener(HighscoreListListener listListener) {
		this.listListeners.add(listListener);
	}

	public void removeHighscoreListListener(HighscoreListListener listListener) {
		this.listListeners.remove(listListener);
	}

	private void fireListChanged(int pos) {
		this.listListeners.forEach(listener -> listener.listChanged(this, pos));

		// Alternativt:
		// for (HighscoreListListener listListener : listListeners) {
		// listListener.listChanged(this, pos);
		// }
	}
}

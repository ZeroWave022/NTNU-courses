package assignment7.suggestedsolutions.observablelist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public abstract class ObservableList {

	private final Collection<ObservableListListener> observableListListeners = new HashSet<>();
	private final List<Object> elements = new ArrayList<>();

	public abstract boolean acceptsElement(Object element);

	public int size() {
		return this.elements.size();
	}

	public Object getElement(int i) {
		return this.elements.get(i);
	}

	protected void addElement(int pos, Object element) {
		if (!this.acceptsElement(element)) {
			throw new IllegalArgumentException(element + " is not acceptable");
		}

		this.elements.add(pos, element);
		this.fireListChanged(pos);
	}

	protected void removeElement(int pos) {
		this.elements.remove(pos);
		this.fireListChanged(pos);
	}

	protected void addElement(Object element) {
		this.addElement(this.size(), element);
	}

	public void addObservableListListener(ObservableListListener listListener) {
		this.observableListListeners.add(listListener);
	}

	public void removeObservableListListener(ObservableListListener listListener) {
		this.observableListListeners.remove(listListener);
	}

	protected void fireListChanged(int pos) {
		this.observableListListeners.forEach(listListener -> listListener.listChanged(this, pos));
	}
}

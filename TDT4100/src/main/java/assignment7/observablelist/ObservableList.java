package assignment7.observablelist;

import java.util.ArrayList;
import java.util.List;

public abstract class ObservableList<T> {
    protected List<T> list = new ArrayList<>();
    private List<ObservableListListener> listeners = new ArrayList<>();

    public int size() {
        return list.size();
    }

    public T getElement(int i) {
        return list.get(i);
    }

    public abstract boolean acceptsElement(Object o);

    public void addElement(int i, T object) {
        if (!this.acceptsElement(object))
            throw new IllegalArgumentException("Cannot add this object to the ObservableList.");
        this.list.add(i, object);
        this.notifyListeners(i);
    }

    public void addElement(T object) {
        if (!this.acceptsElement(object))
            throw new IllegalArgumentException("Cannot add this object to the ObservableList.");
        this.list.addLast(object);
        this.notifyListeners(list.size() - 1);
    }

    public void removeElement(int i) {
        this.list.remove(i);
        this.notifyListeners(i);
    }

    protected void notifyListeners(int index) {
        listeners.stream().forEach(l -> l.listChanged(this, index));
    }

    void addObservableListListener(ObservableListListener listener) {
        if (!listeners.contains(listener))
            listeners.add(listener);
    }

    void removeObservableListListener(ObservableListListener listener) {
        listeners.remove(listener);
    }

    @Override
    public String toString() {
        return String.join(", ", this.list.stream().map(e -> e.toString()).toList());
    }
}

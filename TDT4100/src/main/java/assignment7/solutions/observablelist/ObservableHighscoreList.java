package assignment7.solutions.observablelist;

public class ObservableHighscoreList extends ObservableList<Integer> {
    private int maxSize;

    public ObservableHighscoreList(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public boolean acceptsElement(Object o) {
        return o instanceof Integer;
    }

    public void addResult(int newInt) {
        if (this.size() == 0) {
            this.addElement(newInt);
            this.notifyListeners(0);
            return;
        }

        if (newInt > list.getLast() && this.size() == maxSize)
            return;

        int indexSet = -1;
        for (int i = this.size() - 1; i > 0; i--) {
            if (newInt > this.getElement(i))
                continue;

            this.addElement(i - 1, newInt);
            indexSet = i - 1;
            if (this.size() > maxSize) {
                list.removeLast();
            }
            break;
        }

        // If no index was set, that means the new value is bigger than all other values
        // present. Only add it if we've got the space to do so.
        if (indexSet == -1 && this.size() < maxSize) {
            list.addLast(newInt);
            this.notifyListeners(this.size() - 1);
            return;
        }

        this.notifyListeners(indexSet);
    }
}

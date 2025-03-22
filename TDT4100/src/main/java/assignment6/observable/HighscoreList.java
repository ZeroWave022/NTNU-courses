package assignment6.observable;

import java.util.ArrayList;
import java.util.List;

public class HighscoreList {
    private int maxSize;
    private List<Integer> list = new ArrayList<>();
    private List<HighscoreListListener> listeners = new ArrayList<>();

    public HighscoreList(int maxSize) {
        this.maxSize = maxSize;
    }

    public int size() {
        return list.size();
    }

    public int getElement(int i) {
        return list.get(i);
    }

    private void notifyListeners(int index) {
        listeners.stream().forEach(l -> l.listChanged(this, index));
    }

    public void addResult(int newInt) {
        if (list.size() == 0) {
            list.add(newInt);
            this.notifyListeners(0);
            return;
        }

        if (newInt > list.getLast() && list.size() == maxSize)
            return;

        int indexSet = -1;
        for (int i = list.size() - 1; i > 0; i--) {
            if (newInt > list.get(i))
                continue;

            list.add(i - 1, newInt);
            indexSet = i - 1;
            if (list.size() > maxSize) {
                list.removeLast();
            }
            break;
        }

        // If no index was set, that means the new value is bigger than all other values
        // present. Only add it if we've got the space to do so.
        if (indexSet == -1 && list.size() < maxSize) {
            list.addLast(newInt);
            this.notifyListeners(list.size() - 1);
            return;
        }

        this.notifyListeners(indexSet);
    }

    void addHighscoreListListener(HighscoreListListener listener) {
        if (!listeners.contains(listener))
            listeners.add(listener);
    }

    void removeHighscoreListListener(HighscoreListListener listener) {
        listeners.remove(listener);
    }
}

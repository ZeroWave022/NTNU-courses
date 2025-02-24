package assignment4;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StopWatchManager {
    private Map<String, StopWatch> stopwatches = new HashMap<>();

    public StopWatch newStopWatch(String name) {
        StopWatch watch = new StopWatch();
        stopwatches.put(name, watch);
        return watch;
    }

    public void removeStopWatch(String name) {
        stopwatches.remove(name);
    }

    public void tick(int ticks) {
        for (StopWatch watch : stopwatches.values()) {
            watch.tick(ticks);
        }
    }

    public StopWatch getStopWatch(String name) {
        return stopwatches.get(name);
    }

    public Collection<StopWatch> getAllWatches() {
        return this.stopwatches.values();
    }

    public Collection<StopWatch> getStartedWatches() {
        return this.stopwatches.values().stream().filter(c -> c.isStarted()).toList();
    }

    public Collection<StopWatch> getStoppedWatches() {
        return this.stopwatches.values().stream().filter(c -> c.isStopped()).toList();
    }
}

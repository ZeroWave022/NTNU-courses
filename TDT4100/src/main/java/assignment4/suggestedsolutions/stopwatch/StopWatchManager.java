package assignment4.suggestedsolutions.stopwatch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StopWatchManager {

	private final Map<String, StopWatch> stopWatches = new HashMap<>();

	public StopWatch newStopWatch(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Name cannot be null");
		}
		if (this.stopWatches.containsKey(name)) {
			throw new IllegalArgumentException("Stop watch for " + name + " already exists");
		}

		StopWatch stopWatch = new StopWatch();
		this.stopWatches.put(name, stopWatch);
		return stopWatch;
	}

	public void removeStopWatch(String name) {
		this.stopWatches.remove(name);
	}

	public void tick(int milliSeconds) {
		if (milliSeconds < 0) {
			throw new IllegalArgumentException("Time cannot go backwards");
		}
		for (StopWatch stopWatch : this.stopWatches.values()) {
			stopWatch.tick(milliSeconds);
		}
	}

	private StopWatch getStopWatch(String name, boolean throwException) {
		StopWatch stopWatch = this.stopWatches.get(name);

		if (throwException && stopWatch == null) {
			throw new IllegalArgumentException("No stop watch for " + name);
		}

		return stopWatch;
	}

	public StopWatch getStopWatch(String name) {
		return this.getStopWatch(name, false);
	}

	private Collection<StopWatch> getWatches(Boolean started, Boolean stopped) {
		Collection<StopWatch> result = new ArrayList<>();

		for (StopWatch stopWatch : this.stopWatches.values()) {
			if ((started == null || stopWatch.isStarted() == started)
					&& (stopped == null || stopWatch.isStopped() == stopped)) {
				result.add(stopWatch);
			}
		}

		return result;
	}

	public Collection<StopWatch> getAllWatches() {
		return this.getWatches(null, null);
	}

	public Collection<StopWatch> getStartedWatches() {
		return this.getWatches(true, null);
	}

	public Collection<StopWatch> getStoppedWatches() {
		return this.getWatches(null, true);
	}
}

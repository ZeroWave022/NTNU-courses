package assignment4.suggestedsolutions.stopwatch;

public class StopWatch {

	private int lapStartTime = -1;
	private int lapTime = -1;
	private int startTime = -1;
	private int stopTime = -1;
	private int ticks = 0;

	public int getTicks() {
		return this.ticks;
	}

	public void tick(int milliSeconds) {
		if (milliSeconds < 0) {
			throw new IllegalArgumentException("Time cannot go backwards");
		}

		this.ticks += milliSeconds;
	}

	public void start() {
		if (this.isStarted()) {
			throw new IllegalStateException("Cannot start a timer that's already started");
		}

		this.startTime = this.ticks;
		this.lap();
	}

	public boolean isStarted() {
		return this.startTime >= 0;
	}

	public void lap() {
		if (!this.isStarted()) {
			throw new IllegalStateException("Cannot lap a timer that's not started");
		}
		if (this.isStopped()) {
			throw new IllegalStateException("Cannot lap a timer that's stopped");
		}

		if (this.lapStartTime >= 0) {
			this.lapTime = this.ticks - this.lapStartTime;
		}

		this.lapStartTime = this.ticks;
	}

	public void stop() {
		if (!this.isStarted()) {
			throw new IllegalStateException("Cannot stop a timer that's not started");
		}
		if (this.isStopped()) {
			throw new IllegalStateException("Cannot stop a timer that's already stopped");
		}

		this.lap();
		this.stopTime = this.ticks;
	}

	public boolean isStopped() {
		return this.stopTime >= 0;
	}

	public int getTime() {
		if (this.isStopped()) {
			return this.stopTime - this.startTime;
		}
		if (this.isStarted()) {
			return this.ticks - this.startTime;
		}
		return -1;
	}

	public int getLapTime() {
		if (this.lapStartTime >= 0) {
			return this.ticks - this.lapStartTime;
		}
		return -1;
	}

	public int getLastLapTime() {
		return this.lapTime;
	}

	@Override
	public String toString() {
		return String.format("[StopWatch time=%d, lapTime=%d]", this.getTime(),
				this.getLastLapTime());
	}
}

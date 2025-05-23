package assignment1.suggestedsolutions;

public class StopWatch {

	int lapStartTime = -1;
	int lapTime = -1;
	int startTime = -1;
	int stopTime = -1;
	int ticks = 0;

	int getTicks() {
		return this.ticks;
	}

	void tick(int milliSeconds) {
		this.ticks += milliSeconds;
	}

	void start() {
		this.startTime = this.ticks;
		this.lap();
	}

	boolean isStarted() {
		return this.startTime >= 0;
	}

	void lap() {
		if (this.lapStartTime >= 0) {
			this.lapTime = this.ticks - this.lapStartTime;
		}
		this.lapStartTime = this.ticks;
	}

	void stop() {
		this.lap();
		this.stopTime = this.ticks;
	}

	boolean isStopped() {
		return stopTime >= 0;
	}

	int getTime() {
		if (this.isStopped()) {
			return stopTime - startTime;
		}
		if (this.isStarted()) {
			return ticks - startTime;
		}
		return -1;
	}

	int getLapTime() {
		if (this.lapStartTime >= 0) {
			return this.ticks - this.lapStartTime;
		}
		return -1;
	}

	int getLastLapTime() {
		return this.lapTime;
	}

	@Override
	public String toString() {
		return String.format("[StopWatch time=%d, lapTime=%d]", this.getTime(),
				this.getLastLapTime());
	}
}

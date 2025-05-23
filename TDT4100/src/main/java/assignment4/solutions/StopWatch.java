package assignment4.solutions;

import java.util.ArrayList;

public class StopWatch {
    private boolean started;
    private boolean stopped;
    private int startedAt;
    private int stoppedAt;
    private int ticks;
    private ArrayList<Integer> laps;

    public StopWatch() {
        this.started = false;
        this.stopped = false;
        this.ticks = 0;
        this.laps = new ArrayList<Integer>();
    }

    public boolean isStarted() {
        return started;
    }

    public boolean isStopped() {
        return stopped;
    }

    public int getTicks() {
        return ticks;
    }

    public int getTime() {
        if (!this.started)
            return -1;
        if (this.stopped)
            return this.stoppedAt - this.startedAt;
        return this.ticks - this.startedAt;
    }

    public int getLapTime() {
        if (!this.started)
            return -1;
        if (this.stopped)
            return 0;
        if (this.laps.size() == 0)
            return this.ticks;
        return this.ticks - this.laps.getLast();
    }

    public int getLastLapTime() {
        if (this.laps.size() == 0)
            return -1;
        return this.laps.getLast();
    }

    public void tick(int ticks) throws IllegalArgumentException {
        if (ticks < 0)
            throw new IllegalArgumentException("You must add a positive amount of ticks!");
        this.ticks += ticks;
    }

    public void start() throws IllegalStateException {
        if (this.started)
            throw new IllegalStateException("Cannot start StopWatch multiple times!");
        this.started = true;
        this.startedAt = this.ticks;
    }

    public void lap() throws IllegalStateException {
        if (!this.started || this.stopped)
            throw new IllegalStateException(
                    "Cannot register lap! This StopWatch is either not started, or has been stopped already.");

        if (this.laps.size() == 0) {
            this.laps.add(this.ticks);
        } else {
            this.laps.add(this.ticks - this.laps.getLast());
        }
    }

    public void stop() throws IllegalStateException {
        if (this.stopped)
            throw new IllegalStateException("Cannot stop StopWatch multiple times!");
        this.stopped = true;
        this.stoppedAt = this.ticks;
        if (this.laps.size() > 0) {
            this.laps.add(this.ticks - this.laps.getLast());
        } else {
            this.laps.add(this.ticks);
        }
    }
}

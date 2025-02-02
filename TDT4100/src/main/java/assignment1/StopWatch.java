package assignment1;

import java.util.ArrayList;

public class StopWatch {
    public boolean started;
    public boolean stopped;
    public int startedAt;
    public int stoppedAt;
    public int ticks;
    public ArrayList<Integer> laps;

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

    public void tick(int ticks) {
        this.ticks += ticks;
    }

    public void start() {
        this.started = true;
        this.startedAt = this.ticks;
    }

    public void lap() {
        if (this.laps.size() == 0) {
            this.laps.add(this.ticks);
        } else {
            this.laps.add(this.ticks - this.laps.getLast());
        }
    }

    public void stop() {
        this.stopped = true;
        this.stoppedAt = this.ticks;
        if (this.laps.size() > 0) {
            this.laps.add(this.ticks - this.laps.getLast());
        } else {
            this.laps.add(this.ticks);
        }
    }
}

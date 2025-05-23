package assignment1.suggestedsolutions;

/*
 * @startuml
 * class Counter {
 * 	-int counter
 * 	-int end
 * 	+Counter(start, end)
 * 	+count()
 * 	+getCounter()
 * }
 * @enduml
 */

public class UpOrDownCounter {

	int direction;
	int end;
	int counter;

	public UpOrDownCounter(int start, int end) {
		this.counter = start;
		this.end = end;

		if (start < end) {
			this.direction = 1;
		} else {
			this.direction = -1;
		}
	}

	boolean count() {
		if (this.counter == this.end) {
			return false;
		}
		this.counter += this.direction;
		return this.counter != this.end;
	}

	int getCounter() {
		return this.counter;
	}

	@Override
	public String toString() {
		return String.format("[UpOrDownCounter counter=%d]", this.counter);
	}
}

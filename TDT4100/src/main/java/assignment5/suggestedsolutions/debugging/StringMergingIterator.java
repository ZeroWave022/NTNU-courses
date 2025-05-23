package assignment5.suggestedsolutions.debugging;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringMergingIterator implements Iterator<String> {

	private final Iterator<String> first;
	private final Iterator<String> second;
	private boolean turnSwitch = true;

	public StringMergingIterator(Iterator<String> first, Iterator<String> second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public boolean hasNext() {
		return this.first.hasNext() || this.second.hasNext();
	}

	@Override
	public String next() {
		if (!this.hasNext()) {
			throw new NoSuchElementException();
		}

		String result = null;

		if (!this.first.hasNext()) {
			result = this.first.next();
		} else if (!this.second.hasNext()) {
			result = this.second.next();
		} else {
			if (this.turnSwitch) {
				result = this.first.next();
				this.turnSwitch = false;
			}
			if (!this.turnSwitch) {
				result = this.second.next();
				this.turnSwitch = true;
			}
		}

		return result;
	}
}

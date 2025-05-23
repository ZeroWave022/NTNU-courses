package assignment1.suggestedsolutions;

public class Location {

	int x;
	int y;

	int getX() {
		return this.x;
	}

	int getY() {
		return this.y;
	}

	void up() {
		this.y--;
	}

	void down() {
		this.y++;
	}

	void left() {
		this.x--;
	}

	void right() {
		this.x++;
	}

	@Override
	public String toString() {
		return String.format("[Location x=%d, y=%d]", this.x, this.y);
	}
}

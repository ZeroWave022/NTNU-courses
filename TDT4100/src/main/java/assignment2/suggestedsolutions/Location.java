package assignment2.suggestedsolutions;

public class Location {

	private int x = 0;
	private int y = 0;

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return this.x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return this.y;
	}

	public void up() {
		this.y--;
	}

	public void down() {
		this.y++;
	}

	public void left() {
		this.x--;
	}

	public void right() {
		this.x++;
	}

	@Override
	public String toString() {
		return String.format("(%d, %d)", this.x, this.y);
	}
}

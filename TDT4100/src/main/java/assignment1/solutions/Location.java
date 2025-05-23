package assignment1.solutions;

public class Location {
    public int x;
    public int y;

    public void up() {
        this.y -= 1;
    }

    public void down() {
        this.y += 1;
    }

    public void left() {
        this.x -= 1;
    }

    public void right() {
        this.x += 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

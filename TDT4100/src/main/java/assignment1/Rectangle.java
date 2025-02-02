package assignment1;

public class Rectangle {
    public int width;
    public int height;
    public int minX;
    public int maxX;
    public int minY;
    public int maxY;

    public Rectangle(int x1, int y1, int x2, int y2) {
        this.minX = Math.min(x1, x2);
        this.maxX = Math.max(x1, x2);
        this.minY = Math.min(y1, y2);
        this.maxY = Math.max(y1, y2);
        this.width = this.maxX - this.minX;
        this.height = this.maxY - this.minY;
    }

    public int getMinX() {
        return minX;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxY() {
        return maxY;
    }

    public boolean isEmpty() {
        return this.height == 0 || this.width == 0;
    }

    public int getWidth() {
        if (this.isEmpty()) {
            return 0;
        }
        return width;
    }

    public int getHeight() {
        if (this.isEmpty()) {
            return 0;
        }
        return height;
    }

    public boolean contains(int x, int y) {
        return this.minX <= x && this.maxX >= x && this.minY <= y && this.maxY >= y;
    }

    public boolean contains(Rectangle rect) {
        return rect.minX <= this.minX && rect.maxX >= this.maxX && rect.minY <= this.minY && rect.maxY >= this.maxY;
    }

    public boolean add(int x, int y) {
        boolean changed = false;

        if (this.minX > x || this.maxX < x) {
            this.minX = Math.min(this.minX, x);
            this.maxX = Math.max(this.maxX, x);
            this.updateWidth();
            changed = true;
        }

        if (this.minY > y || this.maxY < y) {
            this.minY = Math.min(this.minY, y);
            this.maxY = Math.max(this.maxY, y);
            this.updateHeight();
            changed = true;
        }

        return changed;
    }

    public boolean add(Rectangle rect) {
        return this.add(rect.maxX, rect.maxY);
    }

    public Rectangle union(Rectangle rect) {
        int newMinX = Math.min(this.minX, rect.minX);
        int newMaxX = Math.max(this.maxX, rect.maxX);
        int newMinY = Math.min(this.minY, rect.minY);
        int newMaxY = Math.max(this.maxY, rect.maxY);
        return new Rectangle(newMinX, newMinY, newMaxX, newMaxY);
    }

    public Rectangle intersection(Rectangle rect) {
        int maxLeft = Math.max(this.minX, rect.minX);
        int minRight = Math.min(this.maxX, rect.maxX);
        if (maxLeft >= minRight) {
            return null;
        }

        int top = Math.min(this.maxY, rect.maxY);
        int bottom = Math.max(this.minY, rect.minY);
        if (bottom >= top) {
            return null;
        }
        return new Rectangle(bottom, maxLeft, minRight, top);
    }

    public boolean intersects(Rectangle rect) {
        return this.intersection(rect) != null;
    }

    private void updateWidth() {
        this.width = this.maxX - this.minX;
    }

    private void updateHeight() {
        this.height = this.maxY - this.minY;
    }
}

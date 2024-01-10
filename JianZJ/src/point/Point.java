package point;

public class Point {
    private int x;
    private int y;
    public static void status() {
        System.out.println("已建立");
    }
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
        status();
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public String toString() {
        return String.format("[%d : %d]", this.x, this.y);
    }
}

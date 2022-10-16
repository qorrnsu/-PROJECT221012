import java.util.Vector;

class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

public class PointVectorEx {
    public static void main(String[] args) {

        Vector<Point> v = new Vector<>();

        v.add(new Point(2, 3));
        v.add(new Point(-5, 20));
        v.add(new Point(30, -8));
        v.remove(1);

        for (Point p : v) {
            System.out.println(p);
        }
    }
}






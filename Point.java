public class Point {
    private double x, y;

    public Point() {
        this(0, 0);
    }
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public String toString() { 
        return String.format("(%.2f, %.2f)", x, y); 
    }
    public double x() { return x; }
    public double y() { return y; }

    public void move_by(double dx, double dy) { 
        x += dx;
        y += dy;
    }
    public void move_to(Point pt) { 
        x = pt.x;
        y = pt.y;
    }
    public double distance_from(Point other) { 
        double deltax = x - other.x;
        double deltay = y - other.y;
        return Math.sqrt(deltax * deltax + deltay * deltay);
    }
    public static void run_tests() {
        System.out.println("\n............. BEGINNING Point.run_tests().............");
        Point pt = new Point(10, 7);
        System.out.printf("pt = %s\n", pt);

        Point pt2 = new Point(-3, 4);
        System.out.printf("pt2 = %s\n", pt2);

        Point dest = new Point(1, 1);
        pt.move_to(dest);
        System.out.printf("after moving to %s, pt is now %s\n", dest, pt);

        Point delta = new Point(3, 5);
        pt.move_by(delta.x, delta.y);
        System.out.printf("after moving by %s, pt is now %s\n", delta, pt);

        System.out.printf("%s is %.2f from %s\n", pt, pt.distance_from(pt2), pt2);
        System.out.println("............. ending Point.run_tests()................\n");
    }
    public static void main(String[] args) { 
        Point.run_tests();
    }
}

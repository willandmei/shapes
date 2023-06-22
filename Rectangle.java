public class Rectangle extends Shape {
    private double length;
    private double width;

    Rectangle() { this(0.0, 0.0); }
    Rectangle(double length, double width) { this(length, width, new Point()); }
    Rectangle(double length, double width, Point center) { 
        super(center);
        this.length = length;
        this.width = width;
    }

    public String toString() { 
        return String.format("Rectangle[l=%.2f,w=%.2f, %s]", length, width, super.toString());
    }

    public double area() { return length * width; }
    public double peri() { return 2 * (length + width); }

    public boolean overlaps(Rectangle other) {
        Point center = center();
        double cx = center.x();
        double cy = center.y();
        double ocx = other.center().x();
        double ocy = other.center().y();

        if (area() == 0 || other.area() == 0) { return false; }

        // If one rectangle is on the left side of the other
        if (cx + length/2 < ocx - other.length/2) { return false; }
        if (cx - length/2 > ocx + other.length/2) { return false; }

        // If one rectangle is on above the other
        if (cy - width/2 > ocy + other.width/2) { return false; }
        if (cy + width/2 < ocy - other.width/2) { return false; }

        return true;
    }

    public static void run_tests() { 
        System.out.println("\n............. BEGINNING Rectangle.run_tests().............");
        Rectangle r = new Rectangle(10, 5, new Point());
        System.out.printf("r = %s\n", r);

        Rectangle r2 = new Rectangle(5, 2, new Point(-2, -3));
        System.out.printf("r2 = %s\n", r2);

        Point moveto = new Point(1, 1);
        r.move_to(moveto);
        System.out.printf("after moving the center to %s...\n\tr is now %s\n", moveto, r);

        double dx = 3, dy = 5;
        r.move_by(dx, dy);
        System.out.printf("after moving the center by by %s...\n\tr is now %s\n", new Point(dx, dy), r);

        System.out.printf("Rectangle %s, r=%.2f overlaps Rectangle %s, r=%.2f? %b}\n", 
                          r.center(), r.length, r2.center(), r2.length, r.overlaps(r2));

        System.out.println("............. ending Rectangle.run_tests()................\n");
    }
    public static void main(String args[]) { 
        Rectangle.run_tests();
    }
}

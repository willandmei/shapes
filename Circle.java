public class Circle extends Shape {
    private double radius;

    Circle() { this(0.0); }
    Circle(double radius) { this(radius, new Point()); }
    Circle(double radius, Point center) { 
        super(center);
        this.radius = radius;
    }

    public String toString() { 
        return String.format("Circle[r=%.2f,%s]", radius, super.toString());
    }

    public double area() { return Math.PI * radius * radius; }
    public double peri() { return 2 * Math.PI * radius; }

    public boolean overlaps(Circle other) {
        return center().distance_from(other.center()) < radius + other.radius;
    }

    public static void run_tests() { 
        System.out.println("\n............. BEGINNING Circle.run_tests().............");
        Circle c = new Circle(10, new Point());
        System.out.printf("c = %s\n", c);

        Circle c2 = new Circle(5, new Point(-2, -3));
        System.out.printf("c2 = %s\n", c2);

        Point moveto = new Point(1, 1);
        c.move_to(moveto);
        System.out.printf("after moving the center to %s...\n\tc is now %s\n", moveto, c);

        double dx = 3, dy = 5;
        c.move_by(dx, dy);
        System.out.printf("after moving the center by by %s...\n\tc is now %s\n", new Point(dx, dy), c);

        System.out.printf("Circle %s, r=%.2f overlaps Circle %s, r=%.2f? %b}\n", 
                          c.center(), c.radius, c2.center(), c2.radius, c.overlaps(c2));

        System.out.println("............. ending Circle.run_tests()................\n");
    }
    public static void main(String args[]) { 
        Circle.run_tests();
    }
}

public class Square extends Shape {        /* a Square is not a Rectangle */
    private double side;    

    Square() { this(0.0); }
    Square(double side) { this(side, new Point()); }
    Square(double side, Point center) { 
        super(center);
        this.side = side;
    }

    public String toString() { 
        return String.format("Square[s=%.2f,%s]", side, super.toString());
    }

    public double area() { return side * side; }
    public double peri() { return 4 * (side); }

    public boolean overlaps(Square other) {
        Point center = center();
        double cx = center.x();
        double cy = center.y();
        double ocx = other.center().x();
        double ocy = other.center().y();

        if (area() == 0 || other.area() == 0) { return false; }

        // If one Square is on the left side of the other
        if (cx + side/2 < ocx - other.side/2) { return false; }
        if (cx - side/2 > ocx + other.side/2) { return false; }

        // If one Square is on above the other
        if (cy - side/2 > ocy + other.side/2) { return false; }
        if (cy + side/2 < ocy - other.side/2) { return false; }

        return true;
    }

    public static void run_tests() { 
        System.out.println("\n............. BEGINNING Square.run_tests().............");
        Square sq = new Square(10, new Point());
        System.out.printf("square = %s\n", sq);

        Square sq2 = new Square(5, new Point(-2, -3));
        System.out.printf("sq2 = %s\n", sq2);

        Point moveto = new Point(1, 1);
        sq.move_to(moveto);
        System.out.printf("aftesquare moving the center to %s...\n\tsq is now %s\n", moveto, sq);

        double dx = 3, dy = 5;
        sq.move_by(dx, dy);
        System.out.printf("after moving the center by by %s...\n\tsq is now %s\n", new Point(dx, dy), sq);

        System.out.printf("Square %s, s=%.2f overlaps Square %s, s=%.2f? %b}\n", 
                          sq.center(), sq.side, sq2.center(), sq2.side, sq.overlaps(sq2));

        System.out.println("............. ending Square.run_tests()................\n");
    }
    public static void main(String args[]) { 
        Square.run_tests();
    }
}

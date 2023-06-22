public abstract class Shape {
    private Point center;

    public Shape() { this(new Point()); }

    public Shape(Point center) { 
        this.center = center;
    }

    public String toString() { 
        return String.format("ctr=%s,area=%.2f,peri=%.2f", center, area(), peri()); 
    }
    public Point center() { return center; }

    public void move_to(Point point) { center.move_to(point); }
    public void move_by(double dx, double dy) { center.move_by(dx, dy); }

    public abstract double area();
    public abstract double peri();
}

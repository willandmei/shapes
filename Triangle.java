public class Triangle extends Shape {
	private Point a;
	private Point b;
	private Point c;
	
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public static void runTests() { 
		Triangle t = new Triangle(new Point(0, 0), new Point(3, 0), new Point (4, 0));
		System.out.printf("t is: %s\n", t);
	}
	
	public static void main(String[] args) { 
		Triangle.runTests();
	}
}
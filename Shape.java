class Shape {
	private double x, y;
	
	Shape(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getPerimeter() {
		return this.x + this.y;
	}
	
	public double getArea() {
		return this.x * this.y;
	}
	
	public static void main(String[] args) {
	    Shape s1 = new Shape(5, 5);
	    Circle c1 = new Circle(1);
	    System.out.println("Shape's Perimeter: " + s1.getPerimeter());
	    System.out.println("Shape's Area: " + s1.getArea());
        System.out.println("Circle's Perimeter: " + c1.getPerimeter());
	    System.out.println("Circle's Area: " + c1.getArea());
    }
}

class Circle extends Shape {
    private double radius;
    
    Circle(double radius) {
        super(0, 0);
        this.radius = radius;
    }
    
    public double getArea() {
		return java.lang.Math.PI * java.lang.Math.pow(this.radius, 2);
	}
	
    public double getPerimeter() {
		return 2 * java.lang.Math.PI * this.radius;
	}
}
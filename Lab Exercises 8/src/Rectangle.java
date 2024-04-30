public class Rectangle {
    private final double width, height;

    public Rectangle() {
        this.width = 1;
        this.height = 1;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        System.out.println("Unit Rectangle Area " + r.getArea());
        System.out.println("Unit Rectangle Perimeter " + r.getPerimeter());

        Rectangle r2 = new Rectangle(2, 3);
        System.out.println("2x3 Rectangle Area " + r2.getArea());
        System.out.println("2x3 Rectangle Perimeter " + r2.getPerimeter());
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }
}

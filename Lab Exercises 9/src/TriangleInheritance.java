/*
 * Author: Marc Valdez
 * Section: C231_CS
 */

import java.util.Date;

public class TriangleInheritance {
    class GeometricObject {
        private String color;
        private boolean filled;
        private Date dateCreated;

        GeometricObject() {
        }

        GeometricObject(String color, boolean filled) {
            this.color = color;
            this.filled = filled;
            dateCreated = new Date();
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public boolean isFilled() {
            return filled;
        }

        public void setFilled(boolean filled) {
            this.filled = filled;
        }

        public Date getDateCreated() {
            return dateCreated;
        }

        public String toString() {
            return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
        }
    }

    class Triangle extends GeometricObject {
        private double side1 = 1.0;
        private double side2 = 1.0;
        private double side3 = 1.0;

        Triangle() {
        }

        Triangle(double side1, double side2, double side3) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }

        public double getSide1() {
            return side1;
        }

        public double getSide2() {
            return side2;
        }

        public double getSide3() {
            return side3;
        }

        public double getArea() {
            double s = (side1 + side2 + side3) / 2;
            return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        }

        public double getPerimeter() {
            return side1 + side2 + side3;
        }

        public String toString() {
            return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
        }
    }
}

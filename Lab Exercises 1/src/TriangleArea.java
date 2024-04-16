/*
 * Author: Marc Valdez
 * Section: C231_CS
 */

import java.util.Scanner;

public class TriangleArea {
    static class Coordinates {
        double x, y;

        Coordinates(String xStr, String yStr) {
            try {
                this.x = Double.parseDouble(xStr);
                this.y = Double.parseDouble(yStr);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid numbers separated by spaces.");
                System.exit(0);
            }
        }
    }

    static class Triangle {
        Coordinates[] vertices = new Coordinates[3];
        Double[] sides = new Double[3];
        double area = 0.0;
        Triangle(Coordinates[] vertices) {
            this.sides[0] = CalculateEdge(vertices[0].x, vertices[0].y, vertices[1].x, vertices[1].y);
            this.sides[1] = CalculateEdge(vertices[1].x, vertices[1].y, vertices[2].x, vertices[2].y);
            this.sides[2] = CalculateEdge(vertices[2].x, vertices[2].y, vertices[0].x, vertices[0].y);
            this.area = CalculateArea(this.sides);
        }

        double CalculateEdge(double x1, double y1, double x2, double y2) {
            return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        }

        double CalculateArea(Double[] sides) {
            double s = (sides[0] + sides[1] + sides[2]) / 2;
            return Math.sqrt(s * (s - sides[0]) * (s - sides[1]) * (s - sides[2]));
        }
    }
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter three coordinates for a triangle (x1, y1), (x2, y2), (x3, y3): ");
        String[] splitInput = sc.nextLine().split(" ");

        Coordinates[] points = new Coordinates[3];
        for (int i = 0, j = 0; i < splitInput.length; i += 2, j++) {
            points[j] = new Coordinates(splitInput[i], splitInput[i + 1]);
        }

        Triangle t = new Triangle(points);
        System.out.printf("The area of the triangle is %.1f", t.area);
    }
}
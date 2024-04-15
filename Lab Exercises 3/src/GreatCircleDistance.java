/*
 * Author: Marc Valdez
 * Section: C231_CS
 * Time Spent: About 7 Minutes
 */

import java.util.Scanner;

public class GreatCircleDistance {
    static class SpherePoint {
        double x, y, sinX, cosX;
        SpherePoint(double x, double y) {
            this.x = x;
            this.y = y;
            this.sinX = Math.sin(Math.toRadians(x));
            this.cosX = Math.cos(Math.toRadians(x));
        }
    }

    static Double Calculate(SpherePoint p1, SpherePoint p2) {
        double radius = 6371.01; // Average earth radius in km
        return radius * Math.acos(p1.sinX * p2.sinX + p1.cosX * p2.cosX * Math.cos(Math.toRadians(p1.y - p2.y)));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter point 1 (latitude and longitude) in degrees: ");
        String[] input1 = sc.nextLine().split(",");

        System.out.print("Enter point 2 (latitude and longitude) in degrees: ");
        String[] input2 = sc.nextLine().split(",");

        SpherePoint point1 = new SpherePoint(Double.parseDouble(input1[0]), Double.parseDouble(input1[1]));
        SpherePoint point2 = new SpherePoint(Double.parseDouble(input2[0]), Double.parseDouble(input2[1]));

        System.out.println("The distance between the two points is " + Calculate(point1, point2) + " km");

        sc.close();
    }
}
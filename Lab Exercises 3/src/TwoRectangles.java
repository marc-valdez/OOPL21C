/*
 * Author: Marc Valdez
 * Section: C231_CS
 * Time Spent: FREAKING HOURS!
 */

import java.util.Scanner;

class TwoRectangles {
    static class Rectangle {
        double x, y;
        double width, height;
        double leftX, rightX, bottomY, topY;

        Rectangle(double x, double y, double width, double height){
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;

            this.leftX = this.x - this.width/2;
            this.rightX = this.x + this.width/2;
            this.bottomY = this.y - this.height/2;
            this.topY = this.y + this.height/2;
        }

        String relationship(Rectangle other) {
            boolean isInsideX = this.leftX >= other.leftX && this.rightX <= other.rightX;
            boolean isInsideY = this.topY <= other.topY && this.bottomY >= other.bottomY;

            boolean overlapsX = this.leftX <= other.rightX && this.rightX >= other.leftX;
            boolean overlapsY = this.topY <= other.bottomY && this.topY >= other.bottomY;

            if(isInsideX && isInsideY) {
                return "is inside";
            } else if (overlapsX || overlapsY) {
                return "overlaps";
            }
            return "does not overlap";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter r1's [x, y, width, height] without commas: ");
        String[] input1 = sc.nextLine().split(" ");

        Rectangle r1 = new Rectangle(
            Double.parseDouble(input1[0]),
            Double.parseDouble(input1[1]),
            Double.parseDouble(input1[2]),
            Double.parseDouble(input1[3])
        );

        System.out.print("Enter r2's [x, y, width, height] without commas: ");
        String[] input2 = sc.nextLine().split(" ");

        Rectangle r2 = new Rectangle(
            Double.parseDouble(input2[0]),
            Double.parseDouble(input2[1]),
            Double.parseDouble(input2[2]),
            Double.parseDouble(input2[3])
        );

        String relationship = r2.relationship(r1);
        System.out.println("r2 " + relationship + " r1");

        sc.close();
    }
}
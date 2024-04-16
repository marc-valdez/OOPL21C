/*
 * Author: Marc Valdez
 * Section: C231_CS
 */

import java.util.Scanner;

public class Pentagon {
    public static double area(double side) {
        return (5 * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / 5));
    }

    public static Scanner sc = new Scanner(System.in);
    public static double getNumber(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
    }

    public static void main(String[] args) {
        double side = getNumber("Enter the side >> ");
        System.out.println("The area of the pentagon is " + area(side));
    }
}

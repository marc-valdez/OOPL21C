/*
 * Author: Marc Valdez
 * Section: C231_CS
 */

import java.util.Scanner;

public class SmallestElement {
    static Scanner sc = new Scanner(System.in);

    public static double min(double[] array) {
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.print("Enter ten numbers >> ");
        String buffer = sc.nextLine().trim();
        String[] split = buffer.split(" ");

        double[] array = new double[10];
        for (int i = 0; i < array.length; i++) {
            try {
                array[i] = Double.parseDouble(split[i]);
            } catch (Exception e) {
                System.out.println("! Invalid input. Please try again.");
                System.exit(1);
            }
        }
        System.out.println("The minimum number is: " + min(array));
    }
}
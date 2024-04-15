/*
 * Author: Marc Valdez
 * Section: C231_CS
 * Time Spent: About 6 Minutes
 */

import java.util.Scanner;

public class ISBN {
    static int[] digits = new int[9];

    static String Calculate() {
        int sum = 0;
        for (int i = 0; i < digits.length; i++) {
            sum += digits[i] * (i + 1);
        }
        sum %= 11;

        if(sum == 10) {
            return "X";
        } else {
            return (Integer.toString(sum));
        }
    }

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter the first 9 digits of an ISBN as integer: ");
        String input = sc.nextLine();
        String[] split = input.split("");
        for (int i = 0; i < split.length; i++) {
            digits[i] = Integer.parseInt(split[i]);
        }

        System.out.println("The ISBN-10 number is " + input + Calculate());
    }
}
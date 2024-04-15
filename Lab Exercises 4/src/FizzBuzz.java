/*
 * Author: Marc Valdez
 * Section: C231_CS
 * Time Spent: About 7 Minutes
 */

import java.util.Scanner;

public class FizzBuzz {
    public static Scanner sc = new Scanner(System.in);
    public static void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            if(i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if(i % 3 == 0) {
                System.out.println("Fizz");
            } else if(i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.print("Enter an integer: ");
        int n = sc.nextInt();
        
        fizzBuzz(n);
    }
}

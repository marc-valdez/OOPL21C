/*
 * Author: Marc Valdez
 * Section: C231_CS
 * Time Spent: About 50 Minutes
 */

public class Pyramid {
    public static String setWidth(String input, int width) {
        if (input.length() >= width) {
            return input;
        } else {
            return setWidth(input + " ", width);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8 - i; j++) {
                System.out.print(setWidth(" ", 4));
            }

            Integer num = 1;
            for (int j = 0; j < i; j++) {
                System.out.print(setWidth(num.toString(), 4));
                num *= 2;
            }

            num = (int) Math.pow(2, i);
            for (int j = 0; j <= i; j++) {
                System.out.print(setWidth(num.toString(), 4));
                num /= 2;
            }
            System.out.println();
        }
    }
}
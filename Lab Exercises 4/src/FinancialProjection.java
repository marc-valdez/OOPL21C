/*
 * Author: Marc Valdez
 * Section: C231_CS
 * Time Spent: About 10 Minutes
 */

public class FinancialProjection {
    public static final double YEARS = 10;

    public static void main(String[] args) throws Exception {
        double tuition = 10000;
        double rate = 0.05;

        for (int i = 0; i < YEARS; i++) {
            tuition *= (rate + 1);
        }

        System.out.printf("Tuition Cost after ten years: $%.2f%n", tuition);

        double total = 0.0;
        for (int i = 0; i < 4; i++) {
            tuition *= (rate + 1);
            total += tuition;
        }

        System.out.printf("Four years worth of tuition after the tenth year: $%.2f%n", total);
    }
}

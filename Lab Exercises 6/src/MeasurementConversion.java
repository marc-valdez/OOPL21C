/*
 * Author: Marc Valdez
 * Section: C231_CS
 */

import java.util.Scanner;

public class MeasurementConversion {
    public static double footToMeter(double foot) {
        return foot * 0.305;
    }

    public static double meterToFoot(double meter) {
        return meter * 3.279;
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

    public static String pluralize(String word, double value) {
        if (word.equals("foot"))
            return "feet";
        return value == 1 ? word : word + "s";
    }

    public static void main(String[] args) {
        while(true) {
            System.out.println("[1] foot to meter");
            System.out.println("[2] meter to foot");
            int input = (int)getNumber("Enter value >> ");

            if (input == 1) {
                double foot = getNumber("Enter foot >> ");
                double meter = footToMeter(foot);
                String[] plurality = {pluralize("foot", foot), pluralize("meter", meter)};
                System.out.println(foot + " " + plurality[0] + " = " + meter + " " + plurality[1]);
                return;
            }
            else if (input == 2) {
                double meter = getNumber("Enter meter >> ");
                double foot = meterToFoot(meter);
                String[] plurality = {pluralize("foot", foot), pluralize("meter", meter)};
                System.out.println(meter + " " + plurality[1] + " = " + foot + " " + plurality[0]);
                return;
            }
            else {
                System.out.println("! Invalid input");
            }
        }
    }
}

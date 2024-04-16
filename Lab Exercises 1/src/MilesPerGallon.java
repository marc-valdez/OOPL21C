/*
 * Author: Marc Valdez
 * Section: C231_CS
 */

import java.util.Scanner;

public class MilesPerGallon {
    static float distance = 0f;
    static float fuelEfficiency = 0f;
    static float costEfficiency = 0f;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter the driving distance: ");
        distance = sc.nextFloat();

        System.out.print("Enter miles per gallon: ");
        fuelEfficiency = sc.nextFloat();

        System.out.print("Enter price per gallon: ");
        costEfficiency = sc.nextFloat();

        float gallonsConsumed = distance / fuelEfficiency;
        float tripCost = costEfficiency * gallonsConsumed;

        System.out.printf("The cost of driving is P%.2f", tripCost);
    }
}
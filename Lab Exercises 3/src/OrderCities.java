/*
 * Author: Marc Valdez
 * Section: C231_CS
 * Time Spent: About 3 Minutes
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OrderCities {
    private final static List<String> Cities = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] ordinals = {"first", "second", "third"};
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter the " + ordinals[i] + " city: ");
            Cities.add(sc.nextLine());
        }

        System.out.print("The three cities in alphabetical order are ");
        Collections.sort(Cities);
        for(String i : Cities)
        {
            System.out.print(i);
            System.out.print(" ");
        }

        sc.close();
    }
}
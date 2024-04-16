/*
 * Author: Marc Valdez
 * Section: C231_CS
 * Time Spent: About 5 Minutes
 */

import java.util.Scanner;

public class VowelsAndConsonants {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter a string: ");
        char[] input = sc.nextLine().toCharArray();
        int vowels = 0, consonants = 0;
        for (char c : input) {
            if (c == ' ')
                continue;
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowels++;
            } else {
                consonants++;
            }
        }
        System.out.println("The number of vowels is " + vowels);
        System.out.println("The number of consonants is " + consonants);
    }
}

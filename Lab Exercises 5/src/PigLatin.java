/*
 * Author: Marc Valdez
 * Section: C231_CS
 * Time Spent: About 15 Minutes
 */

import java.util.Scanner;

public class PigLatin {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter a word: ");
        String input = sc.nextLine();

        int firstVowel = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                firstVowel = i;
                break;
            }
        }

        String newWord = input.substring(firstVowel) + input.substring(0, firstVowel) + "ay";
        System.out.println(newWord);
    }
}
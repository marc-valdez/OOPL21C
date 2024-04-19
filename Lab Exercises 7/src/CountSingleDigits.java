/*
 * Author: Marc Valdez
 * Section: C231_CS
 */

public class CountSingleDigits {
    public static void main(String[] args) {
        int[] arr = new int[100];
        int[] counts = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
            counts[arr[i]]++;
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.println("Counts: ");
        for (int i = 0; i < counts.length; i++) {
            System.out.println(i + ": " + counts[i]);
        }
    }
}
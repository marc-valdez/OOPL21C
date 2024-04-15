import java.util.Scanner;

public class SmallestDenominations {
    static int[] denominations = {1000, 500, 200, 100, 50, 20, 10, 5, 1};
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Please enter an amount in PHP: ");
        int amount = sc.nextInt(), count = 0, i = 0;
        for (int denomination : denominations) {
            while (amount >= denomination) {
                amount -= denomination;
                count++;
            }
        }
        System.out.println("The least number of denominations is: " + count);
    }
}

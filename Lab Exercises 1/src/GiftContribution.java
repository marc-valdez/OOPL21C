import java.util.Scanner;

public class GiftContribution {
    static final double plan = 10000;
    static final int students = 10;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.printf("Original Contribution: P%.2f\n", plan);
        System.out.print("Please enter the number of students who backed out: ");

        double additionalContribution = ((plan / students) * 2) / (students - sc.nextInt());
        double newContribution = plan / students + additionalContribution;

        System.out.printf("\nAdditional Contribution: P%.2f\n", additionalContribution);
        System.out.printf("New Contribution: P%.2f", newContribution);
    }
}
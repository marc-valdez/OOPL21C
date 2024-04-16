/*
 * Author: Marc Valdez
 * Section: C231_CS
 * Time Spent: About 12 Minutes
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CashBack {
    private final Map<String, Double[]> CashBackTable = new HashMap<>();

    CashBack() {
        CashBackTable.put("Dining", new Double[]{0.02, 0.04});
        CashBackTable.put("Groceries", new Double[]{0.05, 0.07});
        CashBackTable.put("Transportation", new Double[]{0.07, 0.10});
    }

    public Double calculateCashBack(Double expense, int category, int location) {
        String key = getCategoryKey(category);
        if (CashBackTable.containsKey(key)) {
            Double[] percentages = CashBackTable.get(key);
            return expense * percentages[location];
        } else {
            return 0.0;
        }
    }

    private String getCategoryKey(int category) {
        return switch (category) {
            case 1 -> "Dining";
            case 2 -> "Groceries";
            case 3 -> "Transportation";
            default -> "";
        };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CashBack table = new CashBack();

        System.out.println("[1] Dining");
        System.out.println("[2] Groceries");
        System.out.println("[3] Transportation");
        System.out.print("Expense category: ");
        int category = sc.nextInt();

        System.out.println("[0] Local");
        System.out.println("[1] Abroad");
        System.out.print("Location: ");
        int location = sc.nextInt();

        System.out.print("How much did you spend? ");
        Double expense = sc.nextDouble();

        Double cashBack = table.calculateCashBack(expense, category, location);
        System.out.println("Your cashback is $" + cashBack);

        sc.close();
    }
}
import java.util.*;

public class Main {
    static final Byte MAX = 6;
    static Byte GUESSES = 12;
    static final String REGEX = "^[1-6] [1-6] [1-6] [1-6]$";

    static List<Byte> numberBank = new ArrayList<>();
    static {
        for (Byte i = 1; i <= MAX; i++) {
            numberBank.add(i);
        }
    }

    public static List<Byte> newCode() {
        Collections.shuffle(numberBank);
        return numberBank.subList(0, 4);
    }

    @SuppressWarnings("unused")
    public static void printCode(List<Byte> code) {
        for (Byte number : code) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    public static List<Byte> newGuess(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = new Scanner(System.in).nextLine();
            if (!input.matches(REGEX)) {
                System.out.println("Invalid input. Please try again.");
            }
            else {
                List<Byte> guess = new ArrayList<>();
                for (String number : input.split(" ")) {
                    guess.add(Byte.parseByte(number.trim()));
                }
                return guess;
            }
        }
    }

    public static String testGuess(List<Byte> guess, List<Byte> secret) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < secret.size(); i++) {
            if (guess.get(i).equals(secret.get(i))) {
                output.append("*");
                System.out.print("* ");
            }
            else if (secret.contains(guess.get(i))) {
                output.append("#");
                System.out.print("# ");
            }
        }

        return output.toString();
    }

    public static void main(String[] args) {
        List<Byte> secret = newCode();

        while (GUESSES > 0) {
            List<Byte> guess = newGuess("Type your guess >> ");
            String output = testGuess(guess, secret);
            System.out.println();

            if (output.equals("****")) {
                System.out.println("You win!");
                break;
            }

            System.out.println("You have " + GUESSES + " remaining guesses.");
            GUESSES--;
        }
    }
}
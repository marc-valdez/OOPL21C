import java.util.*;

public class Main {
    static final Byte MAX = 6;
    static Byte GUESSES = 12;
    static final String REGEX = "^[1-6] [1-6] [1-6] [1-6]$";

    // List of numbers from 1 to MAX
    static List<Byte> numberBank = new ArrayList<>();
    static {
        for (Byte i = 1; i <= MAX; i++) {
            numberBank.add(i);
        }
    }

    /**
     * Shuffles and truncates the numberBank list to 4 elements.
     *
     * @return A list containing the first 4 elements after shuffling.
     */
    public static List<Byte> newCode() {
        Collections.shuffle(numberBank);
        return numberBank.subList(0, 4);
    }

    /**
     * Print the list of bytes separated by a space.
     *
     * @param code The list of numbers to be printed
     */
    @SuppressWarnings("unused")
    public static void printCode(List<Byte> code) {
        for (Byte number : code) {
            System.out.print(number + " ");
        }
        System.out.println();
    }

    /**
     * A function that takes a prompt as input, repeatedly prompts the user for input until a valid input is received,
     * then parses the input into a list of bytes and returns it.
     *
     * @param  prompt  the prompt message to display to the user
     * @return         the list of bytes parsed from the user input
     */
    public static List<Byte> newGuess(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = new Scanner(System.in).nextLine();
            if (!input.matches(REGEX)) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }

            List<Byte> guess = new ArrayList<>();
            for (String number : input.split(" ")) {
                guess.add(Byte.parseByte(number.trim()));
            }
            return guess;
        }
    }

    /**
     * Compares the guess list to the secret list and generates a string indicating the correctness of each guess.
     *
     * @param guess the list of guessed bytes
     * @param secret the list of secret bytes
     * @return a string indicating correct guesses with '*', misplaced guesses with '#'
     */
    public static String testGuess(List<Byte> guess, List<Byte> secret) {
        // Initialize a StringBuilder to store the output
        StringBuilder output = new StringBuilder();

        // Iterate over the lists to compare each element
        for (int i = 0; i < secret.size(); i++) {
            // Check if the guess is correct at the current index
            if (guess.get(i).equals(secret.get(i))) {
                output.append("*"); // Append '*' to indicate a correct guess
                System.out.print("* ");
            }
            // Check if the guess is present in the secret but at a different position
            else if (secret.contains(guess.get(i))) {
                output.append("#"); // Append '#' to indicate a misplaced guess
                System.out.print("# ");
            }
        }

        return output.toString();
    }

    /**
     * Runs the game by generating a secret code, taking guesses from the user,
     * and providing feedback on the correctness of the guesses.
     * Ends the game when the correct code is guessed or no more guesses are left.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        List<Byte> secret = newCode();

        while (GUESSES > 0) {
            List<Byte> guess = newGuess("Type your guess >> ");
            String output = testGuess(guess, secret);

            System.out.println(); // Line break for readability

            if (output.equals("****")) {
                System.out.println("You win!");
                break; // Exit the loop if the correct code is guessed
            }

            System.out.println("You have " + GUESSES + " remaining guesses.");
            GUESSES--;
        }
    }
}
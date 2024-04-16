import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final Byte MAX = 6;
    static final String REGEX = "^[1-6] [1-6] [1-6] [1-6]$";
    static Byte GUESSES = 12;
    
    /**
     * Generates a new code consisting of 4 random numbers between 1 and MAX.
     *
     * @return a list of 4 random numbers between 1 and MAX
     */
    public static List<Byte> newCode() {
        List<Byte> numberBank = new ArrayList<>();
        for (byte i = 1; i <= MAX; i++) {
            numberBank.add(i);
        }

        Collections.shuffle(numberBank);
        return numberBank.subList(0, 4);
    }

    /**
     * Generates a new code based on the given feedback and memory.
     *
     * @param feedback the feedback string
     * @param memory   the list of bytes representing the memory
     * @return the generated code as a list of bytes
     */
    public static List<Byte> newCode(String feedback, List<Byte> memory) {
        if (feedback.length() == 4) {
            Collections.shuffle(memory);
            return memory;
        }
        return newCode();
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
     * @param prompt the prompt message to display to the user
     * @return the list of bytes parsed from the user input
     */
    @Deprecated
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
     * @param guess  the list of guessed bytes
     * @param secret the list of secret bytes
     * @return a string indicating correct guesses with '*', misplaced guesses with '#'
     */
    public static String testGuess(List<Byte> guess, List<Byte> secret) {
        // Initialize a StringBuilder to store the feedback
        StringBuilder feedback = new StringBuilder();

        // Iterate over the lists to compare each element
        for (int i = 0; i < secret.size(); i++) {
            // Check if the guess is correct at the current index
            if (guess.get(i).equals(secret.get(i))) {
                feedback.append("*"); // Append '*' to indicate a correct guess
                System.out.print("* ");
            }
            // Check if the guess is present in the secret but at a different position
            else if (secret.contains(guess.get(i))) {
                feedback.append("#"); // Append '#' to indicate a misplaced guess
                System.out.print("# ");
            }
        }

        return feedback.toString();
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

        String feedback = "";
        List<Byte> memory = newCode();
        while (GUESSES > 0) {
            List<Byte> guess = newCode(feedback, memory);

            System.out.println("Guess: " + guess);

            feedback = testGuess(guess, secret);
            System.out.println(); // Line break for readability

            if (feedback.equals("****")) {
                System.out.println("You win!");
                break; // Exit the loop if the correct code is guessed
            }
            memory = guess;

            System.out.println("You have " + GUESSES + " remaining guesses.");
            GUESSES--;

            if (GUESSES == 0) {
                System.out.println("You ran out of guesses. The code was: " + secret);
            }
        }
    }
}
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final Byte MAX = 6;
    static final String REGEX = "^[1-6] [1-6] [1-6] [1-6]$";
    static Byte MAXGUESSES = 12;
    static Byte guessCount = MAXGUESSES;
    
    /**
     * Generates a new code consisting of 4 random numbers between 1 and MAX.
     *
     * @return a list of 4 random numbers between 1 and MAX
     */
    public static List<Byte> newRandomCode() {
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
    public static List<Byte> newRandomCode(String feedback, List<Byte> memory) {
        if (feedback.length() == 4) {
            Collections.shuffle(memory);
            return memory;
        }
        return newRandomCode();
    }

    public static Byte randomNumber() {
        byte buffer;
        do  {
            buffer = (byte)(((Math.random() * 6)) + 1);
        } while (inUse.contains(buffer));
        return buffer;
    }

    /*
    generate a number
    check if number is in inUse
    if in use generate new number
    if not, then return
     */

    static List<List<Byte>> guessBank = new ArrayList<>();
    static String[] testBank = new String[MAXGUESSES];
    static List<Byte> inUse = new ArrayList<>();
    static List<Byte> finalNumbers = new ArrayList<>();

    public static List<Byte> newGuess() {
        int index = MAXGUESSES - guessCount;

        inUse = finalNumbers;

        List<Byte> guess;
        if (index == 0) {
            guess = newRandomCode();
        } else {
            guess = guessBank.get(index - 1);
            for (int i = 0; i < testBank[index-1].length(); i++) {

                if(testBank[index-1].charAt(i) == '*') {
                    finalNumbers.add(guessBank.get(index - 1).get(i));
                } else {
                    Byte newNumber = randomNumber();
                    guess.set(i, newNumber);
                    inUse.add(newNumber);

                }

            }
        }

        inUse.clear();

        guessBank.add(guess);
        return guess;
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
    public static List<Byte> newUserGuess(String prompt) {
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
            else {
                feedback.append("-"); // Append '#' to indicate a misplaced guess
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
        List<Byte> secret = newRandomCode();

        String feedback = "";
        List<Byte> memory = newRandomCode();
        while (guessCount > 0) {
            List<Byte> guess = newGuess();

            System.out.println("Guess: " + guess);

            feedback = testGuess(guess, secret);
            testBank[MAXGUESSES - guessCount] = feedback;

            System.out.println(); // Line break for readability

            if (feedback.equals("****")) {
                System.out.println("You win!");
                break; // Exit the loop if the correct code is guessed
            }
            memory = guess;

            System.out.println("You have " + guessCount + " remaining guesses.");
            guessCount--;

            if (guessCount == 0) {
                System.out.println("You ran out of guesses. The code was: " + secret);
            }
        }
    }
}
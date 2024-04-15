public class RockPaperScissorsLizardSpock extends RockPaperScissors {
    static String DetermineWinner(String p1, String p2) {
        if(p1.equals(p2))
            return "It's a tie.";
        else if((p1.equals("Rock") && (p2.equals("Scissors") || p2.equals("Lizard"))) ||
                (p1.equals("Paper") && (p2.equals("Rock") || p2.equals("Spock"))) ||
                (p1.equals("Scissors") && (p2.equals("Paper") || p2.equals("Lizard"))) ||
                (p1.equals("Lizard") && (p2.equals("Spock") || p2.equals("Paper"))) ||
                (p1.equals("Spock") && (p2.equals("Scissors") || p2.equals("Rock")))
        )
            return "Player 1 wins.";
        else
            return "Player 2 wins.";
    }
    static String GetChoice(int i){
        return switch (i) {
            case 0 -> "Rock";
            case 1 -> "Paper";
            case 2 -> "Scissors";
            case 3 -> "Lizard";
            case 4 -> "Spock";
            default -> "";
        };
    }

    public static void main(String[] args) {
        System.out.println("[0] Rock\n[1] Paper\n[2] Scissors\n[3] Lizard\n[4] Spock");
        System.out.println("Please enter your choice.\n");

        System.out.print("Player 1's turn: ");
        String p1 = GetChoice(sc.nextInt());

        System.out.print("Player 2's turn: ");
        String p2 = GetChoice(sc.nextInt());

        System.out.print(DetermineWinner(p1, p2));
    }
}
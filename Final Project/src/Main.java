public class Main {
    private static final Difficulty difficulty = new Difficulty(Difficulty.Presets.EASY);

    public static void main(String[] args) {
        CodePegs secret = new CodePegs(difficulty.MAX_PEGS);

        for (int i = 0; i < difficulty.MAX_PEGS; i++) {
            Colors color = secret.getPeg(i).color;
            System.out.print(color + " ");
        }
    }
}

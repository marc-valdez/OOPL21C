public class Difficulty {
    int MAX_PEGS;
    int MAX_ATTEMPTS;

    Difficulty(Presets p) {
        switch (p) {
            case EASY:
                MAX_PEGS = 6;
                MAX_ATTEMPTS = 10;
                break;
            case AVERAGE:
                MAX_PEGS = 8;
                MAX_ATTEMPTS = 12;
                break;
            case DIFFICULT:
                MAX_PEGS = 10;
                MAX_ATTEMPTS = 16;
                break;
            case EXTREME:
                MAX_PEGS = 16;
                MAX_ATTEMPTS = 20;
        }
    }

    protected enum Presets {
        EASY, AVERAGE, DIFFICULT, EXTREME
    }
}

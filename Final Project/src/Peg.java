import java.util.List;

public class Peg {
    protected Colors color;

    protected Peg(List<Colors> usedColors) {
        do {
            this.color = Colors.values()[(int) (Math.random() * Colors.values().length)];
//            if (usedColors.contains(this.color)) {
//                System.out.println("Color already used, trying again...");
//            } else {
//                System.out.println("Color not used.");
//            }
        } while (usedColors.contains(this.color));
    }

    public void printPeg(int index) {
        System.out.print("[" + (index + 1) + "] " + this.color);
    }
}
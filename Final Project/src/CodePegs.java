import java.util.ArrayList;
import java.util.List;

public class CodePegs {
    private final List<Peg> codePegs;

    CodePegs(int numberOfPegs) {
        codePegs = new ArrayList<>();
        List<Colors> usedColors = new ArrayList<>();

        for (int i = 0; i < numberOfPegs; i++) {
            Peg temp = new Peg(usedColors);
            usedColors.add(temp.color);
            codePegs.add(temp);
        }
    }

    public Peg getPeg(int index) {
        return codePegs.get(index);
    }
}
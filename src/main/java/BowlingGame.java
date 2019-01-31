import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BowlingGame {
    public static int calculate(List<Frame> frames) {
        int score = 0;



        for(Frame frame : frames){
            score += frame.getRoll1() + frame.getRoll2();
        };

        for(int i=0; i<frames.size(); i++) {
            if (frames.get(i).isStrike() && i<frames.size()-1) {
                score += frames.get(i+1).getRoll1();
                score += frames.get(i+1).getRoll2();
            }
            if (frames.get(i).isSpare() && i<frames.size()-1) {
                score += frames.get(i+1).getRoll1();
            }
        }

        return score;
    }

    public static int score(String scores) {
        if (scores == null || scores.isEmpty()) {
            return calculate(Collections.emptyList());
        }
        String[] scorePairs = scores.split(" ");
        return calculate(Arrays.stream(scorePairs)
                .map(Frame::new)
        .collect(Collectors.toList()));
    }
}

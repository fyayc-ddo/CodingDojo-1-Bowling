import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BowlingGameTest {
    @Test
    public void runTest() {
        List<Frame> frames = Collections.emptyList();
        assertEquals(0, BowlingGame.calculate(frames));
    }

    @Test
    public void singlePinInFrame() {
        List<Frame> frames = new LinkedList<>();
        Frame frame = new Frame(1, 0);
        frames.add(frame);
        assertEquals(1, BowlingGame.calculate(frames));
    }

    @Test
    void twoScoresInFrame() {
        List<Frame> frames = new LinkedList<>();
        frames.add(new Frame(2, 4));
        assertEquals(6, BowlingGame.calculate(frames));
    }

    @Test
    void twoFrames() {
        List<Frame> frames = new LinkedList<>();
        frames.add(new Frame(2, 4));
        frames.add(new Frame(2, 4));
        assertEquals(12, BowlingGame.calculate(frames));
    }

    @Test
    void fullLine() {
        List<Frame> frames = new LinkedList<>();
        Frame frame = new Frame(2, 4);
        for (int i = 0; i < 10; i++) {
            frames.add(frame);
        }
        assertEquals(60, BowlingGame.calculate(frames));
    }

    @Test
    void spareInLine() {
        List<Frame> frames = new LinkedList<>();
        frames.add(new Frame(4,"/"));
        for (int i = 0; i < 9; i++) {
            frames.add(new Frame(2, 4));
        }
        assertEquals(66, BowlingGame.calculate(frames));
    }

    @Test
    void testText() {
        assertEquals(0, BowlingGame.score(""));
    }

    @Test
    void textSinglePin() {
        assertEquals(1, BowlingGame.score("1"));
    }

    @Test
    void textTwoScoresInFrame() {
        assertEquals(3, BowlingGame.score("1,2"));
    }

    @Test
    void textFullLine() {
        assertEquals(30,
                BowlingGame.score("1,2 0,3 1,2 0,3 1,2 0,3 1,2 0,3 " +
                        "1,2 0,3 "));
    }

    @Test
    void textFullLineWithSpare(){
        assertEquals(38,
                BowlingGame.score("1,2 0,/ 1,2 0,3 1,2 0,3 1,2 0,3 " +
                        "1,2 0,3 "));
    }

    @Test
    void textFullLineWithMultipleSpare(){
        assertEquals(46,
                BowlingGame.score("1,2 0,/ 1,2 0,3 1,2 0,3 1,2 0,/ " +
                        "1,2 0,3 "));
    }

    @Test
    void textFullLineWithStrike(){
        assertEquals(40,
                BowlingGame.score("1,2 X 1,2 0,3 1,2 0,3 1,2 0,3 " +
                        "1,2 0,3 "));
    }

    @Test
    void textFullLineWithSpareAtEnd(){
        assertEquals(48,
                BowlingGame.score("1,2 X 1,2 0,3 1,2 0,3 1,2 0,3 " +
                        "1,2 0,/,1 "));
    }

    @Test
    void textFullLineWithStrikeAtEnd(){
        assertEquals(54,
                BowlingGame.score("1,2 X 1,2 0,3 1,2 0,3 1,2 0,3 " +
                        "1,2 X,1,6 "));
    }

    @Test
    void textAllStrikes(){
        assertEquals(300,
                BowlingGame.score("X X X X X X X X X X X X"));
    }
}

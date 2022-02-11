import processing.core.PApplet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourBallsChallengeOOP extends PApplet {

    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    public static final int DIAMETER = 10;
    public static final int TOTAL_BALLS = 4;

    int[] balls;

    public static void main(String[] args) {
        PApplet.main("FourBallsChallengeOOP");
    }

    @Override
    public void settings() {
        generateInitialBallsList();
        size(WIDTH, HEIGHT);
    }

    @Override
    public void draw() {
        for (int i = 1; i <= TOTAL_BALLS; i++) {
            moveBall(i);
        }
    }

    private void generateInitialBallsList() {
        this.balls = new int[TOTAL_BALLS];
        Arrays.fill(this.balls, 0);
    }

    private void moveBall(int ballNo) {
        ellipse(getBallPosition(ballNo), getBallHeightFromTop(ballNo), DIAMETER, DIAMETER);
        setNextPositionOfBall(ballNo);
    }

    private void setNextPositionOfBall(int ballNo) {
        this.balls[getBallIndexFromBallsList(ballNo)] += ballNo;
    }

    private int getBallHeightFromTop(int ballNo) {
        return ballNo * (HEIGHT / (TOTAL_BALLS + 1));
    }

    private int getBallPosition(int ballNo) {
        return this.balls[getBallIndexFromBallsList(ballNo)];
    }

    private int getBallIndexFromBallsList(int ballNo) {
        return ballNo - 1;
    }
}

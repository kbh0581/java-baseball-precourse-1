package baseball.domain;

public enum Hint {
    BALL, STRIKE, NOTTING, getHint;

    public static Hint getHint(int position, Ball ball, NumberBaseBall targetBaseBall) {
        if (targetBaseBall.getPositionBall(ball) == position) {
            return STRIKE;
        }
        if (targetBaseBall.getPositionBall(ball) == NumberBaseBall.EMPTY_POSITION) {
            return NOTTING;
        }
        return Hint.BALL;
    }
}

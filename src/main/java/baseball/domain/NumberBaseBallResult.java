package baseball.domain;

public class NumberBaseBallResult {

    private int ballCount = 0;
    private int strikeCount = 0;
    private int notingCount = 0;

    private final NumberBaseBall checkSourceBaseBall;

    public NumberBaseBallResult(NumberBaseBall checkSourceBaseBall) {
        this.checkSourceBaseBall = checkSourceBaseBall;
    }

    // 체크결과의 상태를 가져옴
    public NumberBaseBallResultStatus check(NumberBaseBall checkTargetBaseBall) {
        setResultCount(checkTargetBaseBall);
        return strikeCount ==  NumberBaseBall.MAX_BALL_COUNT
                ? NumberBaseBallResultStatus.COLLECT : NumberBaseBallResultStatus.HINT;
    }

    private void setResultCount(NumberBaseBall checkTargetBaseBall) {
        for (int position = 0; position < NumberBaseBall.MAX_BALL_COUNT; position++) {
            Hint hint = Hint.getHint(
                position, checkTargetBaseBall.getBalls().get(position), this.checkSourceBaseBall);
            ballHintCountAdd(hint);
        }
    }

    private void ballHintCountAdd(Hint hint) {
        if (hint == Hint.BALL) {
            this.ballCount++;
        }
        if (hint == Hint.STRIKE) {
            this.strikeCount++;
        }
        if (hint == Hint.NOTTING) {
            this.notingCount++;
        }
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getNotingCount() {
        return notingCount;
    }
}

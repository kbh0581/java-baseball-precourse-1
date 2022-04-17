package baseball.domain;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberBaseBall {
    private final List<Ball> balls;
    public static final int EMPTY_POSITION = -1;
    public static final int MAX_BALL_COUNT = 3;

    public NumberBaseBall(List<Ball> balls) {
        this.balls = balls;
        validate();
        validDuplicateBall();
    }

    public List<Ball> getBalls() {
        return balls;
    }

    /*
    * 랜덤한 볼을 생성하는 메서드
    * */
    public static NumberBaseBall createRandomBalls() {
        List<Ball> randomBalls = new LinkedList<>();
        Randoms.pickUniqueNumbersInRange(
            Ball.MIN_NUMBER_RANGE, Ball.MAX_NUMBER_RAGE, NumberBaseBall.MAX_BALL_COUNT)
                .forEach((number) -> randomBalls.add(new Ball(number)));
        return new NumberBaseBall(randomBalls);
    }

    /*
     * 볼의 포지션확인
     * */
    public int getPositionBall(Ball ball) {
        return balls.indexOf(ball);
    }

    /*
     * 숫자 세자리 확인
     * */
    private void validate() {
        if (this.balls.size() != 3) {
            throw new IllegalArgumentException("볼의 숫자는 "+ MAX_BALL_COUNT + "자리여야만 합니다.");
        }
    }

    /*
    * 중복된 볼인지 확인
    * */
    private void validDuplicateBall() {
        HashSet<Ball> ballsHash = new HashSet<>(this.balls);
        if (ballsHash.size() != 3) {
            throw new IllegalArgumentException("중복된 볼의 값이 있습니다." + this.balls);
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        NumberBaseBall that = (NumberBaseBall) object;
        return Objects.equals(balls, that.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }
}

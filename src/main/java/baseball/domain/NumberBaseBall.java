package baseball.domain;

import java.util.HashSet;
import java.util.List;

public class NumberBaseBall {
    private final List<Ball> balls;

    public NumberBaseBall(List<Ball> balls) {
        this.balls = balls;
        validate();
        validDuplicateBall();
    }

    /*
     * 숫자 세자리 확인
     * */
    private void validate() {
        if (this.balls.size() != 3) {
            throw new IllegalArgumentException("볼의 숫자는 3자리여야만 합니다.");
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
}

package baseball.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberBaseBallTest {

    @Test
    @DisplayName("볼의 숫자는 3자리만 가능하다.")
    void threeLength() {
        List<Ball> balls = Arrays.asList(new Ball(3), new Ball(4), new Ball(5));
        new NumberBaseBall(balls);

        //두자리수의 볼
        List<Ball> twoBalls = Arrays.asList(new Ball(3), new Ball(4));
        assertThatIllegalArgumentException().isThrownBy(() -> new NumberBaseBall(twoBalls));

        //네자리수의 볼
        List<Ball> fourBalls = Arrays.asList(new Ball(3), new Ball(4), new Ball(5), new Ball(7));
        assertThatIllegalArgumentException().isThrownBy(() -> new NumberBaseBall(fourBalls));
    }

    @Test
    @DisplayName("중복된 볼넘버를 가질수 없다")
    void isNotOverlapNumberBall() {
        List<Ball> overlapBalls = Arrays.asList(new Ball(3), new Ball(3), new Ball(5));
        assertThatIllegalArgumentException().isThrownBy(() -> new NumberBaseBall(overlapBalls));

        List<Ball> notOverlapBalls = Arrays.asList(new Ball(3), new Ball(2), new Ball(5));
        new NumberBaseBall(notOverlapBalls);
    }

    @Test
    @DisplayName("볼의 위치를 찾아본다")
    void getPositionBall() {
        NumberBaseBall numberBaseBall = new NumberBaseBall(
                Arrays.asList(new Ball(3), new Ball(2), new Ball(5)));

        assertThat(numberBaseBall.getPositionBall(new Ball(3))).isEqualTo(0);
        assertThat(numberBaseBall.getPositionBall(new Ball(2))).isEqualTo(1);
        assertThat(numberBaseBall.getPositionBall(new Ball(5))).isEqualTo(2);

        assertThat(numberBaseBall.getPositionBall(new Ball(9)))
                .isEqualTo(NumberBaseBall.EMPTY_POSITION);
    }

    @Test
    @DisplayName("랜덤한 숫자넘버를 생성한다.")
    void createRandomBall() {
        NumberBaseBall randomBalls = NumberBaseBall.createRandomBalls();
        assertThat(randomBalls).isNotNull();
        assertThat(randomBalls.getBalls().size() == 3).isTrue();

    }

    @Test
    @DisplayName("볼의 숫자가 같으면 numberBaseBall 클래스는 같다.")
    void numberBaseBallEqual() {
        NumberBaseBall numberBaseBall1 = new NumberBaseBall(
                Arrays.asList(new Ball(3), new Ball(4), new Ball(5)));

        NumberBaseBall numberBaseBall2 = new NumberBaseBall(
                Arrays.asList(new Ball(3), new Ball(4), new Ball(5)));

        NumberBaseBall numberBaseBall3 = new NumberBaseBall(
                Arrays.asList(new Ball(3), new Ball(4), new Ball(1)));

        assertThat(numberBaseBall1).isEqualTo(numberBaseBall2);
        assertThat(numberBaseBall1).isNotEqualTo(numberBaseBall3);
    }
}

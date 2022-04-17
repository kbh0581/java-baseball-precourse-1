package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.Ball;

public class BallTest {

    @Test
    @DisplayName("볼은 숫자는 1~9만 가질 수 있다")
    void ballNumberRange1_9() {
        List<Integer> successBallNumbers = Arrays.asList(1, 3, 5, 7);
        List<Integer> failBallNumbers = Arrays.asList(10, 11, 0, 13);
        successBallNumbers.forEach(Ball::new);
        failBallNumbers.forEach((number) ->
                assertThatIllegalArgumentException().isThrownBy(() -> new Ball(number)));

    }
}

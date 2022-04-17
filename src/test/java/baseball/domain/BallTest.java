package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallTest {

    @Test
    @DisplayName("볼은 숫자는 1~9만 가질 수 있다")
    void ballNumberRange1_9() {
        List<Integer> successBallNumbers = Arrays.asList(1, 3, 5, 7);
        List<Integer> failBallNumbers = Arrays.asList(10, 11, 0, 13);
        successBallNumbers.forEach(Ball::new);
        failBallNumbers.forEach((number) ->
                assertThatIllegalArgumentException().isThrownBy(() -> new Ball(number)));

    }

    @Test
    @DisplayName("같은 숫자의 볼은 같다.")
    void ballEqualTest() {
        assertThat(new Ball(3)).isEqualTo(new Ball(3));
        assertThat(new Ball(2)).isEqualTo(new Ball(2));
        assertThat(new Ball(3)).isNotEqualTo(new Ball(4));
    }
}

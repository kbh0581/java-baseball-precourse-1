package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HintTest {
    private NumberBaseBall targetNumberBaseBall;

    @BeforeEach
    void init() {
        targetNumberBaseBall = new NumberBaseBall(
                Arrays.asList(new Ball(3), new Ball(4), new Ball(5)));
    }

    @Test
    @DisplayName("힌트를 검증 한다")
    void hint() {
        assertThat(Hint.getHint(0, new Ball(3), targetNumberBaseBall)).isEqualTo(Hint.STRIKE);
        assertThat(Hint.getHint(0, new Ball(5), targetNumberBaseBall)).isEqualTo(Hint.BALL);
        assertThat(Hint.getHint(0, new Ball(1), targetNumberBaseBall)).isEqualTo(Hint.NOTTING);
    }
}

package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberBaseBallResultTest {

    private NumberBaseBallResult numberBaseBallResult;
    private NumberBaseBall collectNumber;
    private NumberBaseBall hintNumber;

    @BeforeEach
    void init() {
        numberBaseBallResult = new NumberBaseBallResult(
                new NumberBaseBall(Arrays.asList(new Ball(3), new Ball(4), new Ball(5))));

        collectNumber = new NumberBaseBall(
                Arrays.asList(new Ball(3), new Ball(4), new Ball(5)));

        hintNumber = new NumberBaseBall(
                Arrays.asList(new Ball(3), new Ball(2), new Ball(5)));
    }

    @Test
    @DisplayName("숫자를 다맞출시 Collect, 아닐경우 Hint 반환")
    void checkNumberBaseResult() {
        NumberBaseBallResultStatus collect = numberBaseBallResult.check(collectNumber);
        NumberBaseBallResultStatus hint = numberBaseBallResult.check(hintNumber);
        assertThat(collect).isEqualTo(NumberBaseBallResultStatus.COLLECT);
        assertThat(hint).isEqualTo(NumberBaseBallResultStatus.HINT);
    }

    @Test
    @DisplayName("결과 값 Count 테스트")
    void resultCount() {
        NumberBaseBallResultStatus hint = numberBaseBallResult.check(hintNumber);
        assertThat(numberBaseBallResult.getBallCount()).isEqualTo(0);
        assertThat(numberBaseBallResult.getStrikeCount()).isEqualTo(2);
        assertThat(numberBaseBallResult.getNotingCount()).isEqualTo(1);

        assertThat(hint).isEqualTo(NumberBaseBallResultStatus.HINT);
    }

}
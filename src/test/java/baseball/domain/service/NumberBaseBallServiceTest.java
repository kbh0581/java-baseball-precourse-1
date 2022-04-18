package baseball.domain.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.domain.Computer;
import baseball.domain.NumberBaseBallResult;
import baseball.domain.NumberBaseBallResultStatus;
import baseball.domain.Player;

class NumberBaseBallServiceTest {

    @Test
    @DisplayName("numberBaseBallAnswer의 결과를 테스트")
    void numberBaseBallServiceResult() {
        NumberBaseBallService numberBaseBallService = new NumberBaseBallService();
        Computer computer = new Computer();
        Player player = new Player();
        player.changeNumberBaseBall(computer.getNumberBaseBall());
        NumberBaseBallResult numberBaseBallResult =
                numberBaseBallService.numberBaseBallAnswer(computer, player);

        assertThat(numberBaseBallResult.getCheckStatus())
                .isEqualTo(NumberBaseBallResultStatus.COLLECT);
    }
}

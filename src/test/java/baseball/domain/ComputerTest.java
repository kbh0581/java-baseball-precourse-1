package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    @DisplayName("컴퓨터 랜덤값으로 변경")
    void changeRandomValue() {
        Computer computer = new Computer();
        List<Ball> list = new ArrayList<>(computer.getNumberBaseBall().getBalls());
        NumberBaseBall numberBaseBall = new NumberBaseBall(list);

        computer.changeBall();

        NumberBaseBall numberBaseBall2 = computer.getNumberBaseBall();

        assertThat(numberBaseBall).isNotEqualTo(numberBaseBall2);
    }
}

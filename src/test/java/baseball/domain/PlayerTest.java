package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    @DisplayName("Player의 numberBaseBall이 변경 된다.")
    void changeNumberBaseBall() {
        NumberBaseBall numberBaseBall = NumberBaseBall.createNumberBaseBall(Arrays.asList(3, 4, 5));
        Player player = new Player();
        player.changeNumberBaseBall(numberBaseBall);

        assertThat(player.getNumberBaseBall()).isEqualTo(numberBaseBall);
    }

    @Test
    @DisplayName("Player의 숫자가 이상한경우 IllegalArgumentException가 발생된다.")
    void inputPlayerNotMatchNumber() {
        Player player = new Player();
        assertThatIllegalArgumentException().isThrownBy(() -> player.changeNumberBaseBall(
            NumberBaseBall.createNumberBaseBall(Arrays.asList(3, 3, 5)))
        );
    }
}
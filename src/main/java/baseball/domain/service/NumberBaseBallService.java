package baseball.domain.service;

import baseball.domain.Computer;
import baseball.domain.NumberBaseBallResult;
import baseball.domain.Player;

public class NumberBaseBallService {

    // 컴퓨터와 플레이어를 볼넘버를 체크 하는 메서드
    public NumberBaseBallResult numberBaseBallAnswer(Computer computer, Player player) {
        NumberBaseBallResult numberBaseBallResult =
                new NumberBaseBallResult(computer.getNumberBaseBall());
        numberBaseBallResult.check(player.getNumberBaseBall());
        return numberBaseBallResult;
    }
}

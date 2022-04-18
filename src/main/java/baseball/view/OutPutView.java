package baseball.view;

import baseball.domain.NumberBaseBallResult;

public class OutPutView {
    public void collectMsg() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    public void exitMsg() {
        System.out.println("게임 종료");
    }

    public void hintResultMsg(NumberBaseBallResult numberBaseBallResult) {
        System.out.println(numberBaseBallResult);
    }
}

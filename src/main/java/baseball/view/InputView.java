package baseball.view;

import baseball.util.ArrayUtil;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public Integer[] inputBaseBallNumber() {
        System.out.print("숫자를 입력해주세요 :");
        String input = Console.readLine();
        return ArrayUtil.convertStringToInteger(input.split(""));
    }

    public String exitQuestion() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}

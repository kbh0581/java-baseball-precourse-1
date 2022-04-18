package baseball.controller;


import baseball.domain.Computer;
import baseball.domain.Game;
import baseball.domain.GameStatus;
import baseball.domain.NumberBaseBall;
import baseball.domain.NumberBaseBallResult;
import baseball.domain.NumberBaseBallResultStatus;
import baseball.domain.Player;
import baseball.domain.service.NumberBaseBallService;
import baseball.view.InputView;
import baseball.view.OutPutView;
import java.util.Arrays;

public class GameController {
    private final InputView inputView;
    private final OutPutView outPutView;
    private final NumberBaseBallService numberBaseBallService;

    public GameController(InputView inputView, OutPutView outPutView,
                          NumberBaseBallService numberBaseBallService) {
        this.inputView = inputView;
        this.outPutView = outPutView;
        this.numberBaseBallService = numberBaseBallService;
    }

    public void start() {
        Player player = new Player();
        Computer computer = new Computer();
        Game game = new Game();
        game.start();
        while (game.getStatus() == GameStatus.START) {
            if (progress(player, computer, game)) {
                break;
            }
        }
        outPutView.exitMsg();
    }

    //게임 진행중인 메서드
    private boolean progress(Player player, Computer computer, Game game) {
        playerQuestion(player);
        NumberBaseBallResult numberBaseBallResult =
                numberBaseBallService.numberBaseBallAnswer(computer, player);
        outPutView.hintResultMsg(numberBaseBallResult);
        if (numberBaseBallResult.getCheckStatus() == NumberBaseBallResultStatus.COLLECT) {
            outPutView.collectMsg();
            return isRestartGame(game);
        }
        return false;
    }

    // 리스타트 여부를 확인
    private boolean isRestartGame(Game game) {
        game.changeGameStatus(inputView.exitQuestion());
        if (game.getStatus() == GameStatus.START) {
            start();
            return true;
        }
        return false;
    }

    // 플레이어에게 숫자를 물어보는 행위
    private void playerQuestion(Player player) {
        player.changeNumberBaseBall(NumberBaseBall.createNumberBaseBall(
                Arrays.asList(inputView.inputBaseBallNumber())));
    }
}

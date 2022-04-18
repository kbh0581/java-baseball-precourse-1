package baseball;

import baseball.controller.GameController;
import baseball.domain.service.NumberBaseBallService;
import baseball.view.InputView;
import baseball.view.OutPutView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutPutView outPutView = new OutPutView();
        NumberBaseBallService ballService = new NumberBaseBallService();
        GameController gameController = new GameController(inputView, outPutView, ballService);
        gameController.start();

    }
}

package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.domain.ParticipantGenerater;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        ParticipantGenerater participantGenerater = new ParticipantGenerater();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        RacingGame racingGame = new RacingGame(participantGenerater, randomNumberGenerator, outputView);
        RacingGameController racingGameController = new RacingGameController(inputView, outputView, racingGame);

        racingGameController.play();

    }
}

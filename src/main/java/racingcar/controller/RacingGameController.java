package racingcar.controller;

import java.util.List;
import racingcar.domain.Participant;
import racingcar.domain.RacingGame;
import racingcar.dto.RacingGameDto;
import racingcar.dto.WinnerDto;
import racingcar.view.InputView;
import racingcar.view.OutputView;

/***
 * RacingGame을 관리하는 컨트롤러 RacingGameController
 * 사용자에게 입력과 게임 진행, 결과를 반환
 */
public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingGame racingGame;

    public RacingGameController(InputView inputView, OutputView outputView, RacingGame racingGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingGame = racingGame;
    }

    public void play() {
        RacingGameDto racingGameDto = inputView.input();
        List<Participant> winners = racingGame.play(racingGameDto);
        outputView.printResult(WinnerDto.from(winners));
    }
}

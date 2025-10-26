package racingcar;

import java.util.List;
import racingcar.controller.RacingGameController;
import racingcar.domain.ParticipantGenerater;
import racingcar.domain.RacingGame;
import racingcar.domain.RandomNumberGenerator;
import racingcar.role.GameRole;
import racingcar.role.RandomNumberRole;
import racingcar.validator.count.CountRangeValidator;
import racingcar.validator.name.NameLengthValidator;
import racingcar.validator.name.NameValidator;
import racingcar.validator.name.NullNameValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        /***
         * 각 Validator 객체 정의
         */
        CountRangeValidator countRangeValidator = new CountRangeValidator();
        NullNameValidator nullNameValidator = new NullNameValidator();
        NameLengthValidator nameLengthValidator = new NameLengthValidator();

        /**
         * View 객체 의존성 주입
         */
        InputView inputView = new InputView(countRangeValidator, nullNameValidator);
        OutputView outputView = new OutputView();

        List<NameValidator> nameValidators = List.of(nullNameValidator, nameLengthValidator);

        /***
         * Generator,RacingGame,컨트롤러에 필요한 객체 정의 및 주입
         */
        RandomNumberRole randomNumberRole = new RandomNumberRole();
        List<GameRole> gameRoles = List.of(randomNumberRole);
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        ParticipantGenerater participantGenerater = new ParticipantGenerater(nameValidators);
        RacingGame racingGame = new RacingGame(participantGenerater, randomNumberGenerator, outputView, gameRoles);
        RacingGameController racingGameController = new RacingGameController(inputView, outputView, racingGame);

        racingGameController.play(); // 애플리케이션 실행

    }
}

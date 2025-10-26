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
        CountRangeValidator countRangeValidator = new CountRangeValidator();
        NullNameValidator nullNameValidator = new NullNameValidator();
        NameLengthValidator nameLengthValidator = new NameLengthValidator();

        InputView inputView = new InputView(countRangeValidator, nullNameValidator);
        OutputView outputView = new OutputView();

        List<NameValidator> nameValidators = List.of(nullNameValidator, nameLengthValidator);

        ParticipantGenerater participantGenerater = new ParticipantGenerater(nameValidators);
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        RandomNumberRole randomNumberRole = new RandomNumberRole();
        List<GameRole> gameRoles = List.of(randomNumberRole);

        RacingGame racingGame = new RacingGame(participantGenerater, randomNumberGenerator, outputView, gameRoles);
        RacingGameController racingGameController = new RacingGameController(inputView, outputView, racingGame);

        racingGameController.play();

    }
}

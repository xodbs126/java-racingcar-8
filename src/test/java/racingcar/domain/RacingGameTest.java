package racingcar.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingGameDto;
import racingcar.role.GameRole;
import racingcar.role.RandomNumberRole;
import racingcar.validator.name.NameLengthValidator;
import racingcar.validator.name.NullNameValidator;
import racingcar.view.OutputView;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;


class RacingGameTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private RacingGame racingGame;
    private OutputView outputView;
    private ParticipantGenerater participantGenerater;
    private RandomNumberGenerator randomNumberGenerator;
    private List<GameRole> gameRoles;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        NameLengthValidator nameLengthValidator = new NameLengthValidator();
        NullNameValidator nullNameValidator = new NullNameValidator();
        participantGenerater = new ParticipantGenerater(List.of(nameLengthValidator,nullNameValidator));
        randomNumberGenerator = new RandomNumberGenerator();
        RandomNumberRole randomNumberRole = new RandomNumberRole();
        gameRoles = List.of(randomNumberRole);
        racingGame = new RacingGame(participantGenerater, randomNumberGenerator, outputView,gameRoles);
    }

    @Test
    @DisplayName("play() 메서드가 게임 진행")
    void 게임_정상_시나리오() {
        RacingGameDto dto = new RacingGameDto("pobi,jun", 2);


        // when
        assertRandomNumberInRangeTest(
                () -> {
                    List<Participant> winners = racingGame.play(dto);

                    assertThat(winners).hasSize(1);
                    assertThat(winners.get(0).getName()).isEqualTo("pobi");
                    assertThat(winners.get(0).getCarPosition()).isEqualTo(2);

                    String consoleOutput = output();
                    assertThat(consoleOutput)
                            .contains("pobi : -", "jun : ")
                            .contains("pobi : --", "jun : ");
                },
                MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("play() 메서드가 공동 우승 시나리오 진행")
    void 공동_우승_시나리오() {
        // given

        RacingGameDto dto = new RacingGameDto("pobi,jun", 1);
        int MOVE_POBI = 5;
        int MOVE_JUN = 6;

        // when
        assertRandomNumberInRangeTest(
                () -> {
                    List<Participant> winners = racingGame.play(dto);
                    assertThat(winners).hasSize(2);
                    assertThat(winners)
                            .extracting(Participant::getName)
                            .containsExactly("pobi", "jun");

                    assertThat(output()).contains("pobi : -", "jun : -");
                },
                MOVE_POBI, MOVE_JUN
        );
    }

    @Override
    protected void runMain() {

    }
}
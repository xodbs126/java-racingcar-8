package racingcar.role;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Participant;

class RandomNumberRoleTest {

    private GameRole gameRole;
    private Participant participant;

    @BeforeEach
    void setUp() {
        gameRole = new RandomNumberRole();
        participant = new Participant("pobi");
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("랜덤 숫자가 4 이상이면 전진")
    void 숫자_4이상_전진(int randomNumber) {
        // when
        gameRole.movePosition(participant, randomNumber);

        // then
        assertThat(participant.getCarPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("랜덤 숫자가 3 이하이면 정지.")
    void 숫자_3이하_정지(int randomNumber) {

        // when
        gameRole.movePosition(participant, randomNumber);

        // then
        assertThat(participant.getCarPosition()).isEqualTo(0);
    }
}

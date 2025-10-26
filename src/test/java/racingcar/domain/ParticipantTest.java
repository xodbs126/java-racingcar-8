package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParticipantTest {

    @Test
    @DisplayName("참가자 생성 시 이름이 5자를 초과하면 예외가 발생한다.")
    void 이름_5자를_넘어가는_예외() {
        //given
        String longName = "longname";

        //when / then
        assertThatThrownBy(() -> new Participant(longName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하로만 가능합니다.");
    }

    @Test
    @DisplayName("참가자 생성 시 이름이 5자 이하이면 정상 생성된다.")
    void 이름_5자_이하입력() {
        // given
        String validName = "valid";

        // when
        Participant participant = new Participant(validName);

        // then
        assertThat(participant.getName()).isEqualTo(validName);
        assertThat(participant.getCarPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("move() 호출 시 랜덤 숫자가 4 이상이면 전진한다.")
    void 랜덤_숫자_4이상_전진(int randomNumber) {
        // given
        Participant participant = new Participant("pobi");

        // when
        participant.move(randomNumber);

        // then
        assertThat(participant.getCarPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("move() 호출 시 랜덤 숫자가 3 이하이면 정지한다.")
    void 랜덤_숫자_3이하_정지(int randomNumber) {
        // given
        Participant participant = new Participant("pobi");

        // when
        participant.move(randomNumber);

        // then
        assertThat(participant.getCarPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("move()를 여러 번 호출하여 위치가 누적된다.")
    void 현재_위치_확인() {
        // given
        Participant participant = new Participant("pobi");

        // when
        participant.move(5);
        participant.move(9);

        // then
        assertThat(participant.getCarPosition()).isEqualTo(2);
    }
}
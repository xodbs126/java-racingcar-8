package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantTest {


    @Test
    @DisplayName("참가자 생성한다.")
    void 이름_5자_이하입력() {
        // given
        String validName = "valid";

        // when
        Participant participant = new Participant(validName);

        // then
        assertThat(participant.getName()).isEqualTo(validName);
        assertThat(participant.getCarPosition()).isEqualTo(0);
    }


    @Test
    @DisplayName("move()를 여러 번 호출하여 위치가 누적된다.")
    void 현재_위치_확인() {
        // given
        Participant participant = new Participant("pobi");

        // when
        participant.move(1);
        participant.move(1);

        // then
        assertThat(participant.getCarPosition()).isEqualTo(2);
    }
}
package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.name.NameLengthValidator;
import racingcar.validator.name.NameValidator;
import racingcar.validator.name.NullNameValidator;

class ParticipantGeneraterTest {

    private ParticipantGenerater generater;
    private List<NameValidator> nameValidators;
    @BeforeEach
    void setUp(){
        NameLengthValidator nameLengthValidator = new NameLengthValidator();
        NullNameValidator nullNameValidator = new NullNameValidator();
        nameValidators = List.of(nameLengthValidator, nullNameValidator);
         generater = new ParticipantGenerater(nameValidators);
    }


    @Test
    @DisplayName("사용자 입력을 통해 참가자들 Participant을 생성한다.")
    void 참가자_Participant_생성_() {
        //given
        String input = "pobi,woni,jun";

        //when
        List<Participant> participants = generater.generate(input);

        // then
        assertThat(participants).hasSize(3);
        assertThat(participants)
                .extracting(Participant::getName)
                .containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("사용자입력에 공백이 있을 경우")
    void 사용자입력에_공백이_있을_경우() {
        // given
        String input = "  pobi ,woni, jun  ";

        // when
        List<Participant> participants = generater.generate(input);

        // then
        assertThat(participants).hasSize(3);
        assertThat(participants)
                .extracting(Participant::getName)
                .containsExactly("pobi", "woni", "jun");
    }

    @Test
    @DisplayName("참가자가 한 명인 경우도 생성된다")
    void 참가자가_한명_인_경우() {
        // given
        String input = "pobi";

        // when
        List<Participant> participants = generater.generate(input);

        // then
        assertThat(participants).hasSize(1);
        assertThat(participants.get(0).getName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("5자가 넘는 이름이 있으면 예외가 발생한다.")
    void 이름길이가_5자_넘는_참여자_생성(){
        // given
        String input = "pobi,longName,jun";

        // when / then
        assertThatThrownBy(() -> generater.generate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자 이하로만 가능합니다.");
    }
}
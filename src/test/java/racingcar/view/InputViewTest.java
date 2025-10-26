package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingGameDto;
import racingcar.validator.input.CountRangeValidator;
import racingcar.validator.input.NullNameValidator;

class InputViewTest {

    private final CountRangeValidator countRangeValidator = new CountRangeValidator();
    private final NullNameValidator nameValidator = new NullNameValidator();

    private final InputView inputView = new InputView(countRangeValidator,nameValidator);
    private final InputStream originalIn = System.in;

    @AfterEach
    void restoreSystemIn() {
        System.setIn(originalIn);
        Console.close();
    }

    private void simulateInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    @DisplayName("참가자 이름과 시도 횟수를 입력받아 RacingGameDto를 생성")
    void 사용자_입력() {

        String participantNames = "pobi,woni,jun";
        String count = "5";
        String input = participantNames + "\n" + count;
        simulateInput(input);

        // when
        RacingGameDto dto = inputView.input();

        // then
        assertThat(dto.names()).isEqualTo(participantNames);
        assertThat(dto.count()).isEqualTo(Integer.parseInt(count));
    }

    @Test
    @DisplayName("시도 횟수에 숫자가 아닌 값을 입력하면 IllegalArgumentException이 발생")
    void 잘못된_횟수_입력() {
        // given
        String names = "pobi,woni";
        String invalidCount = "abc";
        String input = names + "\n" + invalidCount;
        simulateInput(input);

        // when / then
        assertThatThrownBy(inputView::input)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름을 미입력하면 IllegalArgumentException이 발생")
    void 이름_미입력() {
        // given
        String names = "";
        String invalidCount = "5";
        String input = names + "\n" + invalidCount;
        simulateInput(input);

        // when / then
        assertThatThrownBy(inputView::input)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
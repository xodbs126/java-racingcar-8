package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Participant;
import racingcar.dto.RacingGameProcessDto;
import racingcar.dto.WinnerDto;

class OutputViewTest {

    private final OutputView outputView = new OutputView();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("게임 진행 과정을 사용자에게 출력")
    void 게임과정_사용자출력() {
        // given
        Participant pobi = new Participant("pobi");
        pobi.move(1);
        pobi.move(1);

        Participant KTY = new Participant("KTY");
        KTY.move(1);

        List<Participant> participants = List.of(pobi, KTY);


        // when
        outputView.printProcess(RacingGameProcessDto.from(participants));

        // then
        String expectedOutput = "pobi : --" + System.lineSeparator()
                + "KTY : -" + System.lineSeparator()
                + System.lineSeparator();

        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    @DisplayName("우승자가 1명일 경우 결과 출력")
    void 우승자가_한명일때() {
        // given
        List<WinnerDto> winners = List.of(new WinnerDto("pobi"));

        // when
        outputView.printResult(winners);

        // then
        String expectedOutput = "최종 우승자 : pobi" + System.lineSeparator();
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    @DisplayName("우승자가 여러명 일 때 결과 출력")
    void 우승자가_여러명일때() {

        // given
        List<WinnerDto> winners = List.of(
                new WinnerDto("pobi"),
                new WinnerDto("KTY")
        );

        // when
        outputView.printResult(winners);

        // then
        String expectedOutput = "최종 우승자 : pobi, KTY" + System.lineSeparator();
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }
}
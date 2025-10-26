package racingcar.view;

import java.util.List;
import racingcar.dto.RacingGameProcessDto;
import racingcar.dto.WinnerDto;

public class OutputView {
    public void printResult(List<WinnerDto> winners) {
        List<String> winnerNames = winners.stream()
                .map(WinnerDto::name)
                .toList();
        String winnerString = String.join(", ", winnerNames);

        System.out.println("최종 우승자 : " + winnerString);
    }

    public void printProcess(List<RacingGameProcessDto> participants) {
        for (RacingGameProcessDto participant : participants) {
            System.out.println(participant.name() + " : " + "-".repeat(participant.carPosition()));
        }
        System.out.println();
    }
}

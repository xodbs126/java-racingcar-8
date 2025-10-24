package racingcar.view;

import java.util.List;
import racingcar.domain.Participant;
import racingcar.dto.WinnerDto;

public class OutputView {
    public void printResult(List<WinnerDto> winners) {
        List<String> winnerNames = winners.stream()
                .map(WinnerDto::name)
                .toList();
        String winnerString = String.join(", ", winnerNames);

        System.out.println("최종 우승자 : " + winnerString);
    }

    public void printProcess(List<Participant> participants) {
        for (Participant participant : participants) {
            System.out.println(participant.getName() + " : " + "-".repeat(participant.getCarPosition()));
        }
        System.out.println();
    }
}

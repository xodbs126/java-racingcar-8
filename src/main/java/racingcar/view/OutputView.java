package racingcar.view;

import java.util.List;
import racingcar.dto.RacingGameProcessDto;
import racingcar.dto.WinnerDto;

/***
 * 사용자에게 결과값을 제공하는 객체
 */
public class OutputView {
    /***
     * 사용자에게 우승자를 제공하는 메서드
     * @param winners
     */
    public void printResult(List<WinnerDto> winners) {
        List<String> winnerNames = winners.stream()
                .map(WinnerDto::name)
                .toList();
        String winnerString = String.join(", ", winnerNames);

        System.out.println("최종 우승자 : " + winnerString);
    }

    /***
     * 사용자에게 게임 진행상황을 제공하는 메서드
     * @param participants
     */
    public void printProcess(List<RacingGameProcessDto> participants) {
        for (RacingGameProcessDto participant : participants) {
            System.out.println(participant.name() + " : " + "-".repeat(participant.carPosition()));
        }
        System.out.println();
    }
}

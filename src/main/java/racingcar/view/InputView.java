package racingcar.view;


import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.RacingGameDto;

public class InputView {

    private static int inputCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = Integer.parseInt(Console.readLine());
        return count;
    }

    private static String inputName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        return names;
    }

    public RacingGameDto input() {
        String names = inputName();
        int count = inputCount();

        return RacingGameDto.from(names, count);
    }
}

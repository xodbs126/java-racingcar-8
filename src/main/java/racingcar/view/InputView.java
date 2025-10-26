package racingcar.view;


import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.RacingGameDto;
import racingcar.validator.count.CountValidator;
import racingcar.validator.name.NameValidator;

/***
 * 사용자 입력을 맡는 InputView 클래스
 */
public class InputView {

    private final CountValidator countValidator;
    private final NameValidator nameValidator;

    public InputView(CountValidator countValidator, NameValidator nameValidator) {
        this.countValidator = countValidator;
        this.nameValidator = nameValidator;
    }

    /***
     * 사용자로부터 시도할 횟수 입력 받음
     * @return 시도할 횟수
     */
    private int inputCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            int count = Integer.parseInt(Console.readLine());
            countValidator.isValid(count);

            return count;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 시도 횟수의 입력이 아닙니다.");
        }
    }

    /***
     * 사용자로부터 Racing 참여자의 이름을 입력 받음
     * @return 참여자들의 이름
     */
    private String inputName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String names = Console.readLine();

        nameValidator.isValid(names);
        return names;
    }

    /***
     * 참여자들의 이름과 시도할 횟수를 포함하는 RacingGameDto 반환
     * @return RacingGameDto
     */
    public RacingGameDto input() {
        String names = inputName();
        int count = inputCount();

        return RacingGameDto.from(names, count);
    }
}

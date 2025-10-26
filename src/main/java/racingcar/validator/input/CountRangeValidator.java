package racingcar.validator.input;

public class CountRangeValidator implements CountValidator {

    private static final Integer MIN_COUNT = 1;

    @Override
    public void isValid(Integer count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException("최소 " + MIN_COUNT + "회 이상 실행해야합니다.");
        }
    }
}

package racingcar.validator.count;

/***
 * 시행 횟수 count의 규칙 객체
 */
public class CountRangeValidator implements CountValidator {

    private static final Integer MIN_COUNT = 1;

    /***
     * count는 MIN_COUNT보다 커야함
     * @param count
     */
    @Override
    public void isValid(Integer count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException("최소 " + MIN_COUNT + "회 이상 실행해야합니다.");
        }
    }
}

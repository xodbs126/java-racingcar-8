package racingcar.validator.count;

/***
 * 시행 횟수 count를 설정 규칙 추상화
 */
public interface CountValidator {

    void isValid(Integer input);
}

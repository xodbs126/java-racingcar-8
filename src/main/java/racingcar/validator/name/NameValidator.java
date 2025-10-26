package racingcar.validator.name;

/***
 * 참여자들의 이름 작명 규칙을 추상화하는 객체
 */
public interface NameValidator {
    void isValid(String name);
}

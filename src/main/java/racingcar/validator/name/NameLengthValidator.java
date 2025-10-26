package racingcar.validator.name;

/***
 * 이름 규칙을 설정하는 규칙을 정의한 객체
 */
public class NameLengthValidator implements NameValidator {

    private static Integer NAME_LENGTH = 5;

    /***
     * name은 NAME_LENGTH보다 크면 제한된다.
     * @param name
     */
    @Override
    public void isValid(String name) {
        if (name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하로만 가능합니다.");
        }
    }
}

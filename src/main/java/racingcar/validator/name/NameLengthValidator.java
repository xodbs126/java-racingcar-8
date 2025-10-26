package racingcar.validator.name;

public class NameLengthValidator implements NameValidator {

    private static Integer NAME_LENGTH = 5;
    @Override
    public void isValid(String name) {
        if (name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하로만 가능합니다.");
        }
    }
}

package racingcar.validator.name;

public class NameLengthValidator implements NameValidator {

    @Override
    public void isValid(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하로만 가능합니다.");
        }
    }
}

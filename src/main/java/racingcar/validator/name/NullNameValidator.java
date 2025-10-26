package racingcar.validator.name;

public class NullNameValidator implements NameValidator {
    @Override
    public void isValid(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("참가자 이름은 필수 입력값 입니다.");
        }
    }
}

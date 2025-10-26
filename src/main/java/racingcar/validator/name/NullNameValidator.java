package racingcar.validator.name;

public class NullNameValidator implements NameValidator {
    /***
     * 이름이 null 값일때 예외를 처리하는 메서드
     * @param input
     */
    @Override
    public void isValid(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("참가자 이름은 필수 입력값 입니다.");
        }
    }
}

package racingcar.domain;

public class Participant {
    private final String name;

    private Integer carPosition = 0;

    public Participant(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하로만 가능합니다.");
        }
        this.name = name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            this.carPosition++;
        }
    }

    public String getName() {
        return this.name;
    }

    public Integer getCarPosition() {
        return this.carPosition;
    }
}

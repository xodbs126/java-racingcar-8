package racingcar.domain;

public class Participant {
    private final String name;

    private Integer carPosition = 0;

    public Participant(String name) {
        this.name = name;
    }

    public void move(Integer interval) {
        this.carPosition += interval;
    }

    public String getName() {
        return this.name;
    }

    public Integer getCarPosition() {
        return this.carPosition;
    }
}

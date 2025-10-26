package racingcar.domain;

/***
 * 참여자들의 이름, 현재 위치를 저장하는 객체
 */
public class Participant {
    private final String name;

    private Integer carPosition = 0;

    public Participant(String name) {
        this.name = name;
    }

    /***
     * 게임내에 설정되어 있는 interval에 따른 전진
     * @param interval 게임내 설정된 interval
     */
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

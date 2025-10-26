package racingcar.role;

import racingcar.domain.Participant;

/***
 * 게임의 규칙을 추상화한 GameRole
 */
public interface GameRole {

    void movePosition(Participant participant, Integer randomNumber);
}
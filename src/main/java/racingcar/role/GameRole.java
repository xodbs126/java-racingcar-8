package racingcar.role;

import racingcar.domain.Participant;

public interface GameRole {

    void movePosition(Participant participant, Integer randomNumber);
}
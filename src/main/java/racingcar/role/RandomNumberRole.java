package racingcar.role;

import racingcar.domain.Participant;

public class RandomNumberRole implements GameRole {

    private static final int MOVE_ROLE = 4;
    private static final int MOVE_INTERVAL = 1;

    @Override
    public void movePosition(Participant participant, Integer randomNumber) {
        if (randomNumber >= MOVE_ROLE) {
            participant.move(MOVE_INTERVAL);
        }
    }
}

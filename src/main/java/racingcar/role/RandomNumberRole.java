package racingcar.role;

import racingcar.domain.Participant;

/***
 * 참여자의 자동차의 위치를 변경하는 규칙
 */
public class RandomNumberRole implements GameRole {

    private static final int MOVE_ROLE = 4;
    private static final int MOVE_INTERVAL = 1;

    /***
     * 참여자가 MOVE_ROLE 이상의 randomNumber를 뽑으면, MOVE_INTERVAL만큼 전진
     * @param participant
     * @param randomNumber
     */
    @Override
    public void movePosition(Participant participant, Integer randomNumber) {
        if (randomNumber >= MOVE_ROLE) {
            participant.move(MOVE_INTERVAL);
        }
    }
}

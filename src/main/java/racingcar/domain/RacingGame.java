package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.RacingGameDto;
import racingcar.dto.RacingGameProcessDto;
import racingcar.role.GameRole;
import racingcar.view.OutputView;

public class RacingGame {

    private final ParticipantGenerater participantGenerater;
    private final RandomNumberGenerator randomNumberGenerator;
    private final OutputView outputView;
    private final List<GameRole> gameRoles;

    public RacingGame(ParticipantGenerater participantGenerater, RandomNumberGenerator randomNumberGenerator,
                      OutputView outputView, List<GameRole> gameRoles) {
        this.participantGenerater = participantGenerater;
        this.randomNumberGenerator = randomNumberGenerator;
        this.outputView = outputView;
        this.gameRoles = gameRoles;
    }

    /***
     * 시도 횟수 count만큼 RacingGame을 진행
     * @param racingGameDto 참여자들의 이름과 시도 횟수를 포함
     * @return 우승자리스트
     */
    public List<Participant> play(RacingGameDto racingGameDto) {
        List<Participant> participants = generateParticipants(racingGameDto);

        int count = racingGameDto.count();
        for (int i = 0; i < count; i++) {
            gameProcess(participants);
            outputView.printProcess(RacingGameProcessDto.from(participants));
        }

        List<Participant> winnerList = getWinners(participants);

        return winnerList;

    }

    /***
     * 우승자를 가려내는 매서드
     * @param participants
     * @return 우승자인 Participant 리스트
     */
    private List<Participant> getWinners(List<Participant> participants) {

        int maxPosition = 0;
        for (Participant participant : participants) {
            maxPosition = Math.max(maxPosition, participant.getCarPosition());
        }

        List<Participant> winners = new ArrayList<>();
        for (Participant participant : participants) {
            if (participant.getCarPosition() == maxPosition) {
                winners.add(participant);
            }
        }

        return winners;
    }

    /***
     * 게임 진행 진척도를 나타는 메서드
     * @param participants
     */
    private void gameProcess(List<Participant> participants) {

        for (Participant participant : participants) {
            Integer randomNumber = randomNumberGenerator.generateRandomNumber();
            checkRole(participant, randomNumber);
        }
    }

    /***
     * 자동차가 전진 여부를 판단하는 메서드
     * @param participant 현재 진행중인 참여자
     * @param randomNumber 참여자가 뽑은 랜덤 숫자
     */
    private void checkRole(Participant participant, Integer randomNumber) {
        for (GameRole gameRole : gameRoles) {
            gameRole.movePosition(participant, randomNumber);
        }
    }

    /***
     * recingGameDto에 포함된 참여자들을 분리하는 메서드
     * @param racingGameDto
     * @return 참여자들의 리스트 List<Participant>
     */
    private List<Participant> generateParticipants(RacingGameDto racingGameDto) {
        String participantList = racingGameDto.names();
        List<Participant> participants = participantGenerater.generate(participantList);

        return participants;
    }
}

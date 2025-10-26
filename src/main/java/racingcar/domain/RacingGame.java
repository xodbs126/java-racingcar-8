package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.dto.RacingGameDto;
import racingcar.dto.RacingGameProcessDto;
import racingcar.view.OutputView;

public class RacingGame {

    private final ParticipantGenerater participantGenerater;
    private final RandomNumberGenerator randomNumberGenerator;
    private final OutputView outputView;

    public RacingGame(ParticipantGenerater participantGenerater, RandomNumberGenerator randomNumberGenerator,
                      OutputView outputView) {
        this.participantGenerater = participantGenerater;
        this.randomNumberGenerator = randomNumberGenerator;
        this.outputView = outputView;
    }

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

    private void gameProcess(List<Participant> participants) {

        for (Participant participant : participants) {
            Integer randomNumber = randomNumberGenerator.generateRandomNumber();
            participant.move(randomNumber);
        }

    }

    private List<Participant> generateParticipants(RacingGameDto racingGameDto) {
        String participantList = racingGameDto.names();
        List<Participant> participants = participantGenerater.generate(participantList);

        return participants;
    }
}

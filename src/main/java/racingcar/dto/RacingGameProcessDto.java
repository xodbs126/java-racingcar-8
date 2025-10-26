package racingcar.dto;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Participant;

public record RacingGameProcessDto(String name, Integer carPosition) {

    public static List<RacingGameProcessDto> from(List<Participant> participantList) {
        return participantList.stream()
                .map(participant -> new RacingGameProcessDto(
                        participant.getName(),
                        participant.getCarPosition()
                ))
                .collect(Collectors.toList());
    }
}

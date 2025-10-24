package racingcar.dto;

import java.util.List;
import racingcar.domain.Participant;

public record WinnerDto(String name) {

    public static List<WinnerDto> from(List<Participant> participants) {
        return participants.stream()
                .map(participant -> new WinnerDto(participant.getName()))
                .toList();
    }
}

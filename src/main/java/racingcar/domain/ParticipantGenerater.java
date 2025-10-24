package racingcar.domain;

import java.util.Arrays;
import java.util.List;

public class ParticipantGenerater {
    public List<Participant> generate(String participantList) {
        String[] splitName = participantList.split(",");

        return Arrays.stream(splitName)
                .map(String::trim)
                .map(Participant::new)
                .toList();
    }
}

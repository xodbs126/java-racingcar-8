package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import racingcar.validator.name.NameValidator;


public class ParticipantGenerater {

    private final List<NameValidator> nameValidators;

    public ParticipantGenerater(List<NameValidator> nameValidators) {
        this.nameValidators = nameValidators;
    }

    public List<Participant> generate(String participantList) {
        String[] splitName = participantList.split(",");
        return Arrays.stream(splitName)
                .map(String::trim)
                .peek(this::validateName)
                .map(Participant::new)
                .toList();
    }

    private void validateName(String name) {
        for (NameValidator validator : nameValidators) {
            validator.isValid(name);
        }
    }
}
package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import racingcar.validator.name.NameValidator;

/***
 * 게임 참여자들을 ","로 나누는 객체
 */
public class ParticipantGenerater {

    private final List<NameValidator> nameValidators;

    public ParticipantGenerater(List<NameValidator> nameValidators) {
        this.nameValidators = nameValidators;
    }

    /***
     * 게임 참여자들을 ","로 나누는 메서드
     * @param participantList
     * @return
     */
    public List<Participant> generate(String participantList) {
        String[] splitName = participantList.split(",");
        return Arrays.stream(splitName)
                .map(String::trim)
                .peek(this::validateName)
                .map(Participant::new)
                .toList();
    }

    /***
     * 참여자 이름 작명 규칙 여부를 판별하는 메서드
     * @param name
     */
    private void validateName(String name) {
        for (NameValidator validator : nameValidators) {
            validator.isValid(name);
        }
    }
}
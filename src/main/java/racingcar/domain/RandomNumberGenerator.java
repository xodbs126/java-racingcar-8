package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

/***
 * 랜덤 숫자를 뽑는 객체
 */
public class RandomNumberGenerator {

    private static final int RANDOM_NUMBER_START = 0;
    private static final int RANDOM_NUMBER_END = 9;

    public Integer generateRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_START, RANDOM_NUMBER_END);
    }
}
## 우아한 테크코스 프리코스 2주차 미션: 자동차 경주

## 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.
---

## 기능 목록
- [x] 레이싱 게임을 관리하는 `RacingGameController` 클래스 구현
  - [x] 게임 실행을 담당하는 `play()` 메서드 구현


- [x] 사용자 입력을 받는 `InputView` 클래스 구현
  - [x] 참여자 이름을 입력 받는 `inputName()` 메서드 구현
  - [x] 게임 횟수를 입력 받는 `inputCount()` 메서드 구현


- [x] 레이싱 게임을 실행하는 로직을 담당하는 `RacingGame` 클래스 구현
  - [x] 레이싱 게임을 실행하는 `play()` 메서드 구현
  - [x] 레이싱 게임의 우승자를 반환하는 `checkWinners()` 메서드 구현
  - [x] 레이싱 게임의 진행을 보여주는 `gameProcess()` 메서드 구현
  - [x] 레이싱 게임의 참가자를 생성하는 `generateParticipants()` 메서드 구현
  

- [x] 레이싱 게임 참여자를 나타내는 `Participant` 클래스 구현
  - [x] 참여자의 이름을 반환하는 `getName()` 메서드 구현
  - [x] 참여자의 자동차 위치를 반환하는 `getCarPosition()` 메서드 구현
  - [x] 참여자의 자동차를 1칸 이동시키는 `moveCar()` 메서드 구현


- [x] 랜덤 값을 생성하는 `RandomNumberGenerator` 클래스 구현
  - [x] 0부터 9까지의 랜덤 정수 값을 반환하는 `generate()` 메서드 구현


- [x] 레이싱 참여자 객체를 생성하는 `ParticipantGenerator` 클래스 구현
  - [x] 참여자 이름 목록을 받아 참여자들을 반환하는 `generate()` 메서드 구현


- [x] 게임에 필요한 객체를 컨트롤러로 전달하는 DTO 클래스 구현
  - [x] 참여자와 게임 횟수를 포함하는 `RacingGameDTO` 클래스 구현
  - [x] 게임의 우승자를 포함하는 `WinnerDTO` 클래스 구현


- [x] 사용자 결과값을 반환하는 `OutputView` 클래스 구현
  - [x] 게임 진행 상황을 출력하는 `printProcess()` 메서드 구현
  - [x] 우승자를 출력하는 `printResult()` 메서드 구현

---
## 예외처리
- [x] 참여자의 이름이 5자를 초과할 경우 `IllegalArgumentException` 발생
- [x] 게임 횟수가 음수일 경우 `IllegalArgumentException` 발생
- [x] 참여자 이름이 비어있을 경우 `IllegalArgumentException` 발생
- [x] 게임 횟수가 양수가 아닌 경우 `IllegalArgumentException` 발생
- [x] 게임 횟수에 숫자가 아닌 값을 입력할 경우 `IllegalArgumentException` 발생

---
## 개선점
- [x] GameRole을 통한 게임 규칙 추상화
- [x] Validator 클래스를 통한 입력 값 검증 로직 분리
  - [x] CountValidator 클래스 구현
  - [x] NameValidator 클래스 구현


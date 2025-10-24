package racingcar.dto;

public record RacingGameDto(String names, Integer count) {

    public static RacingGameDto from(String names, Integer count) {
        return new RacingGameDto(names, count);
    }
}

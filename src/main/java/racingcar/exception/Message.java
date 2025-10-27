package racingcar.exception;

public enum Message {
    EMPTY_CAR_INPUT("경주할 자동차들의 이름이 입력되지 않았습니다."),
    INVALID_CAR_INPUT("자동차 이름을 두 개 이상 입력해주세요."),

    CAR_NAME_MAX_LENGTH_LIMIT("자동차 이름은 5자 이하입니다."),
    CAR_NAME_MIN_LENGTH_LIMIT("자동차 이름은 공백이 될 수 없습니다."),

    DUPLICATE_CAR_NAME("중복된 자동차 이름이 존재합니다."),

    EMPTY_ROUND_INPUT("경주를 시도할 횟수가 입력되지 않았습니다."),
    ROUND_NOT_NUMBER("시도할 횟수는 정수로 입력해야 합니다."),
    INVALID_ROUND_INPUT("시도할 횟수는 0 이상입니다."),

    WINNING_CAR_LIST_EMPTY("우승자는 한 명 이상입니다."),
    ;

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

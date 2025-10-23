package racingcar.exception;

public enum Message {
    INVALID_CAR_INPUT("자동차 이름을 하나 이상 입력해주세요."),
    ROUND_RANGE_ERROR("시도할 횟수는 1 이상이어야 합니다."),
    ROUND_INPUT_EMPTY("시도할 횟수를 입력해주세요."),

    CAR_NAME_MAX_LENGTH_LIMIT("자동차 이름은 5자 이하입니다."),
    CAR_NAME_MIN_LENGTH_LIMIT("자동차 이름은 1자 이상입니다."),

    WINNING_CAR_LIST_EMPTY("우승자는 한 명 이상입니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

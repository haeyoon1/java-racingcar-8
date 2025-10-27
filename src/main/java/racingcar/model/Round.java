package racingcar.model;

import racingcar.exception.Message;

public record Round(int value) {

    private static final int MIN_ROUND = 1;

    public Round {
        if (value <= MIN_ROUND) {
            throw new IllegalArgumentException(Message.INVALID_ROUND_INPUT.getMessage());
        }
    }
}

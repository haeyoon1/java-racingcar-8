package racingcar.model;

import racingcar.exception.Message;

public class Round {
    private static final int MIN_ROUND = 1;

    private final int value;

    public Round(String round) {
        validateRound(round);
        int parsedRound = Integer.parseInt(round);
        validateRoundNumber(parsedRound);

        this.value = parsedRound;
    }

    private void validateRound(String inputRound) {
        if (inputRound == null || inputRound.isEmpty()){
            throw new IllegalArgumentException(Message.EMPTY_ROUND_INPUT.getMessage());
        }
        if (!inputRound.matches("\\d+")) { // 정규식 - 숫자로만 구성된 문자열
            throw new IllegalArgumentException(Message.ROUND_NOT_NUMBER.getMessage());
        }
    }

    private void validateRoundNumber(int parsedRound) {
        if (parsedRound <= MIN_ROUND){
            throw new IllegalArgumentException(Message.INVALID_ROUND_INPUT.getMessage());
        }
    }

    public int getRound() {
        return value;
    }
}

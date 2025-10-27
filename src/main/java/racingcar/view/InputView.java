package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.Message;

public class InputView {

    public static String inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String cars = Console.readLine();
        InputView.validateCarInput(cars);
        return cars;
    }

    public static int inputRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        String round = Console.readLine();
        validateRoundInput(round);
        return Integer.parseInt(round);
    }

    private static void validateCarInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(Message.EMPTY_CAR_INPUT.getMessage());
        }
    }

    private static void validateRoundInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(Message.EMPTY_ROUND_INPUT.getMessage());
        }
        if (!input.matches("\\d+")) { // 정규식 - 숫자로만 구성된 문자열
            throw new IllegalArgumentException(Message.ROUND_NOT_NUMBER.getMessage());
        }
    }
}

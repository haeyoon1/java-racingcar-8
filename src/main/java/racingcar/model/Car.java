package racingcar.model;

import racingcar.exception.Message;
import racingcar.util.RandomGenerator;

public class Car {

    private static final int MAX_CAR_NAME_LENGHT = 5;
    private static final int MOVE_STANDARD = 4;
    private static final int MOVE_DISTANCE = 1;

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name) {
        if (name.length() > MAX_CAR_NAME_LENGHT) { // 자동차 이름의 길이는 5 이하이다
            throw new IllegalArgumentException(Message.CAR_NAME_MAX_LENGTH_LIMIT.getMessage());
        }
        if (name == null || name.isEmpty()) { // 자동차 이름이 비어있으면 오류를 반환한다
            throw new IllegalArgumentException(Message.CAR_NAME_MIN_LENGTH_LIMIT.getMessage());
        }
    }

    public void moveCar() {
        int number = RandomGenerator.randomGenerator();
        if (number < MOVE_STANDARD) {
            return;
        }
        position += MOVE_DISTANCE;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

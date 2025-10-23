package racingcar.model;

import racingcar.exception.Message;
import racingcar.util.RandomGenerator;

public class Car {

    private static final int MOVE_STANDARD = 4;
    private static final int MOVE_DISTANCE = 1;

    private String name;
    private int position = 0;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(Message.INVALID_CAR_INPUT.getValue());
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

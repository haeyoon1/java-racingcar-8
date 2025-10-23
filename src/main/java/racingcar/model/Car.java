package racingcar.model;

import racingcar.util.RandomGenerator;

public class Car {

    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveCar() {
        int number = RandomGenerator.randomGenerator();
        if (number < 4) {
            return;
        }
        position += 1;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}

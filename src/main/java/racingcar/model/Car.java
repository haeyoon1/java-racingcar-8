package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;

public class Car {

    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public static List<String> splitCarNames(String carsInput) {
        return Arrays.asList(carsInput.split(","));
    }

    private int randomGenerator() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void moveCar() {
        int number = randomGenerator();
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

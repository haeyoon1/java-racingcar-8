package racingcar.model;

import java.util.List;

public class Winners {

    private List<Car> cars;

    public static List<String> calculateWinners(List<Car> cars) {
        int maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .getAsInt();

        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(Car::getName)
            .toList();
    }
}

package racingcar.model;

import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars calculateWinners() {
        int maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .getAsInt();

        List<Car> carList = cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .toList();

        return new Cars(carList);
    }

    public List<Car> getCars() {
        return cars;
    }
}

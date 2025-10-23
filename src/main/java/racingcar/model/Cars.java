package racingcar.model;

import java.util.List;
import racingcar.util.InputParser;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars initializeCars(String inputCars) {
        return new Cars(
            InputParser.splitCarNames(inputCars)
                .stream()
                .map(Car::new)
                .toList()
        );
    }

    public void moveAll(Cars cars) {
        for (Car car : cars.getCars()) {
            car.moveCar();
        }
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

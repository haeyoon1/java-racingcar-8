package racingcar.model;

import java.util.List;
import racingcar.exception.Message;
import racingcar.util.InputParser;

public class Cars {

    private List<Car> cars;

    public Cars(String inputCars) {
        List<Car> carList = InputParser.splitCarNames(inputCars)
            .stream()
            .map(Car::new)
            .toList();
        validateCars(carList);

        this.cars = carList;
    }

    private static void validateCars(List<Car> cars) {
        if (cars == null || cars.isEmpty()) { // 자동차 리스트가 비어있을 시 오류 반환
            throw new IllegalArgumentException(Message.EMPTY_CAR_INPUT.getMessage());
        }

        if (cars.size() <= 1) { // 하나의 자동차 입력 시 오류 반환
            throw new IllegalArgumentException(Message.INVALID_CAR_INPUT.getMessage());
        }

        Long uniqueCarCount = cars.stream()
            .map(Car::getName)
            .distinct()
            .count();
        if (uniqueCarCount != cars.size()) { // 자동차 이름 중복 시 오류 반환
            throw new IllegalArgumentException(Message.DUPLICATE_CAR_NAME.getMessage());
        }
    }

    public void moveAll() {
        for (Car car : cars) {
            car.moveCar();
        }
    }

    public WinningCars calculateWinners() {
        int maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .getAsInt();

        List<Car> carList = cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .toList();

        return new WinningCars(carList);
    }

    public List<Car> getCars() {
        return cars;
    }
}

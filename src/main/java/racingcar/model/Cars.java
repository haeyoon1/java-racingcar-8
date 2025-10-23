package racingcar.model;

import java.util.List;
import racingcar.exception.Message;
import racingcar.util.InputParser;

public class Cars {

    private List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars fromInput(String inputCars) { // 입력 검증 로직을 포함한 Cars 객체 생성 정적 팩토리 메서드
        List<Car> carList = InputParser.splitCarNames(inputCars)
            .stream()
            .map(Car::new)
            .toList();
        validateInputCars(carList);

        return new Cars(carList);
    }

    public static Cars from(List<Car> cars) { // Cars 객체 생성 정적 팩토리 메서드 (우승 Cars 객체 생성 시 사용)
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException(Message.WINNING_CAR_LIST_EMPTY.getMessage());
        }
        return new Cars(cars);
    }

    private static void validateInputCars(List<Car> cars) {
        if (cars == null || cars.isEmpty()) { // 자동차 이름 미입력 시 오류 반환
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

        return Cars.from(carList);
    }

    public List<Car> getCars() {
        return cars;
    }
}

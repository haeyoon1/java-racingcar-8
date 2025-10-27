package racingcar.model;

import java.util.List;
import racingcar.exception.Message;

public class WinningCars {

    private final List<Car> cars;

    public WinningCars(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException(Message.WINNING_CAR_LIST_EMPTY.getMessage());
        }

        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}

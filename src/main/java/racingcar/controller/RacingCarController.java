package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Winners;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    public void run() {
        String inputCars = InputView.inputCars();
        int inputRounds = InputView.inputRound();

        List<String> carNames = Car.splitCarNames(inputCars);
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }
}

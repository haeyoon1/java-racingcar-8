package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.util.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    public void run() {
        String inputCars = InputView.inputCars();
        int inputRounds = InputView.inputRound();

        List<String> carNames = InputParser.splitCarNames(inputCars);
        List<Car> carList = new ArrayList<>();

        Cars cars = new Cars(carList);

        for (String name : carNames) {
            carList.add(new Car(name));
        }

        for (int i = 0; i < inputRounds; i++) {
            for (Car car : carList) {
                car.moveCar();
            }
            OutputView.printGameResult(carList);
        }

        List<String> winners = cars.calculateWinners();
        OutputView.printGameWinner(winners);
    }
}

package racingcar.model;

import racingcar.util.InputParser;
import racingcar.view.OutputView;

public class Game {

    public Cars carRacing(String inputCars, int inputRounds) {
        Cars cars = new Cars(
            InputParser.splitCarNames(inputCars)
                .stream()
                .map(Car::new)
                .toList()
        );

        for (int i = 0; i < inputRounds; i++) {
            for (Car car : cars.getCars()) {
                car.moveCar();
            }
            OutputView.printGameResult(cars);
        }

        return cars.calculateWinners();
    }
}

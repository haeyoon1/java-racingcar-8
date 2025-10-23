package racingcar.model;

import racingcar.util.InputParser;
import racingcar.view.OutputView;

public class Game {

    public Cars carRacing(String inputCars, int inputRounds) {
        Cars cars = initializeCars(inputCars);
        playGame(cars, inputRounds);
        return cars.calculateWinners();
    }

    private Cars initializeCars(String inputCars) {
        return new Cars(
            InputParser.splitCarNames(inputCars)
                .stream()
                .map(Car::new)
                .toList()
        );
    }

    private void playGame(Cars cars, int inputRounds) {
        for (int i = 0; i < inputRounds; i++) {
            for (Car car : cars.getCars()) {
                car.moveCar();
            }
            OutputView.printGameResult(cars);
        }
    }
}

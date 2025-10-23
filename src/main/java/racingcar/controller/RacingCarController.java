package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    public void run() {
        String inputCarNames = InputView.inputCars();
        int inputRounds = InputView.inputRound();

        Cars cars = Cars.initializeCars(inputCarNames);

        OutputView.printGameResultMessage();
        startRacing(cars, inputRounds);

        Cars winners = cars.calculateWinners();
        OutputView.printGameWinner(winners);
    }

    private void startRacing(Cars cars, int inputRounds) {
        for (int i = 0; i < inputRounds; i++) {
            cars.moveAll(cars);
            OutputView.printGameResult(cars);
        }
    }
}

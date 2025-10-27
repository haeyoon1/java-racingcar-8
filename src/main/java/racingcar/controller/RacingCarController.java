package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Round;
import racingcar.model.WinningCars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    public void run() {
        String inputCarNames = InputView.inputCars();
        Cars cars = Cars.from(inputCarNames);
        int inputRounds = InputView.inputRound();
        Round rounds = new Round(inputRounds);

        OutputView.printGameResultMessage();
        startRacing(cars, rounds);

        WinningCars winners = cars.calculateWinners();
        OutputView.printGameWinner(winners);
    }

    private void startRacing(Cars cars, Round inputRounds) {
        int rounds = inputRounds.value();

        for (int i = 0; i < rounds; i++) {
            cars.moveAll();
            OutputView.printGameResult(cars);
        }
    }
}

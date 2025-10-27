package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Round;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    public void run() {
        String inputCarNames = InputView.inputCars();
        Cars cars = Cars.fromInput(inputCarNames);
        String inputRounds = InputView.inputRound();
        Round round = new Round(inputRounds);

        OutputView.printGameResultMessage();
        startRacing(cars, round);

        Cars winners = cars.calculateWinners();
        OutputView.printGameWinner(winners);
    }

    private void startRacing(Cars cars, Round inputRounds) {
        int rounds = inputRounds.getRound();

        for (int i = 0; i < rounds; i++) {
            cars.moveAll();
            OutputView.printGameResult(cars);
        }
    }
}

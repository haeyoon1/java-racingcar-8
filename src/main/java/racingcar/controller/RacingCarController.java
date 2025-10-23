package racingcar.controller;

import racingcar.model.Game;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    public void run() {
        String inputCars = InputView.inputCars();
        int inputRounds = InputView.inputRound();

        Game game = new Game();
        Cars winners = game.carRacing(inputCars, inputRounds);

        OutputView.printGameWinner(winners);
    }
}

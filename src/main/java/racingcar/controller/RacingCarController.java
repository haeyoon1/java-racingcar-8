package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Game;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    public void run() {
        String inputCarNames = InputView.inputCars();
        int inputRounds = InputView.inputRound();

        Game game = new Game();
        Cars winners = game.carRacing(inputCarNames, inputRounds);

        OutputView.printGameWinner(winners);
    }
}

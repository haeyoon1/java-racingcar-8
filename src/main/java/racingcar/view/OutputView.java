package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {

    public static void printGameResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printGameWinner(Cars cars) {
        List<Car> CarList = cars.getCars();
        String winnersCars = CarList.stream()
            .map(Car::getName)
            .collect(Collectors.joining(","));

        System.out.println("최종 우승자 : " + winnersCars);
    }
}

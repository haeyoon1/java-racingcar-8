package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.exception.Message;

public class WinningCarTest {

    @Test
    void 우승한_자동차들을_WinningCars_객체에_정상_저장한다() {
        // given
        List<Car> winningCarList = List.of(
            new Car("car1"),
            new Car("car2")
        );

        // when
        WinningCars winningCars = new WinningCars(winningCarList);
        List<Car> carsResult = winningCars.getCars();

        // then
        assertThat(carsResult).isEqualTo(winningCarList);
    }

    @Test
    void 우승한_자동차가_없을때_오류를_반환한다() {
        // given
        List<Car> winningCarList = List.of();

        // when, then
        assertThatThrownBy(() -> new WinningCars(winningCarList))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.WINNING_CAR_LIST_EMPTY.getMessage());
    }

}

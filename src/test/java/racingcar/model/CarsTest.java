package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.exception.Message;

class CarsTest {

    @Test
    void 자동차_리스트를_Cars_객체에_정상_저장한다() {
        // given
        String carNames = "car1,car2,car3";
        List<String> carNamesList = Arrays.asList(carNames.split(","));

        // when
        Cars cars = new Cars(carNames);
        List<Car> carsResult = cars.getCars();

        // then
        assertThat(carsResult)
            .extracting(Car::getName)
            .containsExactlyElementsOf(carNamesList);
    }

    @Test
    void 중복된_자동차_이름이_입력시_오류가_발생한다() {
        // given
        String carNames = "car1,car1,car2";

        // when, then
        assertThatThrownBy(() -> new Cars(carNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.DUPLICATE_CAR_NAME.getMessage());

    }

    @Test
    void 빈_문자열이_입력될_시_오류가_발생한다() {
        // given
        String emptyInput = "";

        // when, then
        assertThatThrownBy(() -> new Cars(emptyInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.EMPTY_CAR_INPUT.getMessage());
    }

    @Test
    void 구분자만_입력_시_오류가_발생한다() {
        // given
        String emptyInput = ",,";

        // when, then
        assertThatThrownBy(() -> new Cars(emptyInput))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.EMPTY_CAR_INPUT.getMessage());
    }

    @Test
    void 자동차는_2개_이상_입력되어야합니다() {
        // given
        String carNames = "car1";

        // when, then
        assertThatThrownBy(() -> new Cars(carNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.INVALID_CAR_INPUT.getMessage());
    }

}

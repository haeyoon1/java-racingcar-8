package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.exception.Message;

class CarTest {

    @Test
    void 자동차_객체를_정상적으로_저장한다() {
        // given
        String name = "nam";

        // when
        Car car = new Car(name);
        String carName = car.getName();

        // then
        assertThat(carName).isEqualTo(name);
    }

    @Test
    void 자동차_이름이_6글자_이상일_때_에러를_반환한다() {
        // given
        String carName = "abcdefg";

        //when, then
        assertThatThrownBy(() -> new Car(carName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.CAR_NAME_MAX_LENGTH_LIMIT.getMessage());
    }

    @Test
    void 자동차_이름은_공백이_될_수_없습니다() {
        // given
        String carName = "";

        // when, then
        assertThatThrownBy(() -> new Car(carName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.CAR_NAME_MIN_LENGTH_LIMIT.getMessage());
    }

}

package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.exception.Message;

class RoundTest {

    @Test
    void 시도_횟수_입력값이_1_이상일_때_Round_객체를_정상적으로_저장한다() {
        // given
        int validRound = 3;

        // when
        Round round = new Round(validRound);

        // then
        assertThat(round.value()).isEqualTo(validRound);
    }

    @Test
    void 시도_횟수_입력값이_0일_때_에러가_발생한다() {
        // given
        int invalidRound = 0;

        // when, then
        assertThatThrownBy(() -> new Round(invalidRound))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.INVALID_ROUND_INPUT.getMessage());
    }

    @Test
    void 시도_횟수_입력값이_음수일_때_에러가_발생한다() {
        // given
        int invalidRound = -5;

        // when, then
        assertThatThrownBy(() -> new Round(invalidRound))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Message.INVALID_ROUND_INPUT.getMessage());
    }
}

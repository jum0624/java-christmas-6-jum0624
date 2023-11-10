package christmas.util;

import christmas.util.InputUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputUtilTest {
    @Test
    @DisplayName("입력 시, 숫자가 아닌 경우 예외가 발생한다.")
    public void inputOrderDateTest() throws Exception {
        // given
        String input = "가나다";

        // when

        // then
        Assertions.assertThatThrownBy(() -> InputUtil.inputOrderDate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해주세요.");
    }
}

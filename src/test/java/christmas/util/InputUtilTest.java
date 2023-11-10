package christmas.util;

import christmas.util.InputUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

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

    @Test
    @DisplayName("입력 시 ,를 기준으로 입력하지 않았을 경우, 예외가 발생한다.")
    public void inputCommaExceptionTest() throws Exception {
        // given
        String input1 = "가나다-1 ,가나다-2";
        String input2 = "가나다-1.가나다-2";
        String input3 = "가나다-1 가나다-2";

        // when
        // then
        Assertions.assertThatThrownBy(() -> InputUtil.inputOrderMenu(input1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 입력입니다.");
        Assertions.assertThatThrownBy(() -> InputUtil.inputOrderMenu(input2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 입력입니다.");
        Assertions.assertThatThrownBy(() -> InputUtil.inputOrderMenu(input3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 입력입니다.");
    }

    @Test
    @DisplayName("입력 시 수량을 숫자로 입력하지 않은 경우 예외가 발생한다.")
    public void inputHyphenExceptionTest1() throws Exception {
        // given
        String input = "가나다-한개,가나다-두개";

        // when
        // then
        Assertions.assertThatThrownBy(() -> InputUtil.inputOrderMenu(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해주세요.");
    }

    @Test
    @DisplayName("입력 시 -기준으로 메뉴를 작성하지 않은 경우 예외가 발생한다.")
    public void inputHyphenExceptionTest2() throws Exception {
        // given
        String input = "가나다/한개,가나다/두개";

        // when
        // then
        Assertions.assertThatThrownBy(() -> InputUtil.inputOrderMenu(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 입력입니다.");
    }
}

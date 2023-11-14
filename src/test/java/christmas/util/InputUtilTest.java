package christmas.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputUtilTest {
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
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        Assertions.assertThatThrownBy(() -> InputUtil.inputOrderMenu(input2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        Assertions.assertThatThrownBy(() -> InputUtil.inputOrderMenu(input3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
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
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
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
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("중복된 메뉴를 입력한 경우 예외가 발생한다.")
    public void validateDuplicateMenuExceptionTest() throws Exception {
        // given
        String input = "제로콜라-1,제로콜라-1";

        // when
        // then
        Assertions.assertThatThrownBy(() -> InputUtil.inputOrderMenu(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("메뉴 갯수를 1개 이하로 입력한 경우 예외가 발생한다.")
    public void validateMenuCountRangeExceptionTest() throws Exception {
        // given
        String input = "양송이수프-1,제로콜라-0";

        // when
        // then
        Assertions.assertThatThrownBy(() -> InputUtil.inputOrderMenu(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 메뉴의 개수는 1 이상의 숫자만 입력되도록 해주세요.");
    }
}

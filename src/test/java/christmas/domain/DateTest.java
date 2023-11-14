package christmas.domain;

import christmas.domain.Date.Date;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DateTest {
    @Test
    @DisplayName("입력 시, 숫자가 아닌 경우 예외가 발생한다.")
    public void inputOrderDateTest() throws Exception {
        // given
        String input1 = "가나다";
        String input2 = "1 ";

        // when
        // then
        Assertions.assertThatThrownBy(() -> Date.of(input1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        Assertions.assertThatThrownBy(() -> Date.of(input2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("1일 ~ 31일 이외의 숫자 입력 시, 예외가 발생한다.")
    public void inputDateRangeExceptionTest() throws Exception {
        // given
        String day1 = "0";
        String day2 = "32";

        // when
        // then
        Assertions.assertThatThrownBy(() -> Date.of(day1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");

        Assertions.assertThatThrownBy(() -> Date.of(day2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("날짜를 입력하면 요일 정보를 가져올 수 있다.")
    public void getDayOfWeekTest() throws Exception {
        // given
        String day = "24";

        // when
        Date date = Date.of(day);

        // then
        Assertions.assertThat(date.getDateOfWeek()).isEqualTo(7);
    }
}

package christmas;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DateTest {
    @Test
    @DisplayName("1일 ~ 31일 이외의 숫자 입력 시, 예외가 발생한다.")
    public void inputDateRangeExceptionTest() throws Exception {
        // given
        int day1 = 0;
        int day2 = 32;

        // when
        // then
        Assertions.assertThatThrownBy(() -> new Date(day1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 날짜입니다. 다시 입력해 주세요.");

        Assertions.assertThatThrownBy(() -> new Date(day2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("날짜를 입력하면 요일 정보를 가져올 수 있다.")
    public void getDayOfWeekTest() throws Exception {
        // given
        int day = 24;

        // when
        Date date = new Date(day);

        // then
        Assertions.assertThat(date.findDateOfWeek()).isEqualTo(7);
    }
}

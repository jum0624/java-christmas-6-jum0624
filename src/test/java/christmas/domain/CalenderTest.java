package christmas.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalenderTest {
    @Test
    @DisplayName("스페셜 데이일 경우 참을 반환한다.")
    public void findSpecialDayTrueTest() throws Exception {
        // given
        int day = 25;
        
        // when
        Calender findDay = Calender.findByDay(day);

        // then
        Assertions.assertThat(findDay.isSpecialDay()).isTrue();
    }

    @Test
    @DisplayName("스페셜 데이가 아닐 경우 거짓을 반환한다.")
    public void findSpecialDayFalseTest() throws Exception {
        // given
        int day = 28;

        // when
        Calender findDay = Calender.findByDay(day);

        // then
        Assertions.assertThat(findDay.isSpecialDay()).isFalse();
    }
}

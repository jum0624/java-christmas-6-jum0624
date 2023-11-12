package christmas;

import christmas.domain.Menu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuTest {
    @Test
    @DisplayName("주문한 메뉴가 존재하는지 확인한다.")
    public void checkExistMenuTest() throws Exception {
        // given
        String menu = "양송이수프";

        // when
        Menu orderedMenu = Menu.findByMenuName(menu);

        // then
        Assertions.assertThat(orderedMenu).isEqualTo(Menu.MENU1);
    }
}

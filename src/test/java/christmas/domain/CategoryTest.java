package christmas.domain;

import christmas.domain.order.Category;
import christmas.domain.order.Menu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class CategoryTest {
    @Test
    @DisplayName("음료 카테고리만 존재하는지 확인한다.")
    public void isOnlyDrinkTest() throws Exception {
        // given
        Map<Menu, Integer> orderMenu = Map.of(Menu.MENU10, 1);

        // when
        // then
        Assertions.assertThat(Category.isOnlyDrink(orderMenu)).isTrue();
    }
}

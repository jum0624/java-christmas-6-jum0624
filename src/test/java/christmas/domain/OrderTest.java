package christmas.domain;

import christmas.domain.order.Menu;
import christmas.domain.order.Order;
import christmas.util.InputUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class OrderTest {
    @Test
    @DisplayName("존재하지 않는 메뉴를 입력한 경우 예외가 발생한다.")
    public void validateNotExistMenuExceptionTest() throws Exception {
        // given
        String input = "라면-1,제로콜라-1";
        Map<String, Integer> orderMenu = InputUtil.inputOrderMenu(input);

        // when
        // then
        Assertions.assertThatThrownBy(() -> Order.of(orderMenu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("주문한 메뉴의 갯수가 20개 이상일 경우 예외가 발생한다.")
    public void validateMenuCountExceptionTest() throws Exception {
        // given
        String input = "티본스테이크-1,바비큐립-1,초코케이크-18,제로콜라-1";
        Map<String, Integer> orderMenu = InputUtil.inputOrderMenu(input);

        // when
        // then
        Assertions.assertThatThrownBy(() -> Order.of(orderMenu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("음료 카테고리만 주문한 경우 예외가 발생한다.")
    public void validateMenuCategoryExceptionTest() throws Exception {
        // given
        String input = "제로콜라-1";
        Map<String, Integer> orderMenu = InputUtil.inputOrderMenu(input);

        // when
        // then
        Assertions.assertThatThrownBy(() -> Order.of(orderMenu))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("메뉴를 주문한다.")
    public void createOrderTest() throws Exception {
        // given
        String input = "티본스테이크-1,바비큐립-1";
        Map<String, Integer> orderMenu = InputUtil.inputOrderMenu(input);

        // when
        Order order = Order.of(orderMenu);
        Map<Menu, Integer> orders = order.getOrders();

        // then
        Assertions.assertThat(order.getOrders()).isNotEmpty()
                .containsKey(Menu.MENU4)
                .containsKey(Menu.MENU5);
    }
}

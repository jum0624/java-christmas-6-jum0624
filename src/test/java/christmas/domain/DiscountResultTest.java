package christmas.domain;

import christmas.config.ApplicationConfig;
import christmas.domain.event.DiscountResult;
import christmas.domain.Date.Date;
import christmas.domain.order.Order;
import christmas.service.OrderService;
import christmas.util.InputUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class DiscountResultTest {
    private final ApplicationConfig applicationConfig = new ApplicationConfig();
    private final OrderService orderService = new OrderService(applicationConfig.discountPolicy());
    @Test
    @DisplayName("메뉴 주문 시 이벤트에 따른 할인 혜택이 적용된다.")
    public void discountTest1() throws Exception {
        // given
        String inputDate = "3";
        String inputOrder = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Map<String, Integer> orders = InputUtil.inputOrderMenu(inputOrder);
        Date date = Date.of(inputDate);
        Order order = Order.of(orders);

        // when
        DiscountResult discountResult = orderService.discount(date, order);

        // then
        Assertions.assertThat(discountResult.getTotalDiscountPrice()).isEqualTo(-31246);
    }

    @Test
    @DisplayName("메뉴 주문 시 10000원 이하일 경우 할인이 적용되지 않는다.")
    public void discountTest2() throws Exception {
        // given
        String inputDate = "26";
        String inputOrder = "타파스-1,제로콜라-1";
        Map<String, Integer> orders = InputUtil.inputOrderMenu(inputOrder);
        Date date = Date.of(inputDate);
        Order order = Order.of(orders);

        // when
        DiscountResult discountResult = orderService.discount(date, order);

        // then
        Assertions.assertThat(discountResult.getTotalDiscountPrice()).isEqualTo(0);
    }

    @Test
    @DisplayName("특별 할인 날짜인 경우 특별 할인이 적용된다.")
    public void specialDiscountEventTest() throws Exception {
        // given
        String inputDate = "24";
        String inputOrder = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Map<String, Integer> orders = InputUtil.inputOrderMenu(inputOrder);
        Date date = Date.of(inputDate);
        Order order = Order.of(orders);

        // when
        DiscountResult discountResult = orderService.discount(date, order);

        // then
        Assertions.assertThat(discountResult.getTotalDiscountPrice()).isEqualTo(-33346);
    }
}

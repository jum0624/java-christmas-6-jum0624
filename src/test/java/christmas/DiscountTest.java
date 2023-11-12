package christmas;

import christmas.discount.DiscountCalculator;
import christmas.domain.Date;
import christmas.domain.Order;
import christmas.service.DiscountService;
import christmas.util.InputUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class DiscountTest {
    private DiscountService discountService = new DiscountService(new DiscountCalculator());
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
        DiscountCalculator discountCalculator = discountService.discountEvent(date, order);

        // then
        Assertions.assertThat(discountCalculator.getTotalDiscount()).isEqualTo(-31246);
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
        DiscountCalculator discountCalculator = discountService.discountEvent(date, order);

        // then
        Assertions.assertThat(discountCalculator.getTotalDiscount()).isEqualTo(0);
    }
}

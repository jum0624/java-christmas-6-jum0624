package christmas.domain.event.discountPolicy;

import christmas.domain.Date.Date;
import christmas.domain.order.Order;

public interface DiscountPolicy {
    boolean isPriceOver(int price);
    int discount(Date date, Order order);
    String getDiscountPolicy();
}

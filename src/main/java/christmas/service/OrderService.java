package christmas.service;

import christmas.domain.event.Badge;
import christmas.domain.Date.Date;
import christmas.domain.event.DiscountResult;
import christmas.domain.order.Order;

public class OrderService {
    private final DiscountResult discountResult;

    public OrderService(DiscountResult discountResult) {
        this.discountResult = discountResult;
    }

    public DiscountResult discount(Date date, Order order) {
        discountResult.applyDiscount(date, order);
        return discountResult;
    }

    public Badge getBadge(int totalDiscountPrice) {
        return Badge.findBadge(totalDiscountPrice);
    }
}

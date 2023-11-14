package christmas.service;

import christmas.domain.Badge;
import christmas.domain.Date;
import christmas.domain.DiscountResult;
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

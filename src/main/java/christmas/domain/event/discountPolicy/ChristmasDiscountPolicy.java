package christmas.domain.event.discountPolicy;

import christmas.domain.order.Date;
import christmas.domain.order.Order;

import static christmas.constant.StringConstant.CHRISTMAS_DISCOUNT_POLICY;

public class ChristmasDiscountPolicy implements DiscountPolicy {
    private final int discount;

    public ChristmasDiscountPolicy() {
        this.discount = -1000;
    }

    @Override
    public boolean isPriceOver(int price) {
        return price >= 10000;
    }

    public boolean isBeforeChristmas(int day) {
        return day >= 1 && day <= 25;
    }

    @Override
    public int discount(Date date, Order order) {
        if (isPriceOver(order.getTotalPrice()) && isBeforeChristmas(date.getDay())) {
            return discount - 100 * (date.getDay() - 1);
        }
        return 0;
    }

    @Override
    public String getDiscountPolicy() {
        return CHRISTMAS_DISCOUNT_POLICY.getMessage();
    }
}

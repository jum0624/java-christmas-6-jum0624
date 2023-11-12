package christmas.discount;

import christmas.domain.Date;
import christmas.domain.Order;

public class ChristmasDiscountPolicy implements DiscountPolicy {
    private Date date;
    private Order order;
    private int discount = -1000;

    private ChristmasDiscountPolicy(Date date, Order order) {
        this.date = date;
        this.order = order;
    }

    public static ChristmasDiscountPolicy discountPolicy(Date date, Order order) {
        return new ChristmasDiscountPolicy(date, order);
    }

    @Override
    public boolean isPriceOver() {
        return order.getTotalPrice() >= 10000;
    }

    public boolean isBeforeChristmas() {
        return date.getDay() >= 1 || date.getDay() <= 25;
    }

    @Override
    public int discount() {
        if (isPriceOver() && isBeforeChristmas()) {
            return discount - 100 * (date.getDay() - 1);
        }
        return 0;
    }

    @Override
    public String toStringDiscount() {
        return "크리스마스 디데이 할인: " + discount();
    }
}
